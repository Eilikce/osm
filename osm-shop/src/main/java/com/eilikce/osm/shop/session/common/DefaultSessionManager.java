package com.eilikce.osm.shop.session.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eilikce.osm.shop.session.OsmSession;
import com.eilikce.osm.shop.session.SessionManager;

/**
 * 默认
 * 本地内存型会话管理器
 * @author wanghw
 *
 */
public class DefaultSessionManager implements SessionManager{

	@Override
	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) {
		OsmSession session = (OsmSession) request.getSession().getAttribute("OsmSession");
		return session != null;
	}

	@Override
	public OsmSession login(HttpServletRequest request, HttpServletResponse response) {
		
		String sessionId = request.getSession().getId();
		OsmSession session = new OsmSession(sessionId);
		request.getSession().setAttribute("OsmSession", session);
		
		return session;
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
	}

	@Override
	public OsmSession getSession(HttpServletRequest request, HttpServletResponse response) {
		OsmSession session =   (OsmSession) request.getSession().getAttribute("OsmSession");
		return session;
	}

	@Override
	public void saveSession(OsmSession session) {
		return;
	}

	@Override
	public String getSessionId(HttpServletRequest request, HttpServletResponse response) {
		return sessionId(request);
	}

	@Override
	public void refreshSession(HttpServletRequest request, HttpServletResponse response) {
		return ;
	}

	/**
	 * 直接从请求中获取sessionId
	 * @param request
	 * @return
	 */
	private String sessionId(HttpServletRequest request) {
		
		String sessionId = request.getSession().getId();
		
		return sessionId;
	}

}
