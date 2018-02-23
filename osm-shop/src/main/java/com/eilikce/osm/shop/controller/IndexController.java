package com.eilikce.osm.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eilikce.osm.core.bo.Cart;
import com.eilikce.osm.core.bo.CommodityGroupItemBo;
import com.eilikce.osm.core.bo.ConsumerBo;
import com.eilikce.osm.entity.consumer.Consumer;
import com.eilikce.osm.shop.service.IndexService;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	private static Logger logger = Logger.getLogger(IndexController.class);
	
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
		ConsumerBo consumerBo = new ConsumerBo(addr, name, phone);
		Consumer consumer = consumerBo.ConsumerTransform();
		Cart cart = new Cart(consumer);
		session.setAttribute("consumerBo", consumerBo);
		session.setAttribute("cart", cart);
		
		logger.info("新建用户:"+consumer.getName()+",联系电话:"+consumer.getPhone());
		
	}
	
	@RequestMapping(value = "/group.do")
	public ModelAndView group() {
		
		List<CommodityGroupItemBo> groupItemList = service.getAllCommodityGroupAndItem();
		
		ModelAndView modelAndView = new ModelAndView("consumer/group");
		modelAndView.addObject("groupItemList",groupItemList);
		
		return modelAndView;
	}
	
}
