package com.eilikce.osm.entity.consumer;

import java.util.List;

import com.eilikce.osm.entity.CommonEntityPo;

public class CommodityGroupItemPo extends CommonEntityPo{
	private Integer groupId;
	private String groupName;
	private List<CommodityItemPo> commodityItemList;

	public CommodityGroupItemPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityGroupItemPo(Integer groupId, String groupName, List<CommodityItemPo> commodityItemList) {
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

	public List<CommodityItemPo> getCommodityItemList() {
		return commodityItemList;
	}

	public void setCommodityItemList(List<CommodityItemPo> commodityItemList) {
		this.commodityItemList = commodityItemList;
	}

	@Override
	public String toString() {
		return "CommodityGroupItemPo [groupId=" + groupId + ", groupName=" + groupName + ", commodityItemList="
				+ commodityItemList + "]";
	}

}
