package com.eilikce.osm.shop.session.wx;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.eilikce.osm.shop.session.OsmSession;
import com.eilikce.osm.shop.session.SessionManager;
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
public class WxSessionManager extends SessionManager{
	
	private static Logger logger = Logger.getLogger(WxSessionManager.class);
	
	@Override
	public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) {

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
	public OsmSession login(HttpServletRequest request, HttpServletResponse response) {

		UserInfo userInfo = wxLogin(request, response);
		String openId = userInfo.getOpenId();
		OsmSession session  = getOsmSession(openId);

		String wxUserInfoJson = getWxUserInfoJson(userInfo);//微信用户json形式
		
		session.setAttribute("wxUserInfo", wxUserInfoJson);
		
		logger.info("微信用户\""+userInfo.getNickName()+"\"登陆成功!openId:"+openId);
	
		return session;

	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OsmSession getSession(HttpServletRequest request, HttpServletResponse response) {

		UserInfo userInfo = getWxUserInfo(request, response);//获取微信用户信息
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

	/**
	 * 微信登陆
	 * @param request
	 * @param response
	 * @return
	 */
	private UserInfo wxLogin(HttpServletRequest request, HttpServletResponse response) {
		
		UserInfo userInfo = null;
		// 通过 ServletRequest 和 ServletResponse 初始化登录服务
		LoginService service = new LoginService(request, response);
		try {
			// 调用登录接口，如果登录成功可以获得登录信息
			userInfo = service.login();
			logger.info("微信登陆成功，用信息：" + userInfo.toString());

		} catch (LoginServiceException e) {
			// 登录失败会抛出登录失败异常
			logger.error("微信登陆失败", e);
		} catch (ConfigurationException e) {
			// SDK 如果还没有配置会抛出配置异常
			logger.error("微信登陆失败，SDK没有配置", e);
		}
		return userInfo;
	}
	/**
	 * 获取微信用户信息
	 * @param request
	 * @param response
	 * @return
	 */
	private UserInfo getWxUserInfo(HttpServletRequest request, HttpServletResponse response) {
		
		UserInfo userInfo = null ;
		LoginService service = new LoginService(request, response);		
		try {
			// 调用检查登录接口，成功后可以获得用户信息，进行正常的业务请求
			userInfo = service.check();
		} catch (LoginServiceException e) {
			logger.error("微信验证失败",e);
		} catch (JSONException e) {
			logger.error("微信验证失败，JSON解析失败。",e);
		} catch (ConfigurationException e) {
			logger.error("微信验证失败，配置错误。",e);
		}
		return userInfo;
	}
	
	/**
	 * 获取微信用户信息，Json形式
	 * @param request
	 * @param response
	 * @return
	 */
	private String getWxUserInfoJson(UserInfo userInfo) {
		
		String data = new JSONObject(userInfo).toString();
		return data;
	}

}