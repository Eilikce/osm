package com.eilikce.osm.core.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eilikce.osm.entity.consumer.CommodityGroup;
import com.eilikce.osm.entity.consumer.CommodityGroupItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eilikce.osm.core.bo.transformable.CommodityItem;

public class CommodityGroupHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(CommodityGroupHandler.class);
	
	/**
	 * 将CommodityGroupList转换为以groupName为键的name、id对照表map
	 * @param commodityGroupList
	 * @return
	 */
	public static Map<String,Integer> commodityGroupListToNameIdMap(List<com.eilikce.osm.core.bo.common.CommodityGroupItem> commodityGroupList){
		Map<String,Integer> groupMap = new HashMap<String,Integer>();
		
		for(com.eilikce.osm.core.bo.common.CommodityGroupItem cgb : commodityGroupList){
			groupMap.put(cgb.getGroupName(),cgb.getGroupId());
		}
		
		return groupMap;
	}

	/**
	 * 将CommodityGroupList转换为以groupId为键的CommodityGroupMap
	 * @param commodityGroupList
	 * @return
	 */
	public static HashMap<Integer, com.eilikce.osm.core.bo.common.CommodityGroupItem> commodityGroupListToGroupMap(List<com.eilikce.osm.core.bo.common.CommodityGroupItem> commodityGroupList){
		HashMap<Integer, com.eilikce.osm.core.bo.common.CommodityGroupItem> groupMap = new HashMap<Integer, com.eilikce.osm.core.bo.common.CommodityGroupItem>();
		
		for(com.eilikce.osm.core.bo.common.CommodityGroupItem cg : commodityGroupList){
			groupMap.put(cg.getGroupId(),cg);
		}
		
		return groupMap;
	}

	/**
	 * 将某个CommodityGroup下的CommodityItemList转换为以itemName为键的CommodityItem的Map
	 * 注：itemName不能重复
	 * @param commodityItemList
	 * @return
	 */
	public static HashMap<String,CommodityItem> commodityItemListToItemNameMap(List<CommodityItem> commodityItemList){
		HashMap<String,CommodityItem> itemMap = new HashMap<String,CommodityItem>();
		
		for(CommodityItem ci : commodityItemList){
			itemMap.put(ci.getItemName(),ci);
		}
		
		return itemMap;
	}
	
	/**
	 * 将某个CommodityGroup下的CommodityItemList转换为以itemId为键的CommodityItem的Map
	 * @param commodityItemList
	 * @return
	 */
	public static HashMap<Integer,CommodityItem> commodityItemListToItemIdMap(List<CommodityItem> commodityItemList){
		HashMap<Integer,CommodityItem> itemMap = new HashMap<Integer,CommodityItem>();
		
		for(CommodityItem ci : commodityItemList){
			itemMap.put(ci.getItemId(),ci);
		}
		
		return itemMap;
	}

	/**
	 * 通过完整commodityGroupItemList转换为 id为键的两级树结构
	 * @param commodityGroupItemList
	 * @return
	 */
	public static HashMap<Integer, HashMap<Integer, CommodityItem>> groupItemTree(List<com.eilikce.osm.core.bo.common.CommodityGroupItem> commodityGroupItemList) {
		// 构建HashMap<groupId,HashMap<itemId,CommodityItem>>，两级树结构
		HashMap<Integer, HashMap<Integer, CommodityItem>> groupItemTree = new HashMap<Integer, HashMap<Integer, CommodityItem>>();
		for (com.eilikce.osm.core.bo.common.CommodityGroupItem cgib : commodityGroupItemList) {
			List<CommodityItem> commodityItemList = cgib.getCommodityItemList();
			HashMap<Integer, CommodityItem> commodityItemMap = commodityItemListToItemIdMap(commodityItemList);
			groupItemTree.put(cgib.getGroupId(), commodityItemMap);
		}

		return groupItemTree;
	}
	
	/**
	 * 通过完整commodityGroupItemList转换为一级为groupId键，二级itemName为键的两级树结构
	 * @param commodityGroupItemList
	 * @return
	 */
	public static HashMap<Integer, HashMap<String, CommodityItem>> groupItemTree2(List<com.eilikce.osm.core.bo.common.CommodityGroupItem> commodityGroupItemList) {
		// 构建HashMap<groupId,HashMap<itemName,CommodityItem>>，存储两级分类结构，便于通过groupId取出多个item，再通过itemName取出Item，再取出itemId
		HashMap<Integer, HashMap<String, CommodityItem>> groupItemTree = new HashMap<Integer, HashMap<String, CommodityItem>>();
		for (com.eilikce.osm.core.bo.common.CommodityGroupItem cgib : commodityGroupItemList) {
			List<CommodityItem> commodityItemList = cgib.getCommodityItemList();
			HashMap<String, CommodityItem> commodityItemMap = commodityItemListToItemNameMap(commodityItemList);
			groupItemTree.put(cgib.getGroupId(), commodityItemMap);
		}

		return groupItemTree;
	}
	
	/**
	 * 将CommodityGroup的List转换为CommodityGroup的List
	 * 
	 * @param commodityGroupList
	 * @return
	 */
	public static List<com.eilikce.osm.core.bo.common.CommodityGroupItem> commodityGroupListTransform0(
			List<CommodityGroup> commodityGroupList) {
		if (null == commodityGroupList) {
			LOG.error("CommodityGroupItem的List转换失败，commodityGroupList为空");
		}
		List<com.eilikce.osm.core.bo.common.CommodityGroupItem> commodityGroupItemList = new ArrayList<com.eilikce.osm.core.bo.common.CommodityGroupItem>();
		for (CommodityGroup cg : commodityGroupList) {
			com.eilikce.osm.core.bo.common.CommodityGroupItem bo = new com.eilikce.osm.core.bo.common.CommodityGroupItem(cg);
			commodityGroupItemList.add(bo);
		}
		return commodityGroupItemList;
	}

	
	/**
	 * 将CommodityGroupItem的List转换为CommodityGroup的List
	 * 
	 * @param commodityGroupList
	 * @return
	 */
	public static List<com.eilikce.osm.core.bo.common.CommodityGroupItem> commodityGroupListTransform(
			List<CommodityGroupItem> commodityGroupItemPoList) {
		if (null == commodityGroupItemPoList) {
			LOG.error("CommodityGroupItem的List转换失败，commodityGroupItemList为空");
		}
		List<com.eilikce.osm.core.bo.common.CommodityGroupItem> commodityGroupItemList = new ArrayList<com.eilikce.osm.core.bo.common.CommodityGroupItem>();
		for (CommodityGroupItem cgi : commodityGroupItemPoList) {
			com.eilikce.osm.core.bo.common.CommodityGroupItem bo = new com.eilikce.osm.core.bo.common.CommodityGroupItem(cgi);
			commodityGroupItemList.add(bo);
		}
		return commodityGroupItemList;
	}
}
