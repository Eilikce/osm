package com.eilikce.osm.entity.consumer;

import com.eilikce.osm.entity.CommonEntity;

public class CommodityGroup extends CommonEntity {
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
