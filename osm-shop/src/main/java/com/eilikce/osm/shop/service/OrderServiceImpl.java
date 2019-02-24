package com.eilikce.osm.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.bo.common.Cart;
import com.eilikce.osm.core.bo.transformable.ConsumerInfo;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.core.handler.RecordOrderHandler;
import com.eilikce.osm.dao.RecordOrderCommodityDao;
import com.eilikce.osm.dao.RecordOrderDao;
import com.eilikce.osm.entity.consumer.RecordOrder;
import com.eilikce.osm.entity.consumer.RecordOrderCommodity;
import com.eilikce.osm.entity.consumer.RecordOrderFurther;

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private RecordOrderDao recordOrderDao;
	@Autowired
	private RecordOrderCommodityDao recordOrderCommodityDao;

	@Value("${osm.record.order.pageSize}")  
	private int pageSize;
	
	@Override
	public int getCount() {
		int count = recordOrderDao.selectCount();
		LOG.info("订单总数为：" + count);
		return count;
	}

	@Override
	public List<com.eilikce.osm.core.bo.transformable.RecordOrder> getAllOrderBo() {
		List<com.eilikce.osm.core.bo.transformable.RecordOrder> recordOrderBoList = new ArrayList<com.eilikce.osm.core.bo.transformable.RecordOrder>();
		List<RecordOrderFurther> recordOrderFurtherList = recordOrderDao.selectAllRecordOrderFurther();
		recordOrderBoList = RecordOrderHandler.recordOrderListTransform(recordOrderFurtherList);
		LOG.debug("读取全部订单详情信息："+recordOrderBoList);
		return recordOrderBoList;
	}

	@Override
	public int findTotalPage() {
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
	public List<com.eilikce.osm.core.bo.transformable.RecordOrder> getOrderBoByPage(int page) {
		List<com.eilikce.osm.core.bo.transformable.RecordOrder> recordOrderBoList = new ArrayList<com.eilikce.osm.core.bo.transformable.RecordOrder>();
		List<RecordOrderFurther> recordOrderFurtherList = recordOrderDao.selectRecordOrderFurtherByPage(page, pageSize);
		recordOrderBoList = RecordOrderHandler.recordOrderListTransform(recordOrderFurtherList);
		return recordOrderBoList;
	}

	@Override
	public List<com.eilikce.osm.core.bo.transformable.RecordOrderCommodity> getOrderCommodityBoById(String orderId) {
		List<com.eilikce.osm.core.bo.transformable.RecordOrderCommodity> recordOrderCommodityBoList = new ArrayList<com.eilikce.osm.core.bo.transformable.RecordOrderCommodity>();
		List<RecordOrderCommodity> recordOrderCommodityList = recordOrderCommodityDao.selectRecordOrderCommodityListByOrderId(orderId);
		recordOrderCommodityBoList = BoTransHandler.entityListToBoList(com.eilikce.osm.core.bo.transformable.RecordOrderCommodity.class, recordOrderCommodityList);//实体对象转换为bo对象
		return recordOrderCommodityBoList;
	}

	@Override
	public int findCountByPage(int page) {
		int count = recordOrderDao.selectCountByPage(page, pageSize);
		return count;
	}

	@Override
	public boolean orderSubmit(Cart cart, ConsumerInfo consumerInfo) {
		boolean flag = false;
		try {
			com.eilikce.osm.core.bo.transformable.RecordOrder recordOrderBo = orderBoCreate(cart, consumerInfo);
			addorderBo(recordOrderBo);
			flag = true;
			LOG.info("订单创建成功，订单号：" + recordOrderBo.getOrderId() + "，用户id：" + consumerInfo.getConsumerId() + "，用户名称："+consumerInfo.getName());
		}catch(Exception e) {
			LOG.error("订单创建失败，用户id：" + consumerInfo.getConsumerId() + "，用户名称："+consumerInfo.getName(),e);
		}
		return flag;
	}
	
	@Override
	public void addorderBo(com.eilikce.osm.core.bo.transformable.RecordOrder recordOrderBo) {
		RecordOrder recordOrder = recordOrderBo.transToEntity(RecordOrder.class);
		List<com.eilikce.osm.core.bo.transformable.RecordOrderCommodity> recordOrderCommodityBoList = recordOrderBo.getRecordOrderCommodityBoList();
		List<RecordOrderCommodity> recordOrderCommodityList = BoTransHandler.boListToEntityList(recordOrderCommodityBoList, RecordOrderCommodity.class);
		int recordOrderCount = recordOrderDao.insertRecordOrder(recordOrder);
		int recordOrderCommodityListCount = recordOrderCommodityDao.insertRecordOrderCommodityList(recordOrderCommodityList);
		
		StringBuffer recordOrderCommodityIds = new StringBuffer();
		boolean firstFlag = true;
		for(RecordOrderCommodity r : recordOrderCommodityList){
			if(firstFlag){
				recordOrderCommodityIds.append(r.getOrderCommodityId());
				firstFlag = false;
			}else{
				recordOrderCommodityIds.append(r.getOrderCommodityId()+",");
			}
		}
		
		LOG.info("插入一条订单，订单号为："+recordOrder.getOrderId()+"。包含订单商品号："+recordOrderCommodityIds);
		LOG.debug("订单插入成功 "+recordOrderCount+" 条，订单商品插入成功 "+recordOrderCommodityListCount+" 条");
	}

	@Override
	public com.eilikce.osm.core.bo.transformable.RecordOrder orderBoCreate(Cart cart, ConsumerInfo consumerInfo) {
		com.eilikce.osm.core.bo.transformable.RecordOrder recordOrderBo = RecordOrderHandler.recordOrderCreater(cart,consumerInfo);
		LOG.debug("新订单生成，订单号："+recordOrderBo);
		return recordOrderBo;
	}

	@Override
	public void updatePaymentStatus(com.eilikce.osm.core.bo.transformable.RecordOrder recordOrderBo, boolean paymentStatus) {
		if(paymentStatus){
			recordOrderBo.setPaymentStatus(1);
			RecordOrder recordOrder = recordOrderBo.transToEntity(RecordOrder.class);
			recordOrderDao.updatePaymentStatus(recordOrder);
		}else{
			recordOrderBo.setPaymentStatus(0);
			RecordOrder recordOrder = recordOrderBo.transToEntity(RecordOrder.class);
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

	@Override
	public int findRecordOrderPageSize() {
		return pageSize;
	}

}
