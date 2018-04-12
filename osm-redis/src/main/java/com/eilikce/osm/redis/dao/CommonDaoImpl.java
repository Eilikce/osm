package com.eilikce.osm.redis.dao;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.eilikce.osm.redis.entity.RedisStorable;

@Repository
public class CommonDaoImpl implements CommonDao{
	@Autowired
	RedisTemplate<String,Object> redisTemplate;

	@Override
	public void save(String key, RedisStorable value) {
		saveObject(key, value, 0);
	}

	@Override
	public void save(String key, RedisStorable value, int timeout) {
		saveObject(key, value, timeout);
	}
	
	@Override
	public void save(String key, String value) {
		saveObject(key, value, 0);
	}
	
	@Override
	public void save(String key, String value, int timeout) {
		saveObject(key, value, timeout);
	}

	@Override
	public void delete(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public Object getValue(String key) {
		
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		Object value =  valueOperations.get(key);
	
		return value;
	}
	
	/**
	 * 保存可序列化对象到redis
	 * timeout设置为0时，不限制存储存活时间
	 * 
	 * @param key
	 * @param value
	 * @param timeout
	 */
	private void saveObject(String key, Object value, int timeout) {

		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		if(timeout == 0) {
			// 不设置过期时间，永久性保存
			valueOperations.set(key, value, timeout);
		}else {
			// 设置过期时间为timeout秒，采用TimeUnit控制时间单位
			valueOperations.set(key, value, timeout, TimeUnit.SECONDS);
		}
	
	}
	
}
