package com.eilikce.osm.entity.consumer;

import java.util.List;

import com.eilikce.osm.entity.CommonEntityPo;
import org.apache.ibatis.type.Alias;

@Alias("CommodityGroupItem")
public class CommodityGroupItemPo extends CommonEntityPo {
	private Integer groupId;
	private String groupName;
	private List<CommodityItemPo> commodityItemPoList;

	public CommodityGroupItemPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityGroupItemPo(Integer groupId, String groupName, List<CommodityItemPo> commodityItemPoList) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.commodityItemPoList = commodityItemPoList;
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

	public List<CommodityItemPo> getCommodityItemPoList() {
		return commodityItemPoList;
	}

	public void setCommodityItemPoList(List<CommodityItemPo> commodityItemPoList) {
		this.commodityItemPoList = commodityItemPoList;
	}

}
