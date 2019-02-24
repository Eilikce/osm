package com.eilikce.osm.api.repository.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eilikce.osm.api.repository.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService homeService;
	
	/**
	 * 默认页面
	 * @return
	 */
	@RequestMapping("home")
	String home() {
		return "home"	;
	}

	/**
	 * 登陆页面
	 * @return
	 */
	@RequestMapping("loginPage")
	String loginPage() {
		return "login"	;
	}

	/**
	 * 登陆
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	String login(HttpServletRequest request) {
		String msg = homeService.login(request);
		
		return msg;
	}
	
	/**
	 * 仓库页面
	 * @return
	 */
	@RequestMapping("api")
	String api() {
		return "api"	;
	}

	
}
