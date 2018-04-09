package com.eilikce.osm.shop.session.wx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.eilikce.osm.shop.session.OsmSession;
import com.eilikce.osm.shop.session.SessionManager;

/**
 * 单例形式
 * 微信会话管理器
 * 
 * 用于获取会话和鉴权
 * 
 * @author wanghw
 *
 */
public class WxSessionManager extends SessionManager{
	
	@Autowired
	RedisTemplate<String,Object> redisTemplate;

	@Override
	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OsmSession getSession(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
