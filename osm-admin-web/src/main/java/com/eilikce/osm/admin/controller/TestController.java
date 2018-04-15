package com.eilikce.osm.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eilikce.osm.dao.CommodityDao;
import com.eilikce.osm.entity.consumer.CommodityPo;

@Controller
@RequestMapping("/test")
public class TestController {
	
	private static Logger logger = Logger.getLogger(TestController.class);
	
	@Autowired
	private CommodityDao dao;
	
	@RequestMapping("/test.do")
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response){
		
		logger.debug("进入controller方法");

		
		List<CommodityPo> list = dao.selectAllCommodity();
		logger.debug(list);
		
		
		
		return "test";
	}
}
