package com.eilikce.osm.core.bo.transformable;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.entity.consumer.CommodityGroupPo;
import com.eilikce.osm.entity.consumer.CommodityGroupItemPo;

public class CommodityGroup extends EntityTransBo<CommodityGroupPo>{
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

	public CommodityGroup(CommodityGroupItemPo commodityGroupItem) {
		super();
		this.groupId = commodityGroupItem.getGroupId();
		this.groupName = commodityGroupItem.getGroupName();
	}

	public CommodityGroup(CommodityGroupPo commodityGroup) {
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
