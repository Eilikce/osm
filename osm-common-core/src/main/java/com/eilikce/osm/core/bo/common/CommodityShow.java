package com.eilikce.osm.core.bo.common;

import java.io.File;
import java.sql.Timestamp;

import com.eilikce.osm.core.bo.CommonBo;
import com.eilikce.osm.core.bo.transformable.Commodity;
import com.eilikce.osm.core.handler.CommodityHandler;
import com.eilikce.osm.entity.consumer.CommodityPo;
import com.eilikce.osm.entity.consumer.CommodityFurtherPo;
import com.eilikce.osm.util.DateFormatUtil;

/**
 * 主要用于展示商品信息 
 * 包含一级分类名称和二级分类名称
 * 包含img图片路径 包含img图片名称
 * 
 * @author Eilik
 *
 */
public class CommodityShow implements CommonBo {
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
	private String createDate;

	private String groupName;
	private String itemName;

	private String imgPath;
	private String imgName;
	private String imgSrc;

	public CommodityShow() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 通过CommodityFurther对象，创建CommodityShow对象
	 * 
	 * @param commodityFurther
	 */
	public CommodityShow(CommodityFurtherPo commodityFurther) {
		super();
		this.id = commodityFurther.getId();
		this.commodityId = commodityFurther.getCommodityId();
		this.groupId = commodityFurther.getGroupId();
		this.itemId = commodityFurther.getItemId();
		this.barcode = commodityFurther.getBarcode();
		this.commodityName = commodityFurther.getCommodityName();
		this.commodityDetail = commodityFurther.getCommodityDetail();
		this.imgRule = commodityFurther.getImgRule();
		this.number = commodityFurther.getNumber();
		this.original = commodityFurther.getOriginal();
		this.price = commodityFurther.getPrice();
		this.unit = commodityFurther.getUnit();
		this.source = commodityFurther.getSource();
		this.detail = commodityFurther.getDetail();
		this.salesVolume = commodityFurther.getSalesVolume();
		this.shelves = commodityFurther.getShelves();
		this.createDate = DateFormatUtil.TimestampToString(commodityFurther.getCreateDate(), "yyyy-MM-dd HH:mm:ss");

		this.groupName = commodityFurther.getItemName();
		this.itemName = commodityFurther.getGroupName();

		this.imgPath = CommodityHandler.CommodityImgPath(commodityFurther.getImgRule());
		this.imgName = CommodityHandler.CommodityImgName(commodityFurther.getCommodityId(), commodityFurther.getImgRule());
		this.imgSrc = imgPath + File.separator + imgName;
	}

	/**
	 * 通过CommodityPo对象，创建CommodityShow对象
	 * 无法获得groupName和itemName
	 * 
	 * @param commodityPo
	 */
	public CommodityShow(CommodityPo commodityPo) {
		super();
		this.id = commodityPo.getId();
		this.commodityId = commodityPo.getCommodityId();
		this.groupId = commodityPo.getGroupId();
		this.itemId = commodityPo.getItemId();
		this.barcode = commodityPo.getBarcode();
		this.commodityName = commodityPo.getCommodityName();
		this.commodityDetail = commodityPo.getCommodityDetail();
		this.imgRule = commodityPo.getImgRule();
		this.number = commodityPo.getNumber();
		this.original = commodityPo.getOriginal();
		this.price = commodityPo.getPrice();
		this.unit = commodityPo.getUnit();
		this.source = commodityPo.getSource();
		this.detail = commodityPo.getDetail();
		this.salesVolume = commodityPo.getSalesVolume();
		this.shelves = commodityPo.getShelves();
		this.createDate = DateFormatUtil.TimestampToString(commodityPo.getCreateDate(), "yyyy-MM-dd HH:mm:ss");

		this.groupName = "";
		this.itemName = "";
		
		Commodity commodityBo = new Commodity(commodityPo);
		this.imgPath = CommodityHandler.CommodityImgPath(commodityBo);
		this.imgName = CommodityHandler.CommodityImgName(commodityBo);
		this.imgSrc = imgPath + File.separator + imgName;
	}
	
	/**
	 * 通过Commodity对象，创建CommodityShow对象
	 * 无法获得groupName和itemName
	 * 
	 * @param commodity
	 */
	public CommodityShow(Commodity commodity) {
		super();
		this.id = commodity.getId();
		this.commodityId = commodity.getCommodityId();
		this.groupId = commodity.getGroupId();
		this.itemId = commodity.getItemId();
		this.barcode = commodity.getBarcode();
		this.commodityName = commodity.getCommodityName();
		this.commodityDetail = commodity.getCommodityDetail();
		this.imgRule = commodity.getImgRule();
		this.number = commodity.getNumber();
		this.original = commodity.getOriginal();
		this.price = commodity.getPrice();
		this.unit = commodity.getUnit();
		this.source = commodity.getSource();
		this.detail = commodity.getDetail();
		this.salesVolume = commodity.getSalesVolume();
		this.shelves = commodity.getShelves();
		this.createDate = DateFormatUtil.TimestampToString(commodity.getCreateDate(), "yyyy-MM-dd HH:mm:ss");
		
		this.groupName = "";
		this.itemName = "";
		
		this.imgPath = CommodityHandler.CommodityImgPath(commodity);
		this.imgName = CommodityHandler.CommodityImgName(commodity);
		this.imgSrc = imgPath + File.separator + imgName;
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
	/**
	 * 返回commodity对象
	 * @return
	 */
	public CommodityPo commodityTransform() {
		Timestamp createDate = DateFormatUtil.StringToTimestamp(this.createDate, "yyyy-MM-dd HH:mm:ss");
		CommodityPo commodity = new CommodityPo(id, commodityId, groupId, itemId, barcode, commodityName, commodityDetail,imgRule, number, original, price, unit, source, commodityDetail, salesVolume, shelves, createDate);
		return commodity;
	}
	
	@Override
	public String toString() {
		return "CommodityShow [id=" + id + ", commodityId=" + commodityId + ", groupId=" + groupId + ", itemId="
				+ itemId + ", barcode=" + barcode + ", commodityName=" + commodityName + ", commodityDetail="
				+ commodityDetail + ", imgRule=" + imgRule + ", number=" + number + ", original=" + original
				+ ", price=" + price + ", unit=" + unit + ", source=" + source + ", detail=" + detail + ", salesVolume="
				+ salesVolume + ", shelves=" + shelves + ", createDate=" + createDate + ", groupName=" + groupName
				+ ", itemName=" + itemName + ", imgPath=" + imgPath + ", imgName=" + imgName + ", imgSrc=" + imgSrc
				+ "]";
	}

}
