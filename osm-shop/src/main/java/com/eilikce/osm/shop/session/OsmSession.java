package com.eilikce.osm.shop.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Osm会话对象
 * @author wanghw
 *
 */
public class OsmSession implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 属性绑定map
	 */
	private Map<String,Object> attrMap = new HashMap<String,Object>();
	
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
	 * 值为Redis可序列化对象
	 * @param attr
	 * @param value
	 */
	public void setAttribute(String attr, Serializable value){
		setAttributeObject(attr, value);
	}
	
	/**
	 * 设置属性
	 * 值为String对象
	 * @param attr
	 * @param value
	 */
	public void setAttribute(String attr, String value){
		setAttributeObject(attr, value);
	}
	
	/**
	 * 设置属性
	 * 
	 * 私有方法
	 * 值为Object对象
	 * @param attr
	 * @param value
	 */
	private final void setAttributeObject(String attr, Object value){
		attrMap.put(attr, value);
	}
	
	/**
	 * 获取属性值
	 * @param attr
	 * @return
	 */
	public Object getAttribute(String attr){
		Object value = attrMap.get(attr);
		
		return value;
	}
	
	/**
	 * 获取会话Id
	 * @return
	 */
	public String getSessionId() {
		return sessionId;
	}
	
	/**
	 * 获取全部属性名
	 * @return
	 */
	public Set<String> getAllAttributes(){
		Set<String> attrSet = attrMap.keySet();
		return attrSet;
	}

}
