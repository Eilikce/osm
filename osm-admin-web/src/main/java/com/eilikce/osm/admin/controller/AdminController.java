package com.eilikce.osm.admin.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eilikce.osm.admin.service.AdminService;
import com.eilikce.osm.core.bo.transformable.AdminBo;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static Logger logger = Logger.getLogger(AdminController.class);
	
	@Autowired
	private AdminService service;
	
	@RequestMapping(value = "/findAll.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView findAll() {
		
		List<AdminBo> allAdminBo = service.getAllAdmin();
		String allAdminStr = allAdminBo.toString();
		ModelAndView modelAndView = new ModelAndView("/test/test");
		modelAndView.addObject("info", allAdminStr);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/findCount", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView findCount(){
		
		int count = service.getCount();
		ModelAndView modelAndView = new ModelAndView("/test/test");
		modelAndView.addObject("info", count);
		
		return modelAndView;
	}
	
	/**
	 * 添加一个admin用户
	 * @param id
	 * @param user_name
	 * @param password
	 * @param permissions
	 * @return
	 */
	@RequestMapping(value = "/addAdmin", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addAdmin(String user_name, String password, String permissions){
		
		String addResult = service.addAdmin(user_name, password, permissions);
		
		ModelAndView modelAndView = new ModelAndView("/test/test");
		if(addResult.equals("sucess")){
			modelAndView.addObject("info", "插入管理员信息："+ user_name+"，"+password+"，"+permissions);
		}else if(addResult.equals("repeat")){
			modelAndView.addObject("info", "用户名" + user_name + "重复，请重新插入新的用户名");
		}else{
			modelAndView.addObject("error", "插入失败，检查日志");
		}
		
		return modelAndView;
	}

}
