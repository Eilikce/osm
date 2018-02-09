package com.eilikce.osm.controller.consumer;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	private static Logger logger = Logger.getLogger(OrderController.class);
	
	/*@Autowired
	private OrderService service;*/
	
	@RequestMapping(value = "/orderSelect.do")
	public ModelAndView orderSelect(HttpSession session){
		
		ModelAndView modelAndView  = new ModelAndView("consumer/orderSelect");
		
		return modelAndView;
	}

}
