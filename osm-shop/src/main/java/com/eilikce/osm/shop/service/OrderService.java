package com.eilikce.osm.shop.service;

import java.util.List;

import com.eilikce.osm.core.bo.common.Cart;
import com.eilikce.osm.core.bo.transformable.Consumer;
import com.eilikce.osm.core.bo.transformable.RecordOrder;
import com.eilikce.osm.core.bo.transformable.RecordOrderCommodity;

public interface OrderService {

	/** 获取全部订单数量 **/
	int getCount();
	
	/** 获取全部订单详情 测试使用 **/
	List<RecordOrder> getAllOrderBo();
	
	/** 获取总页数 **/
	int findTotalPage(int pageSize);

	/** 获取全部订单详情 根据页码 **/
	List<RecordOrder> getOrderBoByPage(int page, int pageSize);

	/** 获取订单商品列表 根据订单id **/
	List<RecordOrderCommodity> getOrderCommodityBoById(String orderId);

	/** 获取新页的数据条数 **/
	int findCountByPage(int page, int pageSize);
	
	/** 提交订单 **/
	boolean orderSubmit(Cart cart, Consumer consumerBo);
	
	/** 用购物车中商品生成账单 **/
	RecordOrder orderBoCreate(Cart cart, Consumer consumerBo);
	
	/** 新增订单入库 **/
	void addorderBo(RecordOrder recordOrderBo);
	
	/** 修改支付状态 **/
	void updatePaymentStatus(RecordOrder recordOrderBo,boolean paymentStatus);

	/** 修改支付状态，根据订单号 **/
	void updatePaymentStatusById(String orderId,boolean paymentStatus);
}
