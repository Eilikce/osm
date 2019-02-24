package com.eilikce.osm.shop.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eilikce.osm.shop.exception.AuthorizationException;

/**
 * Osm会话管理器
 * @author wanghw
 *
 */
public interface SessionManager {
	
	/**
	 * 鉴权
	 * @param request
	 * @param response
	 * @return
	 * @throws AuthorizationException 
	 */
	public abstract boolean loginCheck(HttpServletRequest request, HttpServletResponse response) throws AuthorizationException ;
	
	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @return
	 * @throws AuthorizationException
	 */
	public abstract OsmSession login(HttpServletRequest request, HttpServletResponse response) throws AuthorizationException ;
	
	/**
	 * 注销登陆
	 * @param request
	 * @param response
	 */
	public abstract void logout(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 获取会话
	 * 获取失败返回空
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract OsmSession getSession(HttpServletRequest request, HttpServletResponse response);

	/**
	 * 保存会话
	 */
	public abstract void saveSession(OsmSession session);
	
	/**
	 * 获取会话id
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String getSessionId(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 刷新会话时间
	 */
	public void refreshSession(HttpServletRequest request, HttpServletResponse response);

}
