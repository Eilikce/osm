package com.eilikce.osm.shop.bo;

/**
 * 
 * @author Eilik
 *
 * 简单Bo转换模型（Bo包含全部Entity实体属性一一对应） 接口
 * 实现此接口，可使用BoTransHandler中的Bo与Entity的List转换器
 * 只用于 简单实体类的简单Bo模型，固定的一对一类型List转换
 * 注：如果使用BoTransHandler 的 entityList 为 boList 转换器，要求Bo模型必须实现无参构造
 *
 * @param <T>	Bo模型对应的实体模型
 */
public interface BoTransInter<T> {
	
	/**
	 * 转换Bo模型为Entity数据库实体模型
	 * @return
	 */
	public abstract T transToEntity();
	
	/**
	 * 使用数据库实体模型Entity填充Bo模型
	 * @param entity
	 * @return
	 */
	public abstract BoTransInter<?> fillWithEntity(T entity);
	
}
