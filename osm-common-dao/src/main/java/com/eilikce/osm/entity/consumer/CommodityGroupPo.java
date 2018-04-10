package com.eilikce.osm.entity.consumer;

import com.eilikce.osm.entity.CommonEntityPo;

public class CommodityGroupPo extends CommonEntityPo{
	private Integer id;
	private Integer groupId;
	private String groupName;

	public CommodityGroupPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityGroupPo(Integer id, Integer groupId, String groupName) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.groupName = groupName;
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

	@Override
	public String toString() {
		return "CommodityGroup [id=" + id + ", groupId=" + groupId + ", groupName=" + groupName + "]";
	}

}
