package com.eilikce.osm.shop.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.eilikce.osm.redis.dao.CommonDao;

/**
 * Osm会话管理器
 * @author wanghw
 *
 */
public abstract class SessionManager {
	
	private static Logger logger = Logger.getLogger(SessionManager.class);
	
	@Autowired
	private CommonDao redisCommonDao;
	
	@Value("#{osmProperties['osm.sessionTimeout']}")
	private int sessionTimeout;
	
	/**
	 * 鉴权
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract boolean loginCheck(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 登陆
	 * @param request
	 * @param response
	 */
	public abstract OsmSession login(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 注销登陆
	 * @param request
	 * @param response
	 */
	public abstract void logout(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 获取会话
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract OsmSession getSession(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 根据sessionId获取session
	 * 如果session不存在,则创建新session
	 * 
	 * @param sessionId
	 */
	protected OsmSession getSession(String sessionId) {
		OsmSession session = (OsmSession) redisCommonDao.getValue(sessionId);
		if(session!=null) {
			//如果session存在则返回session
			logger.debug("获取了sessionId为"+sessionId+"的session");
		}else {
			//如果session不存在则创建session,并存储进redis
			session = new OsmSession(sessionId);
			redisCommonDao.save(sessionId, session);
		}
		return session;
	}

	/**
	 * 存储session
	 * @param session
	 */
	protected void saveSession(OsmSession session) {
		String sessionId = session.getSessionId();
		redisCommonDao.save(sessionId, session, sessionTimeout);
		logger.debug("存储了sessionId为"+sessionId+"的session");
		
	}

}
