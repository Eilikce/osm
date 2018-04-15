package com.eilikce.osm.entity.consumer;

import com.eilikce.osm.entity.CommonEntityPo;

public class CommodityItemPo extends CommonEntityPo{
	private Integer groupId;
	private Integer itemId;
	private String itemName;
	private String imgName;
	private String imgSrc;

	public CommodityItemPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityItemPo(Integer groupId, Integer itemId, String itemName, String imgName, String imgSrc) {
		super();
		this.groupId = groupId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.imgName = imgName;
		this.imgSrc = imgSrc;
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
		return "CommodityItemPo [groupId=" + groupId + ", itemId=" + itemId + ", itemName=" + itemName + ", imgName="
				+ imgName + ", imgSrc=" + imgSrc + "]";
	}

}
