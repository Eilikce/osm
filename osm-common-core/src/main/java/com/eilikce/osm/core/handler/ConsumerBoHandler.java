package com.eilikce.osm.core.handler;

import org.apache.log4j.Logger;

import com.eilikce.osm.util.UniqueIdCreater;

public class ConsumerBoHandler{
	
	private static Logger logger = Logger.getLogger(ConsumerBoHandler.class);
	
	/**
	 * consumerId生成器
	 * 以姓名电话地址
	 * 作为第一唯一性标识
	 * @param name
	 * @param phone
	 * @param addr
	 * @return
	 */
	public static String consumerIdCreater(String name,String phone,String addr){
		String unique_msg = name+phone+addr;
		String consumerId = UniqueIdCreater.uniqueIdCreater(unique_msg);
		return consumerId;
	}
	
}
