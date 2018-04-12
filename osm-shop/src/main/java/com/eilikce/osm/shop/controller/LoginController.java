package com.eilikce.osm.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eilikce.osm.core.bo.common.Cart;
import com.eilikce.osm.core.bo.common.Consumer;
import com.eilikce.osm.shop.session.OsmSession;
import com.eilikce.osm.shop.session.SessionManager;

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
		
		boolean isLogin = sessionManager.loginCheck(request, response);
		
		if(isLogin) {
			//用户已登录
			OsmSession session = sessionManager.getSession(request, response);
			Consumer consumer = (Consumer) session.getAttribute("OsmConsumer");
			logger.info("用户\"" + consumer.getInfo() + "\"已登录，无需重复登陆。");
		}else {
			//登陆操作
			OsmSession session = sessionManager.login(request, response);
			Consumer consumer = new Consumer(addr, name, phone);
			Cart cart = consumer.createCart();
			
			session.setAttribute("consumer", consumer);
			session.setAttribute("cart", cart);
			
		}
		
		return "success";
	}
}