package com.eilikce.osm.dao;

import java.util.List;

import com.eilikce.osm.entity.consumer.CommodityGroupItemPo;
import com.eilikce.osm.entity.consumer.CommodityGroupPo;

public interface CommodityGroupDao {
	
	/** 获取一级分类总数**/
	Integer selectCount();

	/** 获取全部一级分类列表 **/
	List<CommodityGroupPo> selectAllCommodityGroup();
	
	/** 获取全部大分类小分类列表 **/
	List<CommodityGroupItemPo> selectAllCommodityGroupAndItem();

	/** 通过id获取一级分类 **/
	CommodityGroupPo selectById(int id);

	/** 添加一个一级分类 **/
	Integer insertCommodityGroup(CommodityGroupItemPo group);
	
}
