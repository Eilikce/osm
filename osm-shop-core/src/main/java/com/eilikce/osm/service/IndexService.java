package com.eilikce.osm.service;

import java.util.List;

import com.eilikce.osm.bo.consumer.CommodityGroupItemBo;
import com.eilikce.osm.bo.consumer.CommodityItemBo;

public interface IndexService {
	
	/** 获取大分类List **/
	List<CommodityGroupItemBo> getAllCommodityGroup();
	
	/** 获取小分类List **/
	List<CommodityItemBo> getAllCommodityItem();
	
	/** 获取所有大分类小分类 **/
	List<CommodityGroupItemBo> getAllCommodityGroupAndItem();
	
}
