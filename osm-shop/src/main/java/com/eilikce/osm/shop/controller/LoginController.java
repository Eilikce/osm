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
	
	@RequestMapping("/authorizedFailed.do")
	public String authorizedFailed(HttpServletRequest request, HttpServletResponse response) {
		
		return loginService.authorizedFailed();
	}

	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam(value = "addr" , required=false) String addr, @RequestParam(value = "name" , required=false) String name,
			@RequestParam(value = "phone" , required=false) String phone){

		HashMap<String,String> paramsMap = new HashMap<String,String>();
		paramsMap.put("addr", addr);
		paramsMap.put("name", name);
		paramsMap.put("phone", phone);
		
		String msg = loginService.login(request, response, paramsMap);
		
		return msg;
		
	}
}
