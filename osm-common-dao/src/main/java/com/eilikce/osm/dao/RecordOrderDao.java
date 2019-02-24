package com.eilikce.osm.dao;

import java.util.List;

import com.eilikce.osm.entity.consumer.RecordOrderPo;
import com.eilikce.osm.entity.consumer.RecordOrderFurtherPo;

public interface RecordOrderDao {
	
	/** 获取总数 **/
	Integer selectCount();
	
	/** 获取全部订单详情 **/
	List<RecordOrderFurtherPo> selectAllRecordOrderFurther();

	/** 获取全部订单详情 根据页码 **/
	List<RecordOrderFurtherPo> selectRecordOrderFurtherByPage(int page, int pageSize);

	/** 获取某一个页数下的商品总条数 **/
	int selectCountByPage(int page, int pageSize);
	
	
	/***************** 插入操作 *****************/
	
	/** 插入一条订单记录 **/
	int insertRecordOrder(RecordOrderPo recordOrderPo);

	/***************** 更新操作 *****************/
	
	/** 更新一条订单记录 **/
	int updateRecordOrderById(RecordOrderPo recordOrderPo);

	/** 更新一条订单记录的支付状态 **/
	int updatePaymentStatus(RecordOrderPo recordOrderPo);

	/** 更新一条订单记录的支付状态，根据id **/
	int updatePaymentStatusById(String orderId, int paymentStatus);
	
	/***************** 删除操作 *****************/
	
}
