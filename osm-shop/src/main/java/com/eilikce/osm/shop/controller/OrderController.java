package com.eilikce.osm.shop.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eilikce.osm.core.bo.common.Cart;
import com.eilikce.osm.core.bo.transformable.Consumer;
import com.eilikce.osm.core.bo.transformable.RecordOrder;
import com.eilikce.osm.shop.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	private static Logger logger = Logger.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * 提交订单
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/orderCommitt.do")
	public ModelAndView orderCommit(HttpSession session){
		
		Cart cart = (Cart) session.getAttribute("cart");
		Consumer consumerBo = (Consumer) session.getAttribute("consumerBo");
		
		// 创建新订单
		RecordOrder recordOrderBo = orderService.orderBoCreate(cart, consumerBo);
		// 订单入库
		orderService.addorderBo(recordOrderBo);
		logger.info("订单号："+recordOrderBo.getOrderId()+"，信息入库成功");
		
		
		//跳转支付页面
		ModelAndView modelAndView  = new ModelAndView("consumer/pay");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/orderSelect.do")
	public ModelAndView orderSelect(HttpSession session){
		
		ModelAndView modelAndView  = new ModelAndView("consumer/orderSelect");
		
		return modelAndView;
	}

}
