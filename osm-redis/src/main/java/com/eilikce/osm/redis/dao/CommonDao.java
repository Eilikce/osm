package com.eilikce.osm.redis.dao;

import java.io.Serializable;

public interface CommonDao {

	/**
	 * 存储数据
	 * @param key
	 * @param value
	 */
	public void save(String key, Serializable value);

	/**
	 * 存储数据,并设置过期时间
	 * 单位:秒
	 * @param key
	 * @param value
	 * @param ttl
	 */
	public void save(String key, Serializable value, int ttl);
	
	/**
	 * 存储数据
	 * @param key
	 * @param value
	 */
	public void save(String key, String value);
	
	/**
	 * 存储数据,并设置过期时间
	 * 单位:秒
	 * @param key
	 * @param value
	 * @param ttl
	 */
	public void save(String key, String value, int ttl);
	
	/**
	 * 更新过期时间
	 * 单位:秒
	 * @param ttl
	 */
	public void expire(String key ,int ttl);
	
	/**
	 * 查看key是否存在
	 * @param key
	 */
	public boolean isExsit(String key);

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
	public Object getValue(String key);
	
}
