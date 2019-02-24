package com.eilikce.osm.entity.consumer;

import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

/**
 * 对原始commodity的拓展
 * 包含一级分类名称和二级分类名称
 * @author Eilik
 *
 */
@Alias("CommodityFurther")
public class CommodityFurtherPo extends CommodityPo {
	private String groupName;
	private String itemName;

	public CommodityFurtherPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityFurtherPo(String groupName, String itemName, Integer id, String commodityId, Integer groupId,
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
}
