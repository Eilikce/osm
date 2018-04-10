package com.eilikce.osm.core.bo.transformable;

import java.sql.Timestamp;
import java.util.List;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.core.handler.RecordOrderBoHandler;
import com.eilikce.osm.entity.consumer.RecordOrderPo;
import com.eilikce.osm.entity.consumer.RecordOrderFurtherPo;

public class RecordOrder extends EntityTransBo<RecordOrderPo>{
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
	private String orderInvalidShow;
	private String orderCancelDetail;
	private Timestamp orderDate;
	private List<RecordOrderCommodity> recordOrderCommodityBoList;

	public RecordOrder(RecordOrderPo recordOrder) {
		super();
		this.id = recordOrder.getId();
		this.orderId = recordOrder.getOrderId();
		this.totalCost = recordOrder.getTotalCost();
		this.totalPrice = recordOrder.getTotalPrice();
		this.totalProfit = recordOrder.getTotalProfit();
		this.consumerAddr = recordOrder.getConsumerAddr();
		this.consumerName = recordOrder.getConsumerName();
		this.consumerPhone = recordOrder.getConsumerPhone();
		this.consumerId = recordOrder.getConsumerId();
		this.paymentStatus = recordOrder.getPaymentStatus();
		this.orderInvalid = recordOrder.getOrderInvalid();
		this.orderInvalidShow = orderInvalidShowCreater(recordOrder.getOrderInvalid());
		this.orderCancelDetail = recordOrder.getOrderCancelDetail();
		this.orderDate = recordOrder.getOrderDate();
		this.recordOrderCommodityBoList = null;
	}
	
	public RecordOrder(RecordOrderFurtherPo recordOrderFurther) {
		super();
		this.id = recordOrderFurther.getId();
		this.orderId = recordOrderFurther.getOrderId();
		this.totalCost = recordOrderFurther.getTotalCost();
		this.totalPrice = recordOrderFurther.getTotalPrice();
		this.totalProfit = recordOrderFurther.getTotalProfit();
		this.consumerAddr = recordOrderFurther.getConsumerAddr();
		this.consumerName = recordOrderFurther.getConsumerName();
		this.consumerPhone = recordOrderFurther.getConsumerPhone();
		this.consumerId = recordOrderFurther.getConsumerId();
		this.paymentStatus = recordOrderFurther.getPaymentStatus();
		this.orderInvalid = recordOrderFurther.getOrderInvalid();
		this.orderInvalidShow = orderInvalidShowCreater(recordOrderFurther.getOrderInvalid());
		this.orderCancelDetail = recordOrderFurther.getOrderCancelDetail();
		this.orderDate = recordOrderFurther.getOrderDate();
		this.recordOrderCommodityBoList = BoTransHandler.entityListToBoList(RecordOrderCommodity.class, recordOrderFurther.getRecordOrderCommodityList());
	}

	public RecordOrder(Consumer consumerBo) {
		this.id = null;
		this.consumerAddr = consumerBo.getAddr();
		this.consumerName = consumerBo.getName();
		this.consumerPhone = consumerBo.getPhone();
		this.consumerId = consumerBo.getConsumerId();
		this.orderId = RecordOrderBoHandler.orderIdCreater(consumerBo);
	}
	
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

	public String getOrderInvalidShow() {
		return orderInvalidShow;
	}

	public void setOrderInvalidShow(String orderInvalidShow) {
		this.orderInvalidShow = orderInvalidShow;
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

	public List<RecordOrderCommodity> getRecordOrderCommodityBoList() {
		return recordOrderCommodityBoList;
	}

	public void setRecordOrderCommodityBoList(List<RecordOrderCommodity> recordOrderCommodityBoList) {
		this.recordOrderCommodityBoList = recordOrderCommodityBoList;
	}

	/**
	 * 填充订单
	 * @param totalCost
	 * @param totalPrice
	 * @param totalProfit
	 * @param orderInvalid
	 * @param paymentStatus
	 * @param orderCancelDetail
	 * @param orderDate
	 * @param recordOrderCommodityBoList
	 */
	public void fillRecordOrderBo(Float totalCost, Float totalPrice, Float totalProfit, Integer paymentStatus, Integer orderInvalid,
			String orderCancelDetail, Timestamp orderDate, List<RecordOrderCommodity> recordOrderCommodityBoList) {
		this.totalCost = totalCost;
		this.totalPrice = totalPrice;
		this.totalProfit = totalProfit;
		this.paymentStatus = paymentStatus;
		this.orderInvalid = orderInvalid;
		this.orderInvalidShow = orderInvalidShowCreater(orderInvalid);
		this.orderCancelDetail = orderCancelDetail;
		this.orderDate = orderDate;
		this.recordOrderCommodityBoList = recordOrderCommodityBoList;
	}
	
	/**
	 * 根据orderInvalid生成orderInvalidShow文字
	 * @param orderInvalid
	 * @return
	 */
	private String orderInvalidShowCreater(int orderInvalid){
		String orderInvalidShow = orderInvalid==1?"取消":"生效";
		return orderInvalidShow;
	}

	@Override
	public String toString() {
		return "RecordOrderBo [id=" + id + ", orderId=" + orderId + ", totalCost=" + totalCost + ", totalPrice="
				+ totalPrice + ", totalProfit=" + totalProfit + ", consumerAddr=" + consumerAddr + ", consumerName="
				+ consumerName + ", consumerPhone=" + consumerPhone + ", consumerId=" + consumerId + ", paymentStatus="
				+ paymentStatus + ", orderInvalid=" + orderInvalid + ", orderInvalidShow=" + orderInvalidShow
				+ ", orderCancelDetail=" + orderCancelDetail + ", orderDate=" + orderDate
				+ ", recordOrderCommodityBoList=" + recordOrderCommodityBoList + "]";
	}

}
