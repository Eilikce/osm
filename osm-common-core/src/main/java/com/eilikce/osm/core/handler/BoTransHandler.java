package com.eilikce.osm.core.handler;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eilikce.osm.core.bo.EntityTransBo;
import com.eilikce.osm.entity.CommonEntityPo;

public class BoTransHandler {

	private static final Logger LOG = LoggerFactory.getLogger(BoTransHandler.class);
	
	/**
	 * 转换 entityList 为 boList 
	 * 需要传入Bo模型类的Class
	 * 利用newInstance创建bo对象，再放入boList
	 * 
	 * 注：如果使用BoTransHandler转换器，要求bo模型必须实现无参构造
	 * 
	 * @param <T1> 继承自BoTransInter的类
	 * @param <T2> 可被转换的实体类
	 * @param boClazz	Bo模型类的class
	 * @param entityList	数据库实体的list
	 * @return
	 */
	public static <T1 extends EntityTransBo<T2>, T2 extends CommonEntityPo> List<T1> entityListToBoList(Class<T1> boClazz,
                                                                                                        List<T2> entityList) {

		List<T1> boList = new ArrayList<T1>();

		try {
			for (T2 entity : entityList) {
				T1 bo = boClazz.newInstance();
				BeanUtils.copyProperties(bo, entity);
				bo.transHook(entity);//调用附加方法钩子
				boList.add(bo);
			}
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			LOG.error("转换 entityList 为 boList 失败",e);
		}

		return boList;
	}
	
	
	/**
	 * 转换 boList 为 entityList
	 * @param <T1> 继承自BoTransInter的类
	 * @param <T2> 可被转换的实体类
	 * @param boList	Bo模型List
	 * @param entityClazz	entity的Class
	 * @return
	 */
	public static <T1 extends EntityTransBo<T2>, T2 extends CommonEntityPo> List<T2> boListToEntityList(List<T1> boList, Class<T2> entityClazz){
		List<T2> entityList = new ArrayList<T2>();
		try{
			for(T1 bo : boList){
				T2 entity = bo.transToEntity(entityClazz);
				entityList.add(entity);
			}
		}catch(Exception e){
			LOG.error("转换 boList 为 entityList");
			e.printStackTrace();
		}
		
		return entityList;
	}
	
}
