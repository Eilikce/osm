package com.eilikce.osm.core.bo.common;

import java.util.List;

import com.eilikce.osm.core.bo.transformable.CommodityItemBo;
import com.eilikce.osm.core.handler.BoTransHandler;
import com.eilikce.osm.entity.consumer.CommodityGroupPo;
import com.eilikce.osm.entity.consumer.CommodityGroupItemPo;

public class CommodityGroupItemBo {
	private Integer id;
	private Integer groupId;
	private String groupName;
	private List<CommodityItemBo> commodityItemBoList;

	public CommodityGroupItemBo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityGroupItemBo(Integer groupId, String groupName, List<CommodityItemBo> commodityItemBoList) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.commodityItemBoList = commodityItemBoList;
	}

	public CommodityGroupItemBo(CommodityGroupItemPo commodityGroupItem) {
		super();
		this.id = commodityGroupItem.getId();
		this.groupId = commodityGroupItem.getGroupId();
		this.groupName = commodityGroupItem.getGroupName();
		this.commodityItemBoList = BoTransHandler.entityListToBoList(CommodityItemBo.class, commodityGroupItem.getCommodityItemList());
	}

	public CommodityGroupItemBo(CommodityGroupPo commodityGroup) {
		super();
		this.id = commodityGroup.getId();
		this.groupId = commodityGroup.getGroupId();
		this.groupName = commodityGroup.getGroupName();
		this.commodityItemBoList = null;
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

	public List<CommodityItemBo> getCommodityItemBoList() {
		return commodityItemBoList;
	}

	public void setCommodityItemBoList(List<CommodityItemBo> commodityItemBoList) {
		this.commodityItemBoList = commodityItemBoList;
	}

	@Override
	public String toString() {
		return "CommodityGroupItemBo [id=" + id + ", groupId=" + groupId + ", groupName=" + groupName
				+ ", commodityItemBoList=" + commodityItemBoList + "]";
	}

}
