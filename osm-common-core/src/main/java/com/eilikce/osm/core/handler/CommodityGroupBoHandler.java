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

public class CommodityGroupBoHandler {
	
	private static Logger logger = Logger.getLogger(CommodityGroupBoHandler.class);
	
	/**
	 * 将CommodityGroupList转换为以groupName为键的name、id对照表map
	 * @param commodityGroupBoList
	 * @return
	 */
	public static Map<String,Integer> commodityGroupBoListToNameIdMap(List<CommodityGroupItem> commodityGroupBoList){
		Map<String,Integer> groupMap = new HashMap<String,Integer>();
		
		for(CommodityGroupItem cgb : commodityGroupBoList){
			groupMap.put(cgb.getGroupName(),cgb.getGroupId());
		}
		
		return groupMap;
	}

	/**
	 * 将CommodityGroupList转换为以groupId为键的CommodityGroupMap
	 * @param commodityGroupBoList
	 * @return
	 */
	public static HashMap<Integer,CommodityGroupItem> commodityGroupBoListToGroupMap(List<CommodityGroupItem> commodityGroupBoList){
		HashMap<Integer,CommodityGroupItem> groupMap = new HashMap<Integer,CommodityGroupItem>();
		
		for(CommodityGroupItem cg : commodityGroupBoList){
			groupMap.put(cg.getGroupId(),cg);
		}
		
		return groupMap;
	}

	/**
	 * 将某个CommodityGroup下的CommodityItemBoList转换为以itemName为键的CommodityItemBo的Map
	 * 注：itemName不能重复
	 * @param commodityItemBoList
	 * @return
	 */
	public static HashMap<String,CommodityItem> commodityItemBoListToItemNameMap(List<CommodityItem> commodityItemBoList){
		HashMap<String,CommodityItem> itemMap = new HashMap<String,CommodityItem>();
		
		for(CommodityItem ci : commodityItemBoList){
			itemMap.put(ci.getItemName(),ci);
		}
		
		return itemMap;
	}
	
	/**
	 * 将某个CommodityGroup下的CommodityItemBoList转换为以itemId为键的CommodityItemBo的Map
	 * @param commodityItemBoList
	 * @return
	 */
	public static HashMap<Integer,CommodityItem> commodityItemBoListToItemIdMap(List<CommodityItem> commodityItemBoList){
		HashMap<Integer,CommodityItem> itemMap = new HashMap<Integer,CommodityItem>();
		
		for(CommodityItem ci : commodityItemBoList){
			itemMap.put(ci.getItemId(),ci);
		}
		
		return itemMap;
	}

	/**
	 * 通过完整commodityGroupItemBoList转换为 id为键的两级树结构
	 * @param commodityGroupItemBoList
	 * @return
	 */
	public static HashMap<Integer, HashMap<Integer, CommodityItem>> groupItemTree(List<CommodityGroupItem> commodityGroupItemBoList) {
		// 构建HashMap<groupId,HashMap<itemId,CommodityItemBo>>，两级树结构
		HashMap<Integer, HashMap<Integer, CommodityItem>> groupItemTree = new HashMap<Integer, HashMap<Integer, CommodityItem>>();
		for (CommodityGroupItem cgib : commodityGroupItemBoList) {
			List<CommodityItem> commodityItemBoList = cgib.getCommodityItemBoList();
			HashMap<Integer, CommodityItem> commodityItemBoMap = commodityItemBoListToItemIdMap(commodityItemBoList);
			groupItemTree.put(cgib.getGroupId(), commodityItemBoMap);
		}

		return groupItemTree;
	}
	
	/**
	 * 通过完整commodityGroupItemBoList转换为一级为groupId键，二级itemName为键的两级树结构
	 * @param commodityGroupItemBoList
	 * @return
	 */
	public static HashMap<Integer, HashMap<String, CommodityItem>> groupItemTree2(List<CommodityGroupItem> commodityGroupItemBoList) {
		// 构建HashMap<groupId,HashMap<itemName,CommodityItemBo>>，存储两级分类结构，便于通过groupId取出多个item，再通过itemName取出Item，再取出itemId
		HashMap<Integer, HashMap<String, CommodityItem>> groupItemTree = new HashMap<Integer, HashMap<String, CommodityItem>>();
		for (CommodityGroupItem cgib : commodityGroupItemBoList) {
			List<CommodityItem> commodityItemBoList = cgib.getCommodityItemBoList();
			HashMap<String, CommodityItem> commodityItemBoMap = commodityItemBoListToItemNameMap(commodityItemBoList);
			groupItemTree.put(cgib.getGroupId(), commodityItemBoMap);
		}

		return groupItemTree;
	}
	
	/**
	 * 将CommodityGroup的List转换为CommodityGroupBo的List
	 * 
	 * @param commodityGroupList
	 * @return
	 */
	public static List<CommodityGroupItem> commodityGroupBoListTransform0(
			List<CommodityGroupPo> commodityGroupList) {
		if (null == commodityGroupList) {
			logger.error("CommodityGroupItemBo的List转换失败，commodityGroupList为空");
		}
		List<CommodityGroupItem> commodityGroupItemBoList = new ArrayList<CommodityGroupItem>();
		for (CommodityGroupPo cg : commodityGroupList) {
			CommodityGroupItem bo = new CommodityGroupItem(cg);
			commodityGroupItemBoList.add(bo);
		}
		return commodityGroupItemBoList;
	}

	
	/**
	 * 将CommodityGroupItem的List转换为CommodityGroupBo的List
	 * 
	 * @param commodityGroupList
	 * @return
	 */
	public static List<CommodityGroupItem> commodityGroupBoListTransform(
			List<CommodityGroupItemPo> commodityGroupItemList) {
		if (null == commodityGroupItemList) {
			logger.error("CommodityGroupItemBo的List转换失败，commodityGroupItemList为空");
		}
		List<CommodityGroupItem> commodityGroupItemBoList = new ArrayList<CommodityGroupItem>();
		for (CommodityGroupItemPo cgi : commodityGroupItemList) {
			CommodityGroupItem bo = new CommodityGroupItem(cgi);
			commodityGroupItemBoList.add(bo);
		}
		return commodityGroupItemBoList;
	}
}
