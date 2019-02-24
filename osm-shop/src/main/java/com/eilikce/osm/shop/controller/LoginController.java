package com.eilikce.osm.shop.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eilikce.osm.shop.service.LoginService;

/**
 * 登陆控制器
 * 
 * @author wanghw
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * 鉴权失败控制器
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/authorizedFailed.do")
	public String authorizedFailed(HttpServletRequest request, HttpServletResponse response) {
		
		return loginService.authorizedFailed();
	}

	/**
	 * 登录
	 * @param request
	 * @param response
	 * @param consumerId
	 * @param pass
	 * @return
	 */
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam(value = "consumerId" , required=false) String consumerId, @RequestParam(value = "pass" , required=false) String pass){

		HashMap<String,String> paramsMap = new HashMap<String,String>();
		paramsMap.put("consumerId", consumerId);
		paramsMap.put("pass", pass);
		
		String msg = loginService.login(request, response, paramsMap);
		
		return msg;
		
	}
}
