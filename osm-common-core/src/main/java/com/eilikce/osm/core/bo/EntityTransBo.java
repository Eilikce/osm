package com.eilikce.osm.core.bo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eilikce.osm.entity.CommonEntity;

/**
 * 可以与数据库实体Entity对象相互转换的
 * Bo抽象模型
 * 
 * 注：要求子类必须存在无参构造方法
 * 
 * @author wanghw
 *
 * @param <T>	Entity实体类
 */
public abstract class EntityTransBo<T extends CommonEntity> implements CommonBo {
	
	private static final Logger LOG = LoggerFactory.getLogger(EntityTransBo.class);
	
	/**
	 * 通过Bo对象生成数据库实体对象
	 * @param entityClazz
	 * @return	数据库po对象
	 */
	public final T transToEntity(Class<T> entityClazz){
		T entity = null;
		try {
			entity = entityClazz.newInstance();
			
			BeanUtils.copyProperties(entity, this);
			
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			LOG.error(this.getClass().getSimpleName()+"转化实体失败!",e);
		}
		
		return entity;
	}
	
	/**
	 * Entity转换为Bo时的附加操作钩子方法
	 * @param entity
	 */
	public void transHook(T entity){
		
	}
	
}
