package com.eilikce.osm.shop.service;

import java.util.List;

import com.eilikce.osm.core.bo.CommodityShow;

public interface ShoppingService {
	/** 根据小类itemId获取小类下所有商品 **/
	List<CommodityShow> getCommodityByGroupIdItemId(int groupId , int itemId);
	
	/** 根据大类groupId获取大类下所有商品 **/
	List<CommodityShow> getCommodityByGroupId(int groupId);
	
	/** 根据搜索字符串，获取所有商品 **/
	List<CommodityShow> getCommodityBySearch(String search);
	
}
