package com.eilikce.osm.entity.consumer;

import java.sql.Timestamp;
import java.util.List;

public class RecordOrderFurther extends RecordOrder{
	
	private List<RecordOrderCommodity> recordOrderCommodityList ;

	public RecordOrderFurther() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecordOrderFurther(Integer id, String orderId, Float totalCost, Float totalPrice, Float totalProfit,
			String consumerAddr, String consumerName, String consumerPhone, String consumerId, Integer paymentStatus,
			Integer orderInvalid, String orderCancelDetail, Timestamp orderDate, List<RecordOrderCommodity> recordOrderCommodityList) {
		super(id, orderId, totalCost, totalPrice, totalProfit, consumerAddr, consumerName, consumerPhone, consumerId,
				paymentStatus, orderInvalid, orderCancelDetail, orderDate);
		
		this.recordOrderCommodityList = recordOrderCommodityList;
	}

	public List<RecordOrderCommodity> getRecordOrderCommodityList() {
		return recordOrderCommodityList;
	}

	public void setRecordOrderCommodityList(List<RecordOrderCommodity> recordOrderCommodityList) {
		this.recordOrderCommodityList = recordOrderCommodityList;
	}

	@Override
	public String toString() {
		return "RecordOrderFurther [recordOrderCommodityList=" + recordOrderCommodityList + "]";
	}

}
