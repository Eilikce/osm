package com.eilikce.osm.shop.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.eilikce.osm.core.bo.common.Consumer;
import com.eilikce.osm.shop.exception.AuthorizationException;
import com.eilikce.osm.shop.session.OsmSession;
import com.eilikce.osm.shop.session.SessionManager;

/**
 * 微信登录服务实现
 * 
 * @author Eilik
 *
 */
public class LoginServiceWxImpl implements LoginService {

	private static Logger logger = Logger.getLogger(LoginServiceWxImpl.class);

	@Autowired
	private SessionManager sessionManager;

	@Override
	public String authorizedFailed() {
		return "authorizedFailed";
	}

	@Override
	public String login(HttpServletRequest request, HttpServletResponse response, Map<String, String> paramsMap) {
		String msg = "";

		String addr = paramsMap.get("addr");
		String name = paramsMap.get("name");
		String phone = paramsMap.get("phone");
		
		try {
			// 登录操作
			OsmSession session = sessionManager.login(request, response);// 用户登录，并创建会话
			msg = (String) session.getAttribute("wxCreateMsg");

			Consumer consumer = new Consumer(addr, name, phone);// 创建新用户
			session.setAttribute("osmConsumer", consumer);// 创建用户，放入到会话

			sessionManager.saveSession(session);// 保存会话

			logger.info("新用户登录成功，用户名：" + consumer.getInfo().getName() + "。");
		} catch (AuthorizationException e) {
			logger.error("鉴权失败", e);
			msg = e.getErrorMsg();
		}
		
		return msg;

	}

}
