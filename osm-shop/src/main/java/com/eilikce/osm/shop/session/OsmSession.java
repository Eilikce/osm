package com.eilikce.osm.shop.session;

import java.util.HashMap;
import java.util.Map;

/**
 * Osm会话对象
 * @author wanghw
 *
 */
public class OsmSession {
	
	/**
	 * 属性绑定map
	 */
	private Map<String,OsmSessionValue> attrMap = new HashMap<String,OsmSessionValue>();
	
	/**
	 * 会话id
	 */
	private String sessionId;

	/**
	 * 使用会话id构造一个session
	 * @param sessionId
	 */
	public OsmSession(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * 设置属性
	 * @param attr
	 * @param value
	 */
	public void setAttribute(String attr, OsmSessionValue value){
		
		attrMap.put(attr, value);
		
	}
	
	/**
	 * 获取属性
	 * @param attr
	 * @return
	 */
	public Object getAttribute(String attr){
		OsmSessionValue value = attrMap.get(attr);
		
		return value;
	}
	
	/**
	 * 获取会话Id
	 * @return
	 */
	public String getSessionId() {
		return sessionId;
	}
	
}
