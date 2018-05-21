package com.eilikce.osm.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eilikce.osm.core.bo.common.Consumer;
import com.eilikce.osm.shop.session.OsmSession;
import com.eilikce.osm.shop.session.SessionManager;
import com.qcloud.weapp.ConfigurationException;
import com.qcloud.weapp.authorization.LoginServiceException;

/**
 * 登陆控制器
 * 
 * @author wanghw
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private SessionManager sessionManager;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam("addr") String addr, @RequestParam("name") String name,
			@RequestParam("phone") String phone){

		String msg = "";
		
		// 1.首先检测登陆信息
		boolean isLogin = false;
		// 调用检查登录接口，成功后可以获得用户信息，进行正常的业务请求
		isLogin = sessionManager.loginCheck(request, response);
		
		// 2.拿到登陆检测结果，尝试登陆操作
		try {
			if(isLogin) {
				logger.info("用户已登录，无需重复登陆。");
				msg = "";
			}else {
				//登录操作
				OsmSession session = sessionManager.login(request, response);//用户登录，并创建会话
				msg = session.getCreateMsg();
				Consumer consumer = new Consumer(addr, name, phone);//创建新用户
				session.setAttribute("osmConsumer", consumer);//创建用户，放入到会话
				
				sessionManager.saveSession(session);//保存会话
				logger.info("新用户登录，用户名：" + consumer.getInfo().getName() + "。");
			}
		} catch (LoginServiceException e) {
			msg = e.getErrorMsgJson();
			logger.error("微信验证失败",e);
		} catch (JSONException e) {
			logger.error("微信验证失败，JSON解析失败。",e);
		} catch (ConfigurationException e) {
			logger.error("微信验证失败，配置错误。",e);
		}
		return msg;
		
		
	}
}
