package com.eilikce.osm.core.handler;

/**
 * 
 * @author Eilik
 *
 * Bo模型转换为Entity实体模型
 * 
 *
 * @param <T>	Bo模型对应的实体模型
 */
public abstract class BoEntityTrans<T> {
	
	/**
	 * 数据库实体模型Entity填充Bo模型钩子方法
	 * 可实现特定附加内容
	 * @param entity
	 * @return 
	 * @return
	 */
	public void transHook(T entity){};
	
}
