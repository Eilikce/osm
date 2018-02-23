package com.eilikce.osm.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eilikce.osm.entity.consumer.RecordOrderCommodity;

@Repository
public class RecordOrderCommodityDaoImpl implements RecordOrderCommodityDao{

	private static final String NAMESPACE = RecordOrderCommodityDaoImpl.class.getPackage().getName() + "." + RecordOrderCommodityDaoImpl.class.getSimpleName() + ".";
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Integer selectCount() {
		Integer count = (Integer)sqlSessionTemplate.selectOne(NAMESPACE + "selectCount");
		return count;
	}

	@Override
	public List<RecordOrderCommodity> selectRecordOrderCommodityListByOrderId(String orderId) {
		List<RecordOrderCommodity> recordOrderCommodityList = new ArrayList<RecordOrderCommodity>();
		recordOrderCommodityList = sqlSessionTemplate.selectList(NAMESPACE + "selectRecordOrderCommodityListByOrderId", orderId);
		return recordOrderCommodityList;
	}

	@Override
	public int insertRecordOrderCommodityList(List<RecordOrderCommodity> recordOrderCommodityList) {
		int count = sqlSessionTemplate.insert(NAMESPACE + "insertRecordOrderCommodityList" , recordOrderCommodityList);
		return count;
	}

	@Override
	public int insertRecordOrderCommodity(RecordOrderCommodity recordOrderCommodity) {
		int count = sqlSessionTemplate.insert(NAMESPACE + "insertRecordOrderCommodityList" , recordOrderCommodity);
		return count;
	}
	
}
