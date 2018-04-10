package com.eilikce.osm.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eilikce.osm.entity.consumer.RecordOrderCommodityPo;

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
	public List<RecordOrderCommodityPo> selectRecordOrderCommodityListByOrderId(String orderId) {
		List<RecordOrderCommodityPo> recordOrderCommodityList = new ArrayList<RecordOrderCommodityPo>();
		recordOrderCommodityList = sqlSessionTemplate.selectList(NAMESPACE + "selectRecordOrderCommodityListByOrderId", orderId);
		return recordOrderCommodityList;
	}

	@Override
	public int insertRecordOrderCommodityList(List<RecordOrderCommodityPo> recordOrderCommodityList) {
		int count = sqlSessionTemplate.insert(NAMESPACE + "insertRecordOrderCommodityList" , recordOrderCommodityList);
		return count;
	}

	@Override
	public int insertRecordOrderCommodity(RecordOrderCommodityPo recordOrderCommodity) {
		int count = sqlSessionTemplate.insert(NAMESPACE + "insertRecordOrderCommodityList" , recordOrderCommodity);
		return count;
	}
	
}
