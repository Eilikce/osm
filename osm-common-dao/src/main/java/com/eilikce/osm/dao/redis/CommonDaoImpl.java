package com.eilikce.osm.dao.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.eilikce.osm.entity.redis.RedisStorable;

@Repository
public class CommonDaoImpl implements CommonDao{
	@Autowired
	RedisTemplate<String,RedisStorable> redisTemplate;

	@Override
	public void save(String key, RedisStorable value) {

		ValueOperations<String, RedisStorable> valueOperations = redisTemplate.opsForValue();
		// 不设置过期时间，永久性保存
		valueOperations.set(key, value);
		
	}

	@Override
	public void save(String key, RedisStorable value, int timeout) {

		ValueOperations<String, RedisStorable> valueOperations = redisTemplate.opsForValue();
		// 设置过期时间为timeout秒，采用TimeUnit控制时间单位
		valueOperations.set(key, value, timeout, TimeUnit.SECONDS);
	
	}

	@Override
	public void delete(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public RedisStorable getValue(String key) {
		
		ValueOperations<String, RedisStorable> valueOperations = redisTemplate.opsForValue();
		RedisStorable value =  valueOperations.get(key);
	
		return value;
	}
	
}
