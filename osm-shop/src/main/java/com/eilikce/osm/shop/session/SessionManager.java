package com.eilikce.osm.shop.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class SessionManager {
	
	/**
	 * 登陆权限验证
	 * @return
	 */
	public abstract boolean loginCheck(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 登陆
	 */
	public abstract void login(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 注销登陆
	 */
	public abstract void logout(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 获取会话
	 * @param sessionId
	 * @return
	 */
	public abstract OsmSession getSession(HttpServletRequest request, HttpServletResponse response);
	
}
