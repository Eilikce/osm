package com.eilikce.osm.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestConstroller {
	@RequestMapping(value = "/jsp/test.do", method = RequestMethod.GET)
	public ModelAndView myMethod(HttpServletRequest resquest,HttpServletResponse response,
			@PathVariable("user") String user, ModelMap modelMap){
		
		modelMap.put("loginUser",user);
		return new ModelAndView("/login/hello",modelMap);
		
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String registPost(){
		return "/welcome";
	}
}