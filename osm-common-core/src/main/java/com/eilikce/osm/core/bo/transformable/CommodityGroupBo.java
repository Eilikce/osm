package com.eilikce.osm.core.bo.transformable;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.entity.consumer.CommodityGroup;
import com.eilikce.osm.entity.consumer.CommodityGroupItem;

public class CommodityGroupBo extends EntityTransBo<CommodityGroup>{
	private Integer id;
	private Integer groupId;
	private String groupName;

	public CommodityGroupBo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityGroupBo(Integer groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}

	public CommodityGroupBo(CommodityGroupItem commodityGroupItem) {
		super();
		this.id = commodityGroupItem.getId();
		this.groupId = commodityGroupItem.getGroupId();
		this.groupName = commodityGroupItem.getGroupName();
	}

	public CommodityGroupBo(CommodityGroup commodityGroup) {
		super();
		this.id = commodityGroup.getId();
		this.groupId = commodityGroup.getGroupId();
		this.groupName = commodityGroup.getGroupName();
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
		return "CommodityGroupBo [id=" + id + ", groupId=" + groupId + ", groupName=" + groupName + "]";
	}

}
