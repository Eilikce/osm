package com.eilikce.osm.shop.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.eilikce.osm.redis.dao.CommonDao;
import com.qcloud.weapp.ConfigurationException;
import com.qcloud.weapp.authorization.LoginServiceException;

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
	 * @throws ConfigurationException 
	 * @throws LoginServiceException 
	 */
	public abstract boolean loginCheck(HttpServletRequest request, HttpServletResponse response) ;
	
	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @throws ConfigurationException 
	 * @throws LoginServiceException 
	 * @throws IllegalArgumentException 
	 */
	public abstract OsmSession login(HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, LoginServiceException, ConfigurationException;
	
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
	 * @throws ConfigurationException 
	 * @throws LoginServiceException 
	 */
	public abstract OsmSession getSession(HttpServletRequest request, HttpServletResponse response) throws LoginServiceException, ConfigurationException;

	/**
	 * 保存会话
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract void saveSession(OsmSession session);
	
	/**
	 * 获取会话id
	 * @throws ConfigurationException 
	 * @throws LoginServiceException 
	 */
	public abstract String getSessionId(HttpServletRequest request, HttpServletResponse response) throws LoginServiceException, ConfigurationException;
	
	/**
	 * 刷新会话时间
	 * @throws ConfigurationException 
	 * @throws LoginServiceException 
	 */
	public void refreshSession(HttpServletRequest request, HttpServletResponse response) throws LoginServiceException, ConfigurationException {
		String key = getSessionId(request, response);
		redisCommonDao.expire(key, sessionTimeout);
		logger.debug("刷新会话存活时间。key: " + key + " ,ttl:" + sessionTimeout +"秒");
	}
	
	/**
	 * 根据会话Id，查看会话是否存
	 * @param sessionId
	 * @return
	 */
	protected boolean hasOsmSession(String sessionId) {
		return redisCommonDao.isExsit(sessionId);
	}
	
	/**
	 * 根据会话Id获取会话
	 * 如果会话不存在,则创建新会话
	 * 
	 * @param sessionId
	 */
	protected OsmSession getOsmSession(String sessionId) {
		OsmSession session = (OsmSession) redisCommonDao.getValue(sessionId);
		if(session!=null) {
			//如果session存在则返回session
			logger.debug("获取了会话Id为"+sessionId+"的会话");
		}else {
			//如果session不存在则创建session,并存储进redis
			session = new OsmSession(sessionId);
			redisCommonDao.save(sessionId, session, sessionTimeout);
		}
		return session;
	}

	/**
	 * 存储会话
	 * @param session
	 */
	protected void saveOsmSession(OsmSession session) {
		String sessionId = session.getSessionId();
		redisCommonDao.save(sessionId, session, sessionTimeout);
		logger.debug("存储了会话Id为"+sessionId+"的会话");
		
	}
	
	
	/**
	 * 删除会话
	 * @param session
	 */
	protected void deleteOsmSession(OsmSession session) {
		String sessionId = session.getSessionId();
		deleteOsmSession(sessionId);
	}
	/**
	 * 根据会话Id，删除会话
	 * @param session
	 */
	protected void deleteOsmSession(String sessionId) {
		redisCommonDao.delete(sessionId);
		logger.debug("删除了会话Id为"+sessionId+"的会话");
	}

}
