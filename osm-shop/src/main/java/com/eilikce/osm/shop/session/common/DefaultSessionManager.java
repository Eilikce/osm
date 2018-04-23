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
		String sessionId = sessionId(request);
		
		return hasOsmSession(sessionId);
	}

	@Override
	public OsmSession login(HttpServletRequest request, HttpServletResponse response) {
		String userId = sessionId(request);
		OsmSession session =  getOsmSession(userId);
		return session;
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		String userId = sessionId(request);
		deleteOsmSession(userId);
	}

	@Override
	public OsmSession getSession(HttpServletRequest request, HttpServletResponse response) {
		String userId = sessionId(request);
		OsmSession session =  getOsmSession(userId);
		return session;
	}

	@Override
	public void saveSession(OsmSession session) {
		saveOsmSession(session);
	}

	@Override
	public String getSessionId(HttpServletRequest request, HttpServletResponse response) {
		return sessionId(request);
	}

	/**
	 * 通过url中的phone参数值
	 * 作为sessionId
	 * @param request
	 * @return
	 */
	private String sessionId(HttpServletRequest request) {
		
		String sessionId = request.getRequestedSessionId();
		
		return sessionId;
	}

}
