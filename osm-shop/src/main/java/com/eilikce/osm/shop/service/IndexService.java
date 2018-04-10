package com.eilikce.osm.shop.service;

import java.util.List;

import com.eilikce.osm.core.bo.common.CommodityGroupItem;
import com.eilikce.osm.core.bo.transformable.CommodityItem;

public interface IndexService {
	
	/** 获取大分类List **/
	List<CommodityGroupItem> getAllCommodityGroup();
	
	/** 获取小分类List **/
	List<CommodityItem> getAllCommodityItem();
	
	/** 获取所有大分类小分类 **/
	List<CommodityGroupItem> getAllCommodityGroupAndItem();
	
}
