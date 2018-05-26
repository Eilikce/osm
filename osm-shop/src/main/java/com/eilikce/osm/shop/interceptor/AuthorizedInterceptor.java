package com.eilikce.osm.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.eilikce.osm.shop.exception.AuthorizationException;
import com.eilikce.osm.shop.session.SessionManager;

/**
 * 鉴权拦截器
 * @author Eilik
 *
 */
public class AuthorizedInterceptor implements HandlerInterceptor{

	private static Logger logger = Logger.getLogger(AuthorizedInterceptor.class);
	
	@Autowired
	private SessionManager sessionManager;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.debug("进入鉴权拦截器拦截器预处理。");
		
		boolean rtnFlag = false;
		
		boolean isLogin = false;
		try {
			isLogin = sessionManager.loginCheck(request, response);
		} catch (AuthorizationException e) {
			logger.error("鉴权拦截器处理异常。",e);
		}
		if(isLogin) {
			//刷新会话存活时间
			sessionManager.refreshSession(request, response);
			rtnFlag = true;
		}else {
			//转发到鉴权失败接口
			request.getRequestDispatcher("/login/authorizedFailed.do").forward(request, response);
			rtnFlag = false;
		}
		
		return rtnFlag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
