package com.eilikce.osm.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eilikce.osm.entity.consumer.CommodityItemPo;

@Repository
public class CommodityItemDaoImpl implements CommodityItemDao {

	private static final String NAMESPACE = CommodityItemDaoImpl.class.getPackage().getName() + "." + CommodityItemDaoImpl.class.getSimpleName() + ".";
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Integer selectCount() {
		int count = sqlSessionTemplate.selectOne(NAMESPACE + "selectCount");
		return count;
	}

	@Override
	public List<CommodityItemPo> selectAllCommodityItem() {
		List<CommodityItemPo> itemList = new ArrayList<CommodityItemPo>();
		itemList = sqlSessionTemplate.selectList(NAMESPACE + "selectAllCommodityItem");
		return itemList;
	}

	@Override
	public List<CommodityItemPo> selectCommodityItemByGroupId(int groupId) {
		List<CommodityItemPo> itemList = new ArrayList<CommodityItemPo>();
		itemList = sqlSessionTemplate.selectList(NAMESPACE + "selectCommodityItemByGroupId",groupId);
		return itemList;
	}

	@Override
	public CommodityItemPo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertCommodityItem(CommodityItemPo commodityItem) {
		// TODO Auto-generated method stub
		return null;
	}

}
