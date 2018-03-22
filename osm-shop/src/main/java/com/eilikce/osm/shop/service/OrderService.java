package com.eilikce.osm.shop.service;

import java.util.List;

import com.eilikce.osm.core.bo.common.Cart;
import com.eilikce.osm.core.bo.transformable.ConsumerBo;
import com.eilikce.osm.core.bo.transformable.RecordOrderBo;
import com.eilikce.osm.core.bo.transformable.RecordOrderCommodityBo;

public interface OrderService {

	/** 获取全部订单数量 **/
	int getCount();
	
	/** 获取全部订单详情 测试使用 **/
	List<RecordOrderBo> getAllOrderBo();
	
	/** 获取总页数 **/
	int findTotalPage(int pageSize);

	/** 获取全部订单详情 根据页码 **/
	List<RecordOrderBo> getOrderBoByPage(int page, int pageSize);

	/** 获取订单商品列表 根据订单id **/
	List<RecordOrderCommodityBo> getOrderCommodityBoById(String orderId);

	/** 获取新页的数据条数 **/
	int findCountByPage(int page, int pageSize);
	
	/** 提交订单 **/
	boolean orderSubmit(Cart cart, ConsumerBo consumerBo);
	
	/** 用购物车中商品生成账单 **/
	RecordOrderBo orderBoCreate(Cart cart, ConsumerBo consumerBo);
	
	/** 新增订单入库 **/
	void addorderBo(RecordOrderBo recordOrderBo);
	
	/** 修改支付状态 **/
	void updatePaymentStatus(RecordOrderBo recordOrderBo,boolean paymentStatus);

	/** 修改支付状态，根据订单号 **/
	void updatePaymentStatusById(String orderId,boolean paymentStatus);
}
