package com.eilikce.osm.shop.session.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eilikce.osm.shop.session.OsmSession;
import com.eilikce.osm.shop.session.RedisSessionManager;

/**
 * 默认
 * Redis存储型会话管理器
 * @author wanghw
 *
 */
public class DefaultRedisSessionManager extends RedisSessionManager{

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
	 * 直接从请求中获取sessionId
	 * @param request
	 * @return
	 */
	private String sessionId(HttpServletRequest request) {
		
		String sessionId = request.getSession().getId();
		
		return sessionId;
	}

}
