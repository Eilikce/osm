package com.eilikce.osm.core.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.eilikce.osm.core.bo.common.CommodityGroupItem;
import com.eilikce.osm.core.bo.transformable.CommodityItem;
import com.eilikce.osm.entity.consumer.CommodityGroupPo;
import com.eilikce.osm.entity.consumer.CommodityGroupItemPo;

public class CommodityGroupHandler {
	
	private static Logger logger = Logger.getLogger(CommodityGroupHandler.class);
	
	/**
	 * 将CommodityGroupList转换为以groupName为键的name、id对照表map
	 * @param commodityGroupList
	 * @return
	 */
	public static Map<String,Integer> commodityGroupListToNameIdMap(List<CommodityGroupItem> commodityGroupList){
		Map<String,Integer> groupMap = new HashMap<String,Integer>();
		
		for(CommodityGroupItem cgb : commodityGroupList){
			groupMap.put(cgb.getGroupName(),cgb.getGroupId());
		}
		
		return groupMap;
	}

	/**
	 * 将CommodityGroupList转换为以groupId为键的CommodityGroupMap
	 * @param commodityGroupList
	 * @return
	 */
	public static HashMap<Integer,CommodityGroupItem> commodityGroupListToGroupMap(List<CommodityGroupItem> commodityGroupList){
		HashMap<Integer,CommodityGroupItem> groupMap = new HashMap<Integer,CommodityGroupItem>();
		
		for(CommodityGroupItem cg : commodityGroupList){
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
	public static HashMap<Integer, HashMap<Integer, CommodityItem>> groupItemTree(List<CommodityGroupItem> commodityGroupItemList) {
		// 构建HashMap<groupId,HashMap<itemId,CommodityItem>>，两级树结构
		HashMap<Integer, HashMap<Integer, CommodityItem>> groupItemTree = new HashMap<Integer, HashMap<Integer, CommodityItem>>();
		for (CommodityGroupItem cgib : commodityGroupItemList) {
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
	public static HashMap<Integer, HashMap<String, CommodityItem>> groupItemTree2(List<CommodityGroupItem> commodityGroupItemList) {
		// 构建HashMap<groupId,HashMap<itemName,CommodityItem>>，存储两级分类结构，便于通过groupId取出多个item，再通过itemName取出Item，再取出itemId
		HashMap<Integer, HashMap<String, CommodityItem>> groupItemTree = new HashMap<Integer, HashMap<String, CommodityItem>>();
		for (CommodityGroupItem cgib : commodityGroupItemList) {
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
	public static List<CommodityGroupItem> commodityGroupListTransform0(
			List<CommodityGroupPo> commodityGroupList) {
		if (null == commodityGroupList) {
			logger.error("CommodityGroupItem的List转换失败，commodityGroupList为空");
		}
		List<CommodityGroupItem> commodityGroupItemList = new ArrayList<CommodityGroupItem>();
		for (CommodityGroupPo cg : commodityGroupList) {
			CommodityGroupItem bo = new CommodityGroupItem(cg);
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
	public static List<CommodityGroupItem> commodityGroupListTransform(
			List<CommodityGroupItemPo> commodityGroupItemPoList) {
		if (null == commodityGroupItemPoList) {
			logger.error("CommodityGroupItem的List转换失败，commodityGroupItemList为空");
		}
		List<CommodityGroupItem> commodityGroupItemList = new ArrayList<CommodityGroupItem>();
		for (CommodityGroupItemPo cgi : commodityGroupItemPoList) {
			CommodityGroupItem bo = new CommodityGroupItem(cgi);
			commodityGroupItemList.add(bo);
		}
		return commodityGroupItemList;
	}
}
