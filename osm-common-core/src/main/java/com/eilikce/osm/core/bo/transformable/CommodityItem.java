package com.eilikce.osm.core.bo.transformable;

import com.eilikce.osm.core.bo.EntityTransBo;

public class CommodityItem extends EntityTransBo<com.eilikce.osm.entity.consumer.CommodityItem>{
	private Integer groupId;
	private Integer itemId;
	private String itemName;
	private String imgName;
	private String imgSrc;

	public CommodityItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityItem(Integer groupId, Integer itemId, String itemName, String imgName, String imgSrc) {
		super();
		this.groupId = groupId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.imgName = imgName;
		this.imgSrc = imgSrc;
	}

	public CommodityItem(com.eilikce.osm.entity.consumer.CommodityItem commodityItem) {
		super();
		this.groupId = commodityItem.getGroupId();
		this.itemId = commodityItem.getItemId();
		this.itemName = commodityItem.getItemName();
		this.imgName = commodityItem.getImgName();
		this.imgSrc = commodityItem.getImgSrc();
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	@Override
	public String toString() {
		return "CommodityItem [groupId=" + groupId + ", itemId=" + itemId + ", itemName=" + itemName + ", imgName="
				+ imgName + ", imgSrc=" + imgSrc + "]";
	}

}
