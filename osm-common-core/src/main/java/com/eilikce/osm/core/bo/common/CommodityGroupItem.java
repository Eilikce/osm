package com.eilikce.osm.core.bo.common;

import java.util.List;

import com.eilikce.osm.core.bo.CommonBo;
import com.eilikce.osm.core.bo.transformable.CommodityItem;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.entity.consumer.CommodityGroupItemPo;
import com.eilikce.osm.entity.consumer.CommodityGroupPo;

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

	public CommodityGroupItem(CommodityGroupItemPo commodityGroupItemPo) {
		super();
		this.groupId = commodityGroupItemPo.getGroupId();
		this.groupName = commodityGroupItemPo.getGroupName();
		this.commodityItemBoList = BoTransHandler.entityListToBoList(CommodityItem.class, commodityGroupItemPo.getCommodityItemPoList());
	}

	public CommodityGroupItem(CommodityGroupPo commodityGroupPo) {
		super();
		this.groupId = commodityGroupPo.getGroupId();
		this.groupName = commodityGroupPo.getGroupName();
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
		return "CommodityGroupItemPo [groupId=" + groupId + ", groupName=" + groupName + ", commodityItemBoList="
				+ commodityItemBoList + "]";
	}

}
