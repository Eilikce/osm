package com.eilikce.osm.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eilikce.osm.shop.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	private static final Logger LOG = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/openCart.do")
	public ModelAndView openCart() {
		
		ModelAndView modelAndView  = new ModelAndView("consumer/cart");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/addCommoidity.do" , params = { "commodityId"})
	@ResponseBody
	public Map<String,Number> addCommoidity(@RequestParam("commodityId") String commodityId, HttpSession session) {
		
		int count = cartService.addCommodity(commodityId, session);
		float totalPrice = cartService.findTotalPrice(session);
		Map<String, Number> result = new HashMap<String, Number>();
		result.put("count", count);
		result.put("totalPrice", totalPrice);
		
		LOG.debug("向购物车添加一个货品,货品编号:"+commodityId);
		return result;
	}

	@RequestMapping(value = "/dropCommoidity.do" , params = { "commodityId"})
	@ResponseBody
	public Map<String,Number> dropCommoidity(@RequestParam("commodityId") String commodityId, HttpSession session) {
		
		int count = cartService.dropCommodity(commodityId, session);
		float totalPrice = cartService.findTotalPrice(session);
		Map<String, Number> result = new HashMap<String, Number>();
		result.put("count", count);
		result.put("totalPrice", totalPrice);
		
		LOG.debug("向购物车添加一个货品,货品编号:"+commodityId);
		return result;
	}

	@RequestMapping(value = "/emptyCart.do")
	@ResponseBody
	public Map<String,Number> emptyCart(HttpSession session) {
		
		cartService.emptyCommodity(session);
		
		float totalPrice = cartService.findTotalPrice(session);
		Map<String, Number> result = new HashMap<String, Number>();
		result.put("totalPrice", totalPrice);
		
		LOG.info("清空购物车操作完成");
		return result;
	}
	
}
