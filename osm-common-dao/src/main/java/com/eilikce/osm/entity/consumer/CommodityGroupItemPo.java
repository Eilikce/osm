package com.eilikce.osm.entity.consumer;

import java.util.List;

import com.eilikce.osm.entity.CommonEntityPo;

public class CommodityGroupItemPo extends CommonEntityPo{
	private Integer id;
	private Integer groupId;
	private String groupName;
	private List<CommodityItemPo> commodityItemList;

	public CommodityGroupItemPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityGroupItemPo(Integer id, Integer groupId, String groupName, List<CommodityItemPo> commodityItemList) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.groupName = groupName;
		this.commodityItemList = commodityItemList;
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

	public List<CommodityItemPo> getCommodityItemList() {
		return commodityItemList;
	}

	public void setCommodityItemList(List<CommodityItemPo> commodityItemList) {
		this.commodityItemList = commodityItemList;
	}

	@Override
	public String toString() {
		return "CommodityGroup [id=" + id + ", groupId=" + groupId + ", groupName=" + groupName
				+ ", commodityItemList=" + commodityItemList + "]";
	}

}
