package com.eilikce.osm.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eilikce.osm.shop.service.PaymentService;

/**
 * @author Eilik
 *	付款功能控制器
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	/**
	 * 在线支付
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/onlinePayment.do")
	public ModelAndView onlinePayment(HttpSession session){
		
		
		paymentService.onlinePayment(session);
		
				
		return null;
	}

	/**
	 * 现金支付
	 * @param groupId
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value = "/cashOnDelivery.do" , params = { "groupId" , "itemId" })
	public ModelAndView cashOnDelivery(@RequestParam("groupId") int groupId , @RequestParam("itemId") int itemId){
		return null;
	}
	
	
}
