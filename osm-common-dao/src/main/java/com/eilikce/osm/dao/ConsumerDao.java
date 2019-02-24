package com.eilikce.osm.dao;

import com.eilikce.osm.entity.consumer.ConsumerPo;

public interface ConsumerDao {
	
	/** 获取消费者 **/
	public ConsumerPo selectConsumerById(String consumerId);
	
	/** 新增消费者 **/
	public int insertConsumer(ConsumerPo consumerPo);
	
}
