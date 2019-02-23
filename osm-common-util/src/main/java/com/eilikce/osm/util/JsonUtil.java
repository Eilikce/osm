package com.eilikce.osm.util;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);
	
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
			LOG.error("Object 到 Json 转换异常");
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
			LOG.error("Object 到 Json 转换异常");
			e.printStackTrace();
		} 
		return json;
	}
	
}

