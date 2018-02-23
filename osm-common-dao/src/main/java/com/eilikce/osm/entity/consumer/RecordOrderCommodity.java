package com.eilikce.osm.entity.consumer;

import java.sql.Timestamp;

import com.eilikce.osm.entity.CommonEntity;

public class RecordOrderCommodity extends CommonEntity{
	private Integer id;
	private String orderCommodityId;
	private String orderId;
	private String commodityId;
	private String commodityName;
	private String commodityDetail;
	private Integer barcode;
	private String groupName;
	private String itemName;
	private String unit;
	private Float original;
	private Float price;
	private Float profit;
	private Integer salesVolume;
	private Timestamp salesDate;

	public RecordOrderCommodity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecordOrderCommodity(Integer id, String orderCommodityId, String orderId, String commodityId,
			String commodityName, String commodityDetail, Integer barcode, String groupName, String itemName,
			String unit, Float original, Float price, Float profit, Integer salesVolume, Timestamp salesDate) {
		super();
		this.id = id;
		this.orderCommodityId = orderCommodityId;
		this.orderId = orderId;
		this.commodityId = commodityId;
		this.commodityName = commodityName;
		this.commodityDetail = commodityDetail;
		this.barcode = barcode;
		this.groupName = groupName;
		this.itemName = itemName;
		this.unit = unit;
		this.original = original;
		this.price = price;
		this.profit = profit;
		this.salesVolume = salesVolume;
		this.salesDate = salesDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderCommodityId() {
		return orderCommodityId;
	}

	public void setOrderCommodityId(String orderCommodityId) {
		this.orderCommodityId = orderCommodityId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommodityDetail() {
		return commodityDetail;
	}

	public void setCommodityDetail(String commodityDetail) {
		this.commodityDetail = commodityDetail;
	}

	public Integer getBarcode() {
		return barcode;
	}

	public void setBarcode(Integer barcode) {
		this.barcode = barcode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Float getOriginal() {
		return original;
	}

	public void setOriginal(Float original) {
		this.original = original;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getProfit() {
		return profit;
	}

	public void setProfit(Float profit) {
		this.profit = profit;
	}

	public Integer getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}

	public Timestamp getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Timestamp salesDate) {
		this.salesDate = salesDate;
	}

	@Override
	public String toString() {
		return "RecordOrderCommodity [id=" + id + ", orderCommodityId=" + orderCommodityId + ", orderId=" + orderId
				+ ", commodityId=" + commodityId + ", commodityName=" + commodityName + ", commodityDetail="
				+ commodityDetail + ", barcode=" + barcode + ", groupName=" + groupName + ", itemName=" + itemName
				+ ", unit=" + unit + ", original=" + original + ", price=" + price + ", profit=" + profit
				+ ", salesVolume=" + salesVolume + ", salesDate=" + salesDate + "]";
	}

}
