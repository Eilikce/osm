package com.eilikce.osm.shop.session.wx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONException;

import com.eilikce.osm.shop.exception.AuthorizationException;
import com.eilikce.osm.shop.session.OsmSession;
import com.eilikce.osm.shop.session.RedisSessionManager;
import com.eilikce.osm.wxsdk.authorization.OsmLoginServiceException;
import com.eilikce.osm.wxsdk.authorization.OsmWxMsg;
import com.qcloud.weapp.ConfigurationException;
import com.qcloud.weapp.authorization.LoginService;
import com.qcloud.weapp.authorization.LoginServiceException;
import com.qcloud.weapp.authorization.UserInfo;

/**
 * 单例形式
 * 微信会话管理器
 * 
 * 用于获取会话和鉴权
 * 
 * @author wanghw
 *
 */
public class WxSessionManager extends RedisSessionManager{
	
	private static Logger logger = Logger.getLogger(WxSessionManager.class);
	
	@Override
	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) throws AuthorizationException {

		boolean rtnFlag = false;
		
		UserInfo userInfo = getWxUserInfo(request, response);

		// 有微信登陆权限，且session存在，则为已登陆
		if(userInfo!=null) {
			String openId = userInfo.getOpenId();
			rtnFlag = hasOsmSession(openId);
		}
		return rtnFlag;
	}

	@Override
	public OsmSession login(HttpServletRequest request, HttpServletResponse response) throws AuthorizationException {

		OsmSession session = null;
		try {
			OsmWxMsg msg = wxLogin(request, response);
			UserInfo userInfo = msg.getUserInfo();
			String openId = userInfo.getOpenId();
			
			String createMsg = msg.getMsgJson();
			session  = getOsmSession(openId);
			session.setAttribute("wxCreateMsg", createMsg);//放入会话创建信息
	
			session.setAttribute("wxUserInfo", userInfo);
			logger.info("微信用户\""+userInfo.getNickName()+"\"登陆成功!openId:"+openId);
			
		} catch (OsmLoginServiceException e) {
			logger.error("微信验证失败",e);
			AuthorizationException error = new AuthorizationException(e.getErrorMsgJson(), e);
			throw error;
		} catch (JSONException e) {
			logger.error("微信验证失败，JSON解析失败。",e);
		} catch (ConfigurationException e) {
			logger.error("微信验证失败，配置错误。",e);
		}
	
		return session;

	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OsmSession getSession(HttpServletRequest request, HttpServletResponse response) {

		UserInfo userInfo = null;
		try {
			userInfo = getWxUserInfo(request, response);//获取微信用户信息
		} catch (AuthorizationException e) {
			logger.error("微信鉴权失败",e);
			return null;
		}
		String openId = userInfo.getOpenId();//获取微信openId
		
		OsmSession session = null;
		
		if(hasOsmSession(openId)) {
			session = getOsmSession(openId);
		}
		
		return session;
	
	}
	
	@Override
	public void saveSession(OsmSession session) {
		saveOsmSession(session);
	}

	@Override
	public String getSessionId(HttpServletRequest request, HttpServletResponse response) {
		UserInfo userInfo = null;
		String openId = null;
		try {
			userInfo = getWxUserInfo(request, response);//获取微信用户信息
			if(userInfo!=null) {
				openId = userInfo.getOpenId();//获取微信openId
			}
		} catch (AuthorizationException e) {
			logger.error("微信鉴权异常",e);
		}
		
		return openId;
	}
	
	/**
	 * 微信登陆
	 * @param request
	 * @param response
	 * @throws ConfigurationException 
	 * @throws LoginServiceException 
	 * @throws IllegalArgumentException 
	 * @return
	 */
	private OsmWxMsg wxLogin(HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, OsmLoginServiceException, ConfigurationException {
		
		// 通过 ServletRequest 和 ServletResponse 初始化登录服务
		LoginService service = new LoginService(request, response);
		// 调用登录接口，如果登录成功可以获得登录信息
		
		OsmWxMsg msg = service.osmLogin();
		logger.info("微信登陆成功，用户昵称：" + msg.getUserInfo().getNickName());
		return msg;
	}
	/**
	 * 获取微信用户信息
	 * @param request
	 * @param response
	 * @throws ConfigurationException 
	 * @throws LoginServiceException 
	 * @return
	 * @throws AuthorizationException 
	 */
	private UserInfo getWxUserInfo(HttpServletRequest request, HttpServletResponse response) throws AuthorizationException {
		
		UserInfo userInfo = null ;
		LoginService service = new LoginService(request, response);		
		try {
			// 调用检查登录接口，成功后可以获得用户信息，进行正常的业务请求
			OsmWxMsg msg = service.osmCheck();
			userInfo = msg.getUserInfo();
			String error = msg.getMsgJson();
			if(error!=null) {
				logger.info("微信登陆检查未通过。"+error);
			}
		} catch (OsmLoginServiceException e) {
			logger.error("微信登陆检查失败。",e);
			AuthorizationException error = new AuthorizationException(e.getErrorMsgJson(), e);
			throw error;
		} catch (JSONException e) {
			logger.error("微信登陆检查失败，JSON解析失败。",e);
		} catch (ConfigurationException e) {
			logger.error("微信登陆检查失败，配置错误。",e);
		}
		
		return userInfo;
	}
	
}