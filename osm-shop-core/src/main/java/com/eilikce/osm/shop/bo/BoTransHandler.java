package com.eilikce.osm.shop.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class BoTransHandler {

	private static Logger logger = Logger.getLogger(BoTransHandler.class);
	
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
	public static <T1 extends BoTransInter<T2>, T2> List<T1> entityListToBoList(Class<T1> boClazz,
			List<T2> entityList) {

		List<T1> boList = new ArrayList<T1>();

		try {
			for (T2 entity : entityList) {
				T1 bo;
				bo = boClazz.newInstance();
				bo.fillWithEntity(entity);
				boList.add(bo);
			}
		} catch (InstantiationException e) {
			logger.error("转换 entityList 为 boList 失败");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.error("转换 entityList 为 boList 失败");
			e.printStackTrace();
		}

		return boList;
	}
	
	
	/**
	 * 转换 boList 为 entityList
	 * @param <T1> 继承自BoTransInter的类
	 * @param <T2> 可被转换的实体类
	 * @param boList	Bo模型List
	 * @return
	 */
	public static <T1 extends BoTransInter<T2>, T2> List<T2> boListToEntityList(List<T1> boList){
		List<T2> entityList = new ArrayList<T2>();
		try{
			for(T1 bo : boList){
				entityList.add(bo.transToEntity());
			}
		}catch(Exception e){
			logger.error("转换 boList 为 entityList");
			e.printStackTrace();
		}
		
		return entityList;
	}
	
}
