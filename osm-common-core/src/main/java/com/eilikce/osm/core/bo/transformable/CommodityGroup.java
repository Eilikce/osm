package com.eilikce.osm.core.bo.transformable;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.entity.consumer.CommodityGroupItemPo;
import com.eilikce.osm.entity.consumer.CommodityGroupPo;

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

	public CommodityGroup(CommodityGroupItemPo commodityGroupItemPo) {
		super();
		this.groupId = commodityGroupItemPo.getGroupId();
		this.groupName = commodityGroupItemPo.getGroupName();
	}

	public CommodityGroup(CommodityGroupPo commodityGroupPo) {
		super();
		this.groupId = commodityGroupPo.getGroupId();
		this.groupName = commodityGroupPo.getGroupName();
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
		return "CommodityGroupPo [groupId=" + groupId + ", groupName=" + groupName + "]";
	}

}
