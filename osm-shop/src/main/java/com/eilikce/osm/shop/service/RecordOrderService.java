package com.eilikce.osm.shop.service;

import java.util.List;

import com.eilikce.osm.core.bo.Cart;
import com.eilikce.osm.core.bo.ConsumerBo;
import com.eilikce.osm.core.bo.RecordOrderBo;
import com.eilikce.osm.core.bo.RecordOrderCommodityBo;

public interface RecordOrderService {

	/** 获取全部订单数量 **/
	int getCount();
	
	/** 获取全部订单详情 测试使用 **/
	List<RecordOrderBo> getAllRecordOrderBo();
	
	/** 获取总页数 **/
	int findTotalPage(int pageSize);

	/** 获取全部订单详情 根据页码 **/
	List<RecordOrderBo> getRecordOrderBoByPage(int page, int pageSize);

	/** 获取订单商品列表 根据订单id **/
	List<RecordOrderCommodityBo> getRecordOrderCommodityBoById(String orderId);

	/** 获取新页的数据条数 **/
	int findCountByPage(int page, int pageSize);
	
	/** 用购物车中商品生成账单 **/
	RecordOrderBo recordOrderBoCreate(Cart cart, ConsumerBo consumerBo);
	
	/** 新增订单入库 **/
	void addRecordOrderBo(RecordOrderBo recordOrderBo);
	
	/** 修改支付状态 **/
	void updatePaymentStatus(RecordOrderBo recordOrderBo,boolean paymentStatus);

	/** 修改支付状态，根据订单号 **/
	void updatePaymentStatusById(String orderId,boolean paymentStatus);
}
