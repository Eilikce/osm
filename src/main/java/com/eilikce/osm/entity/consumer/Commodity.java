package com.eilikce.osm.entity.consumer;

import java.sql.Timestamp;

public class Commodity {
	private Integer id;
	private String commodityId;
	private Integer groupId;
	private Integer itemId;
	private Integer barcode;
	private String commodityName;
	private String commodityDetail;
	private String imgRule;
	private Integer number;
	private Float original;
	private Float price;
	private String unit;
	private String source;
	private String detail;
	private Integer salesVolume;
	private Integer shelves;
	private Timestamp createDate;

	public Commodity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commodity(Integer id, String commodityId, Integer groupId, Integer itemId, Integer barcode,
			String commodityName, String commodityDetail, String imgRule, Integer number, Float original, Float price,
			String unit, String source, String detail, Integer salesVolume, Integer shelves, Timestamp createDate) {
		super();
		this.id = id;
		this.commodityId = commodityId;
		this.groupId = groupId;
		this.itemId = itemId;
		this.barcode = barcode;
		this.commodityName = commodityName;
		this.commodityDetail = commodityDetail;
		this.imgRule = imgRule;
		this.number = number;
		this.original = original;
		this.price = price;
		this.unit = unit;
		this.source = source;
		this.detail = detail;
		this.salesVolume = salesVolume;
		this.shelves = shelves;
		this.createDate = createDate;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getBarcode() {
		return barcode;
	}

	public void setBarcode(Integer barcode) {
		this.barcode = barcode;
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

	public String getImgRule() {
		return imgRule;
	}

	public void setImgRule(String imgRule) {
		this.imgRule = imgRule;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}

	public Integer getShelves() {
		return shelves;
	}

	public void setShelves(Integer shelves) {
		this.shelves = shelves;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Commodity [id=" + id + ", commodityId=" + commodityId + ", groupId=" + groupId + ", itemId=" + itemId
				+ ", barcode=" + barcode + ", commodityName=" + commodityName + ", commodityDetail=" + commodityDetail
				+ ", imgRule=" + imgRule + ", number=" + number + ", original=" + original + ", price=" + price
				+ ", unit=" + unit + ", source=" + source + ", detail=" + detail + ", salesVolume=" + salesVolume
				+ ", shelves=" + shelves + ", createDate=" + createDate + "]";
	}
	
}
