package com.eilikce.osm.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eilikce.osm.entity.consumer.ConsumerPo;

@Repository
public class ConsumerDaoImpl implements ConsumerDao{

private static final String NAMESPACE = ConsumerDaoImpl.class.getPackage().getName() + "." + ConsumerDaoImpl.class.getSimpleName() + ".";
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public ConsumerPo selectConsumerById(String consumerId) {
		ConsumerPo consumerPo = (ConsumerPo)sqlSessionTemplate.selectOne(NAMESPACE + "selectConsumerById");

		return consumerPo;
	}

	@Override
	public int insertConsumer(ConsumerPo consumer) {
		int insert = sqlSessionTemplate.insert(NAMESPACE + "insertConsumer", consumer);
		return insert;
	}
	
}
