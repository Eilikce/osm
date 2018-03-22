package com.eilikce.osm.core.bo.transformable;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.entity.consumer.CommodityItem;

public class CommodityItemBo extends EntityTransBo<CommodityItem>{
	private Integer id;
	private Integer groupId;
	private Integer itemId;
	private String itemName;
	private String imgName;
	private String imgSrc;

	public CommodityItemBo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityItemBo(Integer groupId, Integer itemId, String itemName, String imgName, String imgSrc) {
		super();
		this.groupId = groupId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.imgName = imgName;
		this.imgSrc = imgSrc;
	}

	public CommodityItemBo(CommodityItem commodityItem) {
		super();
		this.id = commodityItem.getId();
		this.groupId = commodityItem.getGroupId();
		this.itemId = commodityItem.getItemId();
		this.itemName = commodityItem.getItemName();
		this.imgName = commodityItem.getImgName();
		this.imgSrc = commodityItem.getImgSrc();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "CommodityItem [id=" + id + ", groupId=" + groupId + ", itemId=" + itemId + ", itemName=" + itemName
				+ ", imgName=" + imgName + ", imgSrc=" + imgSrc + "]";
	}

}
