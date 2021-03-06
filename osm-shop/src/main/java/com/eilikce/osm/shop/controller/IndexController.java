package com.eilikce.osm.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eilikce.osm.core.bo.common.Cart;
import com.eilikce.osm.core.bo.common.CommodityGroupItem;
import com.eilikce.osm.core.bo.common.Consumer;
import com.eilikce.osm.shop.service.IndexService;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private IndexService service;
	
	@RequestMapping("/welcome.do")
	public ModelAndView welcome(){
		ModelAndView modelAndView  = new ModelAndView("consumer/welcome");
		return modelAndView;
	}

	
	/**
	 * 进入超市按钮
	 * 要求设置用户session信息
	 */
	@RequestMapping(value = "/enterOsm.do", params = { "addr", "name", "phone" })
	@ResponseBody
	public void enterOsm(@RequestParam("addr") String addr, @RequestParam("name") String name,
			@RequestParam("phone") String phone, HttpSession session) {

		//用户信息放入session
		Consumer consumer = new Consumer(addr, name, phone);
		Cart cart = new Cart(consumer);
		session.setAttribute("consumer", consumer);
		session.setAttribute("cart", cart);
		
		LOG.info("新建用户:"+consumer.getInfo().getName()+",联系电话:"+consumer.getInfo().getPhone());
		
	}
	
	@RequestMapping(value = "/group.do")
	public ModelAndView group() {
		
		List<CommodityGroupItem> groupItemList = service.getAllCommodityGroupAndItem();
		
		ModelAndView modelAndView = new ModelAndView("consumer/group");
		modelAndView.addObject("groupItemList",groupItemList);
		
		return modelAndView;
	}
	
}
