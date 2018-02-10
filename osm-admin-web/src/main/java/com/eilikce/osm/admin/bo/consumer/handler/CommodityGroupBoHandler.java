package com.eilikce.osm.admin.bo.consumer.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.eilikce.osm.admin.bo.consumer.CommodityGroupItemBo;
import com.eilikce.osm.admin.bo.consumer.CommodityItemBo;
import com.eilikce.osm.entity.consumer.CommodityGroup;
import com.eilikce.osm.entity.consumer.CommodityGroupItem;

public class CommodityGroupBoHandler {
	
	private static Logger logger = Logger.getLogger(CommodityGroupBoHandler.class);
	
	/**
	 * 将CommodityGroupList转换为以groupName为键的name、id对照表map
	 * @param commodityGroupBoList
	 * @return
	 */
	public static Map<String,Integer> commodityGroupBoListToNameIdMap(List<CommodityGroupItemBo> commodityGroupBoList){
		Map<String,Integer> groupMap = new HashMap<String,Integer>();
		
		for(CommodityGroupItemBo cgb : commodityGroupBoList){
			groupMap.put(cgb.getGroupName(),cgb.getGroupId());
		}
		
		return groupMap;
	}

	/**
	 * 将CommodityGroupList转换为以groupId为键的CommodityGroupMap
	 * @param commodityGroupBoList
	 * @return
	 */
	public static HashMap<Integer,CommodityGroupItemBo> commodityGroupBoListToGroupMap(List<CommodityGroupItemBo> commodityGroupBoList){
		HashMap<Integer,CommodityGroupItemBo> groupMap = new HashMap<Integer,CommodityGroupItemBo>();
		
		for(CommodityGroupItemBo cg : commodityGroupBoList){
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
	public static HashMap<String,CommodityItemBo> commodityItemBoListToItemNameMap(List<CommodityItemBo> commodityItemBoList){
		HashMap<String,CommodityItemBo> itemMap = new HashMap<String,CommodityItemBo>();
		
		for(CommodityItemBo ci : commodityItemBoList){
			itemMap.put(ci.getItemName(),ci);
		}
		
		return itemMap;
	}
	
	/**
	 * 将某个CommodityGroup下的CommodityItemBoList转换为以itemId为键的CommodityItemBo的Map
	 * @param commodityItemBoList
	 * @return
	 */
	public static HashMap<Integer,CommodityItemBo> commodityItemBoListToItemIdMap(List<CommodityItemBo> commodityItemBoList){
		HashMap<Integer,CommodityItemBo> itemMap = new HashMap<Integer,CommodityItemBo>();
		
		for(CommodityItemBo ci : commodityItemBoList){
			itemMap.put(ci.getItemId(),ci);
		}
		
		return itemMap;
	}

	/**
	 * 通过完整commodityGroupItemBoList转换为 id为键的两级树结构
	 * @param commodityGroupItemBoList
	 * @return
	 */
	public static HashMap<Integer, HashMap<Integer, CommodityItemBo>> groupItemTree(List<CommodityGroupItemBo> commodityGroupItemBoList) {
		// 构建HashMap<groupId,HashMap<itemId,CommodityItemBo>>，两级树结构
		HashMap<Integer, HashMap<Integer, CommodityItemBo>> groupItemTree = new HashMap<Integer, HashMap<Integer, CommodityItemBo>>();
		for (CommodityGroupItemBo cgib : commodityGroupItemBoList) {
			List<CommodityItemBo> commodityItemBoList = cgib.getCommodityItemBoList();
			HashMap<Integer, CommodityItemBo> commodityItemBoMap = commodityItemBoListToItemIdMap(commodityItemBoList);
			groupItemTree.put(cgib.getGroupId(), commodityItemBoMap);
		}

		return groupItemTree;
	}
	
	/**
	 * 通过完整commodityGroupItemBoList转换为一级为groupId键，二级itemName为键的两级树结构
	 * @param commodityGroupItemBoList
	 * @return
	 */
	public static HashMap<Integer, HashMap<String, CommodityItemBo>> groupItemTree2(List<CommodityGroupItemBo> commodityGroupItemBoList) {
		// 构建HashMap<groupId,HashMap<itemName,CommodityItemBo>>，存储两级分类结构，便于通过groupId取出多个item，再通过itemName取出Item，再取出itemId
		HashMap<Integer, HashMap<String, CommodityItemBo>> groupItemTree = new HashMap<Integer, HashMap<String, CommodityItemBo>>();
		for (CommodityGroupItemBo cgib : commodityGroupItemBoList) {
			List<CommodityItemBo> commodityItemBoList = cgib.getCommodityItemBoList();
			HashMap<String, CommodityItemBo> commodityItemBoMap = commodityItemBoListToItemNameMap(commodityItemBoList);
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
	public static List<CommodityGroupItemBo> commodityGroupBoListTransform0(
			List<CommodityGroup> commodityGroupList) {
		if (null == commodityGroupList) {
			logger.error("CommodityGroupItemBo的List转换失败，commodityGroupList为空");
		}
		List<CommodityGroupItemBo> commodityGroupItemBoList = new ArrayList<CommodityGroupItemBo>();
		for (CommodityGroup cg : commodityGroupList) {
			CommodityGroupItemBo bo = new CommodityGroupItemBo(cg);
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
	public static List<CommodityGroupItemBo> commodityGroupBoListTransform(
			List<CommodityGroupItem> commodityGroupItemList) {
		if (null == commodityGroupItemList) {
			logger.error("CommodityGroupItemBo的List转换失败，commodityGroupItemList为空");
		}
		List<CommodityGroupItemBo> commodityGroupItemBoList = new ArrayList<CommodityGroupItemBo>();
		for (CommodityGroupItem cgi : commodityGroupItemList) {
			CommodityGroupItemBo bo = new CommodityGroupItemBo(cgi);
			commodityGroupItemBoList.add(bo);
		}
		return commodityGroupItemBoList;
	}
}
