package com.eilikce.osm.core.bo.transformable;

import java.sql.Timestamp;
import java.util.List;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.core.handler.OsmIdHandler;
import com.eilikce.osm.entity.consumer.RecordOrderFurtherPo;
import com.eilikce.osm.entity.consumer.RecordOrderPo;

/**
 * 订单
 * @author wanghw
 *
 */
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

	public RecordOrder(RecordOrderPo recordOrderPo) {
		super();
		this.id = recordOrderPo.getId();
		this.orderId = recordOrderPo.getOrderId();
		this.totalCost = recordOrderPo.getTotalCost();
		this.totalPrice = recordOrderPo.getTotalPrice();
		this.totalProfit = recordOrderPo.getTotalProfit();
		this.consumerAddr = recordOrderPo.getConsumerAddr();
		this.consumerName = recordOrderPo.getConsumerName();
		this.consumerPhone = recordOrderPo.getConsumerPhone();
		this.consumerId = recordOrderPo.getConsumerId();
		this.paymentStatus = recordOrderPo.getPaymentStatus();
		this.orderInvalid = recordOrderPo.getOrderInvalid();
		this.orderInvalidShow = orderInvalidShowCreater(recordOrderPo.getOrderInvalid());
		this.orderCancelDetail = recordOrderPo.getOrderCancelDetail();
		this.orderDate = recordOrderPo.getOrderDate();
		this.recordOrderCommodityBoList = null;
	}
	
	public RecordOrder(RecordOrderFurtherPo recordOrderFurtherPo) {
		super();
		this.id = recordOrderFurtherPo.getId();
		this.orderId = recordOrderFurtherPo.getOrderId();
		this.totalCost = recordOrderFurtherPo.getTotalCost();
		this.totalPrice = recordOrderFurtherPo.getTotalPrice();
		this.totalProfit = recordOrderFurtherPo.getTotalProfit();
		this.consumerAddr = recordOrderFurtherPo.getConsumerAddr();
		this.consumerName = recordOrderFurtherPo.getConsumerName();
		this.consumerPhone = recordOrderFurtherPo.getConsumerPhone();
		this.consumerId = recordOrderFurtherPo.getConsumerId();
		this.paymentStatus = recordOrderFurtherPo.getPaymentStatus();
		this.orderInvalid = recordOrderFurtherPo.getOrderInvalid();
		this.orderInvalidShow = orderInvalidShowCreater(recordOrderFurtherPo.getOrderInvalid());
		this.orderCancelDetail = recordOrderFurtherPo.getOrderCancelDetail();
		this.orderDate = recordOrderFurtherPo.getOrderDate();
		this.recordOrderCommodityBoList = BoTransHandler.entityListToBoList(RecordOrderCommodity.class, recordOrderFurtherPo.getRecordOrderCommodityPoList());
	}

	public RecordOrder(ConsumerInfo consumerInfo) {
		this.id = null;
		this.consumerAddr = consumerInfo.getAddr();
		this.consumerName = consumerInfo.getName();
		this.consumerPhone = consumerInfo.getPhone();
		this.consumerId = consumerInfo.getConsumerId();
		this.orderId = OsmIdHandler.orderIdCreater(consumerInfo);
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
	public void fillRecordOrder(Float totalCost, Float totalPrice, Float totalProfit, Integer paymentStatus, Integer orderInvalid,
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
