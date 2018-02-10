package com.eilikce.osm.core.bo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.eilikce.osm.entity.CommonEntity;

/**
 * Bo抽象模型
 * 可以与数据库实体Entity对象相互转换
 * @author wanghw
 *
 * @param <T>	Entity实体类
 */
public abstract class EntityTransBo<T extends CommonEntity> implements BoIntfc {
	
	private static Logger logger = Logger.getLogger(EntityTransBo.class);
	
	public final T transToEntity(Class<T> entityClazz){
		T entity = null;
		try {
			entity = entityClazz.newInstance();
			
			BeanUtils.copyProperties(entity, this);
			
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			logger.error(this.getClass().getSimpleName()+"转化实体失败!",e);
		}
		
		return entity;
	}
	
	/**
	 * Entity转换为Bo时的附加操作钩子方法
	 * @param entity
	 */
	public void transHook(T entity){};
	
}
