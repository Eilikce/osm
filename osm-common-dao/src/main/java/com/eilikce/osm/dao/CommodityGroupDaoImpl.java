package com.eilikce.osm.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eilikce.osm.entity.consumer.CommodityGroupPo;
import com.eilikce.osm.entity.consumer.CommodityGroupItemPo;

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
	public List<CommodityGroupPo> selectAllCommodityGroup() {
		List<CommodityGroupPo> groupList = new ArrayList<CommodityGroupPo>();
		groupList = sqlSessionTemplate.selectList(NAMESPACE + "selectAllCommodityGroup");
		return groupList;
	}

	@Override
	public List<CommodityGroupItemPo> selectAllCommodityGroupAndItem() {
		List<CommodityGroupItemPo> groupItemList = new ArrayList<CommodityGroupItemPo>();
		groupItemList = sqlSessionTemplate.selectList(NAMESPACE + "selectAllCommodityGroupAndItem");
		return groupItemList;
	}
	
	@Override
	public CommodityGroupPo selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertCommodityGroup(CommodityGroupItemPo group) {
		// TODO Auto-generated method stub
		return null;
	}
}
