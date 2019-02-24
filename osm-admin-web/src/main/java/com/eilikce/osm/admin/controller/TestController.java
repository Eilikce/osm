package com.eilikce.osm.admin.controller;

import com.eilikce.osm.dao.CommodityDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")
public class TestController {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private CommodityDao dao;
	
	@RequestMapping("/test.do")
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response){
		
		LOG.debug("进入controller方法");


        Subject subject = SecurityUtils.getSubject();

        subject.login(new UsernamePasswordToken("root","222"));


        Session session = subject.getSession();
        String id = (String) session.getId();

        System.out.println(id);
//
//		List<Commodity> list = dao.selectAllCommodity();
//		LOG.debug(list);
		
		
		
		return "test";
	}


	@RequestMapping("/test2.do")
	@ResponseBody
    @RequiresRoles("admin")
	public String test2(HttpServletRequest request, HttpServletResponse response){

		LOG.debug("权限admin");


        Subject subject = SecurityUtils.getSubject();


        String x = subject.getPrincipal().toString();
        System.out.println(x);
        Session session = subject.getSession();
        String id = (String) session.getId();

        System.out.println(id);
//
//		List<Commodity> list = dao.selectAllCommodity();
//		LOG.debug(list);



		return "auth";
	}

	@RequestMapping("/test3.do")
	@ResponseBody
    @RequiresRoles("admin")
	public String test3(HttpServletRequest request, HttpServletResponse response){

		LOG.debug("权限admin");


        Subject subject = SecurityUtils.getSubject();

        subject.logout();

		return "logout";
	}
}
