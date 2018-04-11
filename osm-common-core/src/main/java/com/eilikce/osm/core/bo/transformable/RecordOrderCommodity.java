package com.eilikce.osm.core.bo.transformable;

import java.sql.Timestamp;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.core.bo.common.CommodityShow;
import com.eilikce.osm.core.handler.RecordOrderCommodityBoHandler;
import com.eilikce.osm.entity.consumer.RecordOrderCommodityPo;
import com.eilikce.osm.util.MathUtil;

public class RecordOrderCommodity extends EntityTransBo<RecordOrderCommodityPo>{
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
	
	private Float totalOriginal;
	private Float totalPrice;
	private Float totalProfit;

	public RecordOrderCommodity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecordOrderCommodity(RecordOrderCommodityPo recordOrderCommodity) {
		super();
		this.id = recordOrderCommodity.getId();
		this.orderCommodityId = recordOrderCommodity.getOrderCommodityId();
		this.orderId = recordOrderCommodity.getOrderId();
		this.commodityId = recordOrderCommodity.getCommodityId();
		this.commodityName = recordOrderCommodity.getCommodityName();
		this.commodityDetail = recordOrderCommodity.getCommodityDetail();
		this.barcode = recordOrderCommodity.getBarcode();
		this.groupName = recordOrderCommodity.getGroupName();
		this.itemName = recordOrderCommodity.getItemName();
		this.unit = recordOrderCommodity.getUnit();
		this.original = recordOrderCommodity.getOriginal();
		this.price = recordOrderCommodity.getPrice();
		this.profit = recordOrderCommodity.getProfit();
		this.salesVolume = recordOrderCommodity.getSalesVolume();
		this.salesDate = recordOrderCommodity.getSalesDate();

		this.totalOriginal = MathUtil.multiplcativeRound2(original, salesVolume);
		this.totalPrice = MathUtil.multiplcativeRound2(price, salesVolume);
		this.totalProfit = MathUtil.multiplcativeRound2(profit, salesVolume);
	}

	public RecordOrderCommodity(CommodityShow commodityShow,String orderId,ConsumerInfo consumerInfo) {
		super();
		this.id = commodityShow.getId();
		this.orderId = orderId;
		this.commodityId = commodityShow.getCommodityId();
		this.commodityName = commodityShow.getCommodityName();
		this.commodityDetail = commodityShow.getCommodityDetail();
		this.barcode = commodityShow.getBarcode();
		this.groupName = commodityShow.getGroupName();
		this.itemName = commodityShow.getItemName();
		this.unit = commodityShow.getUnit();
		this.original = commodityShow.getOriginal();
		this.price = commodityShow.getPrice();
		this.salesVolume = commodityShow.getSalesVolume();
		this.salesDate = null;

		this.orderCommodityId = RecordOrderCommodityBoHandler.orderCommodityIdCreater(consumerInfo, orderId, commodityId);
		this.profit = MathUtil.subtractionRound2(original, price);
		this.totalOriginal = MathUtil.multiplcativeRound2(original, salesVolume);
		this.totalPrice = MathUtil.multiplcativeRound2(price, salesVolume);
		this.totalProfit = MathUtil.multiplcativeRound2(profit, salesVolume);
		
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

	public Float getTotalOriginal() {
		return totalOriginal;
	}

	public void setTotalOriginal(Float totalOriginal) {
		this.totalOriginal = totalOriginal;
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


	@Override
	public String toString() {
		return "RecordOrderCommodityBo [id=" + id + ", orderCommodityId=" + orderCommodityId + ", orderId=" + orderId
				+ ", commodityId=" + commodityId + ", commodityName=" + commodityName + ", commodityDetail="
				+ commodityDetail + ", barcode=" + barcode + ", groupName=" + groupName + ", itemName=" + itemName
				+ ", unit=" + unit + ", original=" + original + ", price=" + price + ", profit=" + profit
				+ ", salesVolume=" + salesVolume + ", salesDate=" + salesDate + ", totalOriginal=" + totalOriginal
				+ ", totalPrice=" + totalPrice + ", totalProfit=" + totalProfit + "]";
	}

	@Override
	public void transHook(RecordOrderCommodityPo entity) {
		this.totalOriginal = MathUtil.multiplcativeRound2(original, salesVolume);
		this.totalPrice = MathUtil.multiplcativeRound2(price, salesVolume);
		this.totalProfit = MathUtil.multiplcativeRound2(profit, salesVolume);
	}

}
