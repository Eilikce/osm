package com.eilikce.osm.api.repository.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.eilikce.osm.api.repository.config.OsmAuthConfig;
import com.eilikce.osm.api.repository.module.User;

@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Autowired
	private OsmAuthConfig osmAuthConfig;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		if(osmAuthConfig.isFree()){
			
			return true;
		}
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		if(user!=null){
			return true;
		}else{
			response.sendRedirect("/osm-api/loginPage");
			return false;
		}
	}

}
