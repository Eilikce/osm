package com.eilikce.osm.entity.consumer;

import com.eilikce.osm.entity.CommonEntityPo;
import org.apache.ibatis.type.Alias;

@Alias("CommodityGroup")
public class CommodityGroupPo extends CommonEntityPo {
	private Integer groupId;
	private String groupName;

	public CommodityGroupPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityGroupPo(Integer groupId, String groupName) {
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

}
