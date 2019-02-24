package com.eilikce.osm.entity.consumer;

import java.sql.Timestamp;
import java.util.List;

import com.eilikce.osm.entity.CommonEntityPo;
import org.apache.ibatis.type.Alias;

@Alias("RecordOrderFurther")
public class RecordOrderFurtherPo extends CommonEntityPo {
	

	private Integer id;
	private String orderId;
	private Float totalCost;
	private Float totalPrice;
	private Float totalProfit;
	private String consumerAddr;
	private String consumerName;
	private String consumerPhone;
	private String consumerId;
	private Integer paymentStatus;
	private Integer orderInvalid;
	private String orderCancelDetail;
	private Timestamp orderDate;
	private List<RecordOrderCommodityPo> recordOrderCommodityPoList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Float getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(Float totalProfit) {
		this.totalProfit = totalProfit;
	}
	public String getConsumerAddr() {
		return consumerAddr;
	}
	public void setConsumerAddr(String consumerAddr) {
		this.consumerAddr = consumerAddr;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getConsumerPhone() {
		return consumerPhone;
	}
	public void setConsumerPhone(String consumerPhone) {
		this.consumerPhone = consumerPhone;
	}
	public String getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Integer getOrderInvalid() {
		return orderInvalid;
	}
	public void setOrderInvalid(Integer orderInvalid) {
		this.orderInvalid = orderInvalid;
	}
	public String getOrderCancelDetail() {
		return orderCancelDetail;
	}
	public void setOrderCancelDetail(String orderCancelDetail) {
		this.orderCancelDetail = orderCancelDetail;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public List<RecordOrderCommodityPo> getRecordOrderCommodityPoList() {
		return recordOrderCommodityPoList;
	}
	public void setRecordOrderCommodityPoList(List<RecordOrderCommodityPo> recordOrderCommodityPoList) {
		this.recordOrderCommodityPoList = recordOrderCommodityPoList;
	}
}
