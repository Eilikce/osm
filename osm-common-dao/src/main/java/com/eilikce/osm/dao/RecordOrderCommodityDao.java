package com.eilikce.osm.dao;

import java.util.List;

import com.eilikce.osm.entity.consumer.RecordOrderCommodityPo;

public interface RecordOrderCommodityDao {
	
	/** 获取总数 **/
	Integer selectCount();

	/** 获取订单商品列表 根据订单id **/
	List<RecordOrderCommodityPo> selectRecordOrderCommodityListByOrderId(String orderId);
	
	
	
	/***************** 插入操作 *****************/

	/** 插入一条订单商品记录 **/
	int insertRecordOrderCommodity(RecordOrderCommodityPo recordOrderCommodity);
	
	/** 一次性插入多条订单商品记录 **/
	int insertRecordOrderCommodityList(List<RecordOrderCommodityPo> recordOrderCommodityList);
}
