package com.eilikce.osm.shop.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.eilikce.osm.redis.dao.CommonDao;
import com.eilikce.osm.shop.exception.AuthorizationException;

/**
 * Osm会话管理器
 * Redis形式存储的抽象模板类
 * @author wanghw
 *
 */
public abstract class RedisSessionManager implements SessionManager {
	
	private static final Logger LOG = LoggerFactory.getLogger(RedisSessionManager.class);
	
	@Autowired
	private CommonDao redisCommonDao;
	
	@Value("#{osmProperties['osm.sessionTimeout']}")
	private int sessionTimeout;
	
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
	public void refreshSession(HttpServletRequest request, HttpServletResponse response) {
		String key = getSessionId(request, response);
		redisCommonDao.expire(key, sessionTimeout);
		LOG.debug("刷新会话存活时间。key: " + key + " ,ttl:" + sessionTimeout +"秒");
	}
	
	/**
	 * 根据会话Id，查看会话是否存
	 * @param sessionId
	 * @return
	 */
	protected boolean hasOsmSession(String sessionId) {
		if(sessionId==null) {
			return false;
		}
		return redisCommonDao.isExsit(sessionId);
	}
	
	/**
	 * 根据会话Id获取会话
	 * 如果会话不存在,则创建新会话
	 * @param sessionId
	 * @return
	 */
	protected OsmSession getOsmSession(String sessionId) {
		OsmSession session = (OsmSession) redisCommonDao.getValue(sessionId);
		if(session!=null) {
			//如果session存在则返回session
			LOG.debug("获取了会话Id为"+sessionId+"的会话");
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
		LOG.debug("存储了会话Id为"+sessionId+"的会话");
		
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
	 * @param sessionId
	 */
	protected void deleteOsmSession(String sessionId) {
		redisCommonDao.delete(sessionId);
		LOG.debug("删除了会话Id为"+sessionId+"的会话");
	}

}
