package com.eilikce.osm.entity.consumer;

import java.util.List;

public class CommodityGroupItem {
	private Integer id;
	private Integer groupId;
	private String groupName;
	private List<CommodityItem> commodityItemList;

	public CommodityGroupItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityGroupItem(Integer id, Integer groupId, String groupName, List<CommodityItem> commodityItemList) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.groupName = groupName;
		this.commodityItemList = commodityItemList;
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
		return "CommodityGroup [id=" + id + ", groupId=" + groupId + ", groupName=" + groupName
				+ ", commodityItemList=" + commodityItemList + "]";
	}

}
