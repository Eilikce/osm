package com.eilikce.osm.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.bo.Cart;
import com.eilikce.osm.core.bo.ConsumerBo;
import com.eilikce.osm.core.bo.RecordOrderBo;
import com.eilikce.osm.core.bo.RecordOrderCommodityBo;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.core.handler.RecordOrderBoHandler;
import com.eilikce.osm.dao.RecordOrderCommodityDao;
import com.eilikce.osm.dao.RecordOrderDao;
import com.eilikce.osm.entity.consumer.RecordOrder;
import com.eilikce.osm.entity.consumer.RecordOrderCommodity;
import com.eilikce.osm.entity.consumer.RecordOrderFurther;

@Service
public class RecordOrderServiceImpl implements RecordOrderService {

	private static Logger logger = Logger.getLogger(RecordOrderServiceImpl.class);

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
	public List<RecordOrderBo> getAllRecordOrderBo() {
		List<RecordOrderBo> recordOrderBoList = new ArrayList<RecordOrderBo>();
		List<RecordOrderFurther> recordOrderFurtherList = recordOrderDao.selectAllRecordOrderFurther();
		recordOrderBoList = RecordOrderBoHandler.recordOrderBoListTransform(recordOrderFurtherList);
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
	public List<RecordOrderBo> getRecordOrderBoByPage(int page, int pageSize) {
		List<RecordOrderBo> recordOrderBoList = new ArrayList<RecordOrderBo>();
		List<RecordOrderFurther> recordOrderFurtherList = recordOrderDao.selectRecordOrderFurtherByPage(page, pageSize);
		recordOrderBoList = RecordOrderBoHandler.recordOrderBoListTransform(recordOrderFurtherList);
		return recordOrderBoList;
	}

	@Override
	public List<RecordOrderCommodityBo> getRecordOrderCommodityBoById(String orderId) {
		List<RecordOrderCommodityBo> recordOrderCommodityBoList = new ArrayList<RecordOrderCommodityBo>();
		List<RecordOrderCommodity> recordOrderCommodityList = recordOrderCommodityDao.selectRecordOrderCommodityListByOrderId(orderId);
		recordOrderCommodityBoList = BoTransHandler.entityListToBoList(RecordOrderCommodityBo.class, recordOrderCommodityList);//实体对象转换为bo对象
		return recordOrderCommodityBoList;
	}

	@Override
	public int findCountByPage(int page, int pageSize) {
		int count = recordOrderDao.selectCountByPage(page, pageSize);
		return count;
	}

	@Override
	public void addRecordOrderBo(RecordOrderBo recordOrderBo) {
		RecordOrder recordOrder = recordOrderBo.transToEntity(RecordOrder.class);
		List<RecordOrderCommodityBo> recordOrderCommodityBoList = recordOrderBo.getRecordOrderCommodityBoList();
		List<RecordOrderCommodity> recordOrderCommodityList = BoTransHandler.boListToEntityList(recordOrderCommodityBoList,RecordOrderCommodity.class);
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
		
		logger.info("插入一条订单，订单号为："+recordOrder.getOrderId()+"。包含订单商品号："+recordOrderCommodityIds);
		logger.debug("订单插入成功 "+recordOrderCount+" 条，订单商品插入成功 "+recordOrderCommodityListCount+" 条");
	}

	@Override
	public RecordOrderBo recordOrderBoCreate(Cart cart, ConsumerBo consumerBo) {
		RecordOrderBo recordOrderBo = RecordOrderBoHandler.recordOrderBoCreater(cart,consumerBo);
		logger.debug("新订单生成，订单号："+recordOrderBo);
		return recordOrderBo;
	}

	@Override
	public void updatePaymentStatus(RecordOrderBo recordOrderBo, boolean paymentStatus) {
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

}
