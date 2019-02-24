package com.eilikce.osm.dao;

import com.eilikce.osm.entity.consumer.Consumer;

public interface ConsumerDao {
	
	/** 获取消费者 **/
	public Consumer selectConsumerById(String consumerId);
	
	/** 新增消费者 **/
	public int insertConsumer(Consumer consumer);
	
}
