package com.eilikce.osm.core.bo.common;

import java.util.List;

import com.eilikce.osm.core.bo.CommonBo;
import com.eilikce.osm.core.bo.transformable.CommodityItem;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.entity.consumer.CommodityGroupPo;
import com.eilikce.osm.entity.consumer.CommodityGroupItemPo;

public class CommodityGroupItem implements CommonBo{
	private Integer groupId;
	private String groupName;
	private List<CommodityItem> commodityItemBoList;

	public CommodityGroupItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityGroupItem(Integer groupId, String groupName, List<CommodityItem> commodityItemBoList) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.commodityItemBoList = commodityItemBoList;
	}

	public CommodityGroupItem(CommodityGroupItemPo commodityGroupItem) {
		super();
		this.groupId = commodityGroupItem.getGroupId();
		this.groupName = commodityGroupItem.getGroupName();
		this.commodityItemBoList = BoTransHandler.entityListToBoList(CommodityItem.class, commodityGroupItem.getCommodityItemList());
	}

	public CommodityGroupItem(CommodityGroupPo commodityGroup) {
		super();
		this.groupId = commodityGroup.getGroupId();
		this.groupName = commodityGroup.getGroupName();
		this.commodityItemBoList = null;
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
		return commodityItemBoList;
	}

	public void setCommodityItemBoList(List<CommodityItem> commodityItemBoList) {
		this.commodityItemBoList = commodityItemBoList;
	}

	@Override
	public String toString() {
		return "CommodityGroupItem [groupId=" + groupId + ", groupName=" + groupName + ", commodityItemBoList="
				+ commodityItemBoList + "]";
	}

}
