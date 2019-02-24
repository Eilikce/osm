package com.eilikce.osm.core.bo.transformable;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.entity.consumer.CommodityGroupItem;

public class CommodityGroup extends EntityTransBo<com.eilikce.osm.entity.consumer.CommodityGroup>{
	private Integer groupId;
	private String groupName;

	public CommodityGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityGroup(Integer groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}

	public CommodityGroup(CommodityGroupItem commodityGroupItem) {
		super();
		this.groupId = commodityGroupItem.getGroupId();
		this.groupName = commodityGroupItem.getGroupName();
	}

	public CommodityGroup(com.eilikce.osm.entity.consumer.CommodityGroup commodityGroup) {
		super();
		this.groupId = commodityGroup.getGroupId();
		this.groupName = commodityGroup.getGroupName();
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

	@Override
	public String toString() {
		return "CommodityGroup [groupId=" + groupId + ", groupName=" + groupName + "]";
	}

}
