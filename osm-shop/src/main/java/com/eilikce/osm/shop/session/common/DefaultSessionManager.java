package com.eilikce.osm.shop.session.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eilikce.osm.shop.session.OsmSession;
import com.eilikce.osm.shop.session.SessionManager;

/**
 * 默认会话管理器
 * 通过参数拼接userId作为验证条件
 * @author wanghw
 *
 */
public class DefaultSessionManager extends SessionManager{

	
	@Override
	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) {
		String userId = userId(request);
		
		return hasOsmSession(userId);
	}

	@Override
	public OsmSession login(HttpServletRequest request, HttpServletResponse response) {
		String userId = userId(request);
		OsmSession session =  getOsmSession(userId);
		return session;
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		String userId = userId(request);
		deleteOsmSession(userId);
	}

	@Override
	public OsmSession getSession(HttpServletRequest request, HttpServletResponse response) {
		String userId = userId(request);
		OsmSession session =  getOsmSession(userId);
		return session;
	}

	@Override
	public void saveSession(OsmSession session) {
		saveOsmSession(session);
	}

	/**
	 * 通过url中的userId参数值
	 * 作为sessionId
	 * @param request
	 * @return
	 */
	private String userId(HttpServletRequest request) {
		
		String userId = request.getParameter("userId");
		
		return userId;
	}
}
