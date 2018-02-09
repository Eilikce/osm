package com.eilikce.osm.util;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	private static Logger logger = Logger.getLogger(JsonUtil.class);
	
	/**
	 * 对象转json工具方法
	 * @param object
	 * @return
	 */
	public static String objectToJson(Object object) {
		String json = "";
		ObjectMapper mapper = new ObjectMapper(); 
		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.error("Object 到 Json 转换异常");
			e.printStackTrace();
		} 
		return json;
	}
	
	/**
	 * 对象转json工具方法，替换日期格式
	 * @param object
	 * @param format
	 * @return
	 */
	public static String objectToJsonTransformDate(Object object , String format) {
		String json = "";
		ObjectMapper mapper = new ObjectMapper(); 
		mapper.setDateFormat(new SimpleDateFormat(format));
		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.error("Object 到 Json 转换异常");
			e.printStackTrace();
		} 
		return json;
	}
	
}

