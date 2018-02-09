package com.eilikce.osm.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eilikce.osm.entity.consumer.CommodityGroup;
import com.eilikce.osm.entity.consumer.CommodityGroupItem;

@Repository
public class CommodityGroupDaoImpl implements CommodityGroupDao {

	private static final String NAMESPACE = CommodityGroupDaoImpl.class.getPackage().getName() + "." + CommodityGroupDaoImpl.class.getSimpleName() + ".";
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Integer selectCount() {
		Integer count = (Integer)sqlSessionTemplate.selectOne(NAMESPACE + "selectCount");
		return count;
	}

	@Override
	public List<CommodityGroup> selectAllCommodityGroup() {
		List<CommodityGroup> groupList = new ArrayList<CommodityGroup>();
		groupList = sqlSessionTemplate.selectList(NAMESPACE + "selectAllCommodityGroup");
		return groupList;
	}

	@Override
	public List<CommodityGroupItem> selectAllCommodityGroupAndItem() {
		List<CommodityGroupItem> groupItemList = new ArrayList<CommodityGroupItem>();
		groupItemList = sqlSessionTemplate.selectList(NAMESPACE + "selectAllCommodityGroupAndItem");
		return groupItemList;
	}
	
	@Override
	public CommodityGroup selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertCommodityGroup(CommodityGroupItem group) {
		// TODO Auto-generated method stub
		return null;
	}
}
