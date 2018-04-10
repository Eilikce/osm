package com.eilikce.osm.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.bo.common.Cart;
import com.eilikce.osm.core.bo.transformable.Consumer;
import com.eilikce.osm.core.bo.transformable.RecordOrder;
import com.eilikce.osm.core.bo.transformable.RecordOrderCommodity;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.core.handler.RecordOrderHandler;
import com.eilikce.osm.dao.RecordOrderCommodityDao;
import com.eilikce.osm.dao.RecordOrderDao;
import com.eilikce.osm.entity.consumer.RecordOrderPo;
import com.eilikce.osm.entity.consumer.RecordOrderCommodityPo;
import com.eilikce.osm.entity.consumer.RecordOrderFurtherPo;

@Service
public class OrderServiceImpl implements OrderService {

	private static Logger logger = Logger.getLogger(OrderServiceImpl.class);

	@Autowired
	private RecordOrderDao recordOrderDao;
	@Autowired
	private RecordOrderCommodityDao recordOrderCommodityDao;

	@Override
	public int getCount() {
		int count = recordOrderDao.selectCount();
		logger.info("订单总数为：" + count);
		return count;
	}

	@Override
	public List<RecordOrder> getAllOrderBo() {
		List<RecordOrder> recordOrderBoList = new ArrayList<RecordOrder>();
		List<RecordOrderFurtherPo> recordOrderFurtherList = recordOrderDao.selectAllRecordOrderFurther();
		recordOrderBoList = RecordOrderHandler.recordOrderListTransform(recordOrderFurtherList);
		logger.debug("读取全部订单详情信息："+recordOrderBoList);
		return recordOrderBoList;
	}

	@Override
	public int findTotalPage(int pageSize) {
		int count = recordOrderDao.selectCount();

		// 如果订单总数为0，则直接返回总页数为1
		if (count == 0) {
			return 1;
		}

		int totalPageTmp = count / pageSize;
		int remainder = count % pageSize;
		int totalPage = remainder == 0 ? totalPageTmp : totalPageTmp + 1;
		return totalPage;
	}

	@Override
	public List<RecordOrder> getOrderBoByPage(int page, int pageSize) {
		List<RecordOrder> recordOrderBoList = new ArrayList<RecordOrder>();
		List<RecordOrderFurtherPo> recordOrderFurtherList = recordOrderDao.selectRecordOrderFurtherByPage(page, pageSize);
		recordOrderBoList = RecordOrderHandler.recordOrderListTransform(recordOrderFurtherList);
		return recordOrderBoList;
	}

	@Override
	public List<RecordOrderCommodity> getOrderCommodityBoById(String orderId) {
		List<RecordOrderCommodity> recordOrderCommodityBoList = new ArrayList<RecordOrderCommodity>();
		List<RecordOrderCommodityPo> recordOrderCommodityList = recordOrderCommodityDao.selectRecordOrderCommodityListByOrderId(orderId);
		recordOrderCommodityBoList = BoTransHandler.entityListToBoList(RecordOrderCommodity.class, recordOrderCommodityList);//实体对象转换为bo对象
		return recordOrderCommodityBoList;
	}

	@Override
	public int findCountByPage(int page, int pageSize) {
		int count = recordOrderDao.selectCountByPage(page, pageSize);
		return count;
	}

	@Override
	public boolean orderSubmit(Cart cart, Consumer consumerBo) {
		boolean flag = false;
		try {
			RecordOrder recordOrderBo = orderBoCreate(cart, consumerBo);
			addorderBo(recordOrderBo);
			flag = true;
			logger.info("订单创建成功，订单号：" + recordOrderBo.getOrderId() + "，用户id：" + consumerBo.getConsumerId() + "，用户名称："+consumerBo.getName());
		}catch(Exception e) {
			logger.error("订单创建失败，用户id：" + consumerBo.getConsumerId() + "，用户名称："+consumerBo.getName(),e);
		}
		return flag;
	}
	
	@Override
	public void addorderBo(RecordOrder recordOrderBo) {
		RecordOrderPo recordOrder = recordOrderBo.transToEntity(RecordOrderPo.class);
		List<RecordOrderCommodity> recordOrderCommodityBoList = recordOrderBo.getRecordOrderCommodityBoList();
		List<RecordOrderCommodityPo> recordOrderCommodityList = BoTransHandler.boListToEntityList(recordOrderCommodityBoList,RecordOrderCommodityPo.class);
		int recordOrderCount = recordOrderDao.insertRecordOrder(recordOrder);
		int recordOrderCommodityListCount = recordOrderCommodityDao.insertRecordOrderCommodityList(recordOrderCommodityList);
		
		StringBuffer recordOrderCommodityIds = new StringBuffer();
		boolean firstFlag = true;
		for(RecordOrderCommodityPo r : recordOrderCommodityList){
			if(firstFlag){
				recordOrderCommodityIds.append(r.getOrderCommodityId());
				firstFlag = false;
			}else{
				recordOrderCommodityIds.append(r.getOrderCommodityId()+",");
			}
		}
		
		logger.info("插入一条订单，订单号为："+recordOrder.getOrderId()+"。包含订单商品号："+recordOrderCommodityIds);
		logger.debug("订单插入成功 "+recordOrderCount+" 条，订单商品插入成功 "+recordOrderCommodityListCount+" 条");
	}

	@Override
	public RecordOrder orderBoCreate(Cart cart, Consumer consumerBo) {
		RecordOrder recordOrderBo = RecordOrderHandler.recordOrderCreater(cart,consumerBo);
		logger.debug("新订单生成，订单号："+recordOrderBo);
		return recordOrderBo;
	}

	@Override
	public void updatePaymentStatus(RecordOrder recordOrderBo, boolean paymentStatus) {
		if(paymentStatus){
			recordOrderBo.setPaymentStatus(1);
			RecordOrderPo recordOrder = recordOrderBo.transToEntity(RecordOrderPo.class); 
			recordOrderDao.updatePaymentStatus(recordOrder);
		}else{
			recordOrderBo.setPaymentStatus(0);
			RecordOrderPo recordOrder = recordOrderBo.transToEntity(RecordOrderPo.class); 
			recordOrderDao.updatePaymentStatus(recordOrder);
		}
	}

	@Override
	public void updatePaymentStatusById(String orderId, boolean paymentStatus) {
		if(paymentStatus){
			recordOrderDao.updatePaymentStatusById(orderId, 1);
		}else{
			recordOrderDao.updatePaymentStatusById(orderId, 0);
		}
	}

}
