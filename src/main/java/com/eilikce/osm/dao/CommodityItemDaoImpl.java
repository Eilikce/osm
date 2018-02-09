package com.eilikce.osm.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eilikce.osm.entity.consumer.CommodityItem;

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
	public List<CommodityItem> selectAllCommodityItem() {
		List<CommodityItem> itemList = new ArrayList<CommodityItem>();
		itemList = sqlSessionTemplate.selectList(NAMESPACE + "selectAllCommodityItem");
		return itemList;
	}

	@Override
	public List<CommodityItem> selectCommodityItemByGroupId(int groupId) {
		List<CommodityItem> itemList = new ArrayList<CommodityItem>();
		itemList = sqlSessionTemplate.selectList(NAMESPACE + "selectCommodityItemByGroupId",groupId);
		return itemList;
	}

	@Override
	public CommodityItem selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertCommodityItem(CommodityItem commodityItem) {
		// TODO Auto-generated method stub
		return null;
	}

}
