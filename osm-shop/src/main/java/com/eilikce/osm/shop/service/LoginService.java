package com.eilikce.osm.shop.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
	
	/**
	 * 鉴权失败，返回失败字符串
	 * @return
	 */
	public String authorizedFailed();

	/**
	 * 登录功能
	 * @param request
	 * @param response
	 * @param paramsMap
	 * @return
	 */
	public String login(HttpServletRequest request, HttpServletResponse response, Map<String,String> paramsMap);
	
}
