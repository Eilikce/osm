package com.eilikce.osm.redis.dao;

import com.eilikce.osm.redis.entity.RedisStorable;

public interface CommonDao {

	/**
	 * 存储数据
	 * @param key
	 * @param value
	 */
	public void save(String key, RedisStorable value);

	/**
	 * 存储数据,并设置超时时间
	 * @param key
	 * @param value
	 * @param timeout
	 */
	public void save(String key, RedisStorable value, int timeout);
	
	/**
	 * 根据key删除数据
	 * @param key
	 */
	public void delete(String key);
	
	/**
	 * 根据key,获取数据
	 * @param key
	 * @return
	 */
	public RedisStorable getValue(String key);
	
}
