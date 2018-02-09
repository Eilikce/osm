package com.eilikce.osm.dao;

import java.util.List;

import com.eilikce.osm.entity.consumer.CommodityGroup;
import com.eilikce.osm.entity.consumer.CommodityGroupItem;

public interface CommodityGroupDao {
	
	/** 获取一级分类总数**/
	Integer selectCount();

	/** 获取全部一级分类列表 **/
	List<CommodityGroup> selectAllCommodityGroup();
	
	/** 获取全部大分类小分类列表 **/
	List<CommodityGroupItem> selectAllCommodityGroupAndItem();

	/** 通过id获取一级分类 **/
	CommodityGroup selectById(int id);

	/** 添加一个一级分类 **/
	Integer insertCommodityGroup(CommodityGroupItem group);
	
}
