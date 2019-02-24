package com.eilikce.osm.dao;

import java.util.List;

import com.eilikce.osm.entity.consumer.CommodityItemPo;

public interface CommodityItemDao {
	
	/** 获取二级分类总数 **/
	Integer selectCount();

	/** 获取全部二级分类列表 **/
	List<CommodityItemPo> selectAllCommodityItem();
	
	/** 通过groupId获取二级分类列表 **/
	List<CommodityItemPo> selectCommodityItemByGroupId(int groupId);

	/** 通过 id 获取二级分类 **/
	CommodityItemPo selectById(int id);

	/** 添加一个二级分类 **/
	Integer insertCommodityItem(CommodityItemPo commodityItemPo);
	
}
