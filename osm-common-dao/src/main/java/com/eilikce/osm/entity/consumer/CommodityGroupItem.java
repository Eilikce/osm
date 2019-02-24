package com.eilikce.osm.entity.consumer;

import java.util.List;

import com.eilikce.osm.entity.CommonEntity;

public class CommodityGroupItem extends CommonEntity {
	private Integer groupId;
	private String groupName;
	private List<CommodityItem> commodityItemList;

	public CommodityGroupItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityGroupItem(Integer groupId, String groupName, List<CommodityItem> commodityItemList) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.commodityItemList = commodityItemList;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<CommodityItem> getCommodityItemList() {
		return commodityItemList;
	}

	public void setCommodityItemList(List<CommodityItem> commodityItemList) {
		this.commodityItemList = commodityItemList;
	}

	@Override
	public String toString() {
		return "CommodityGroupItem [groupId=" + groupId + ", groupName=" + groupName + ", commodityItemList="
				+ commodityItemList + "]";
	}

}
