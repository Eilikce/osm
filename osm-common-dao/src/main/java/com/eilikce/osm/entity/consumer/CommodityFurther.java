package com.eilikce.osm.entity.consumer;

import java.sql.Timestamp;

/**
 * 对原始commodity的拓展
 * 包含一级分类名称和二级分类名称
 * @author Eilik
 *
 */
public class CommodityFurther extends Commodity {
	private String groupName;
	private String itemName;

	public CommodityFurther() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityFurther(String groupName, String itemName, Integer id, String commodityId, Integer groupId,
                            Integer itemId, Integer barcode, String commodityName, String commodityDetail, String imgRule,
                            Integer number, Float original, Float price, String unit, String source, String detail, Integer salesVolume,
                            Integer shelves, Timestamp createDate) {
		super(commodityId, groupId, itemId, barcode, commodityName, commodityDetail, imgRule, number, original,
				price, unit, source, detail, salesVolume, shelves, createDate);
		this.groupName = groupName;
		this.itemName = itemName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "CommodityFurther [groupName=" + groupName + ", itemName=" + itemName + ", toString()=" + super.toString()
				+ "]";
	}
}
