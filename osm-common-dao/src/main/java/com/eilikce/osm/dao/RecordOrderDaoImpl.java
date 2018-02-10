package com.eilikce.osm.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eilikce.osm.entity.consumer.RecordOrder;
import com.eilikce.osm.entity.consumer.RecordOrderFurther;

@Repository
public class RecordOrderDaoImpl implements RecordOrderDao{

	private static final String NAMESPACE = RecordOrderDaoImpl.class.getPackage().getName() + "." + RecordOrderDaoImpl.class.getSimpleName() + ".";
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Integer selectCount() {
		Integer count = (Integer)sqlSessionTemplate.selectOne(NAMESPACE + "selectCount");
		return count;
	}

	@Override
	public List<RecordOrderFurther> selectAllRecordOrderFurther() {
		List<RecordOrderFurther> recordOrderFurtherList = new ArrayList<RecordOrderFurther>();
		recordOrderFurtherList = sqlSessionTemplate.selectList(NAMESPACE + "selectAllRecordOrderFurther");
		return recordOrderFurtherList;
	}

	@Override
	public List<RecordOrderFurther> selectRecordOrderFurtherByPage(int page, int pageSize) {
		int step = (page-1)*pageSize;
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("step", step);
		map.put("pageSize", pageSize);
		
		List<RecordOrderFurther> recordOrderFurtherList = new ArrayList<RecordOrderFurther>();
		recordOrderFurtherList = sqlSessionTemplate.selectList(NAMESPACE + "selectRecordOrderFurtherByPage", map);
		return recordOrderFurtherList;
	}

	@Override
	public int selectCountByPage(int page, int pageSize) {
		int step = (page-1)*pageSize;
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("step", step);
		map.put("pageSize", pageSize);
		
		int count = sqlSessionTemplate.selectOne(NAMESPACE + "selectCountByPage" , map);
		return count;
	}

	@Override
	public int insertRecordOrder(RecordOrder recordOrder) {
		int count = sqlSessionTemplate.insert(NAMESPACE + "insertRecordOrder" , recordOrder);
		return count;
	}

	@Override
	public int updateRecordOrderById(RecordOrder recordOrder) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePaymentStatus(RecordOrder RecordOrder) {
		int count = sqlSessionTemplate.update(NAMESPACE + "updatePaymentStatus" , RecordOrder);
		return count;
	}

	@Override
	public int updatePaymentStatusById(String orderId, int paymentStatus) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("orderId", orderId);
		map.put("paymentStatus", paymentStatus);
		int count = sqlSessionTemplate.update(NAMESPACE + "updatePaymentStatusById" , map);
		return count;
	}
	
}
