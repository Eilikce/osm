package com.eilikce.osm.shop.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eilikce.osm.core.bo.common.CommodityShow;
import com.eilikce.osm.shop.service.ShoppingService;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {

	private static Logger logger = Logger.getLogger(ShoppingController.class);
	
	@Autowired
	private ShoppingService service;
	
	@RequestMapping(value = "/commodity1.do" , params = { "groupId" , "itemId" })
	public ModelAndView enterCommodity1(@RequestParam("groupId") int groupId , @RequestParam("itemId") int itemId){
		
		//根据小类itemId获取小类下所有商品
		List<CommodityShow> commodityShowList = service.getCommodityByGroupIdItemId(groupId , itemId);
		
		ModelAndView modelAndView  = new ModelAndView("consumer/commodity1");
		modelAndView.addObject("commodityShowList", commodityShowList);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/commodity2.do" , params = { "itemId" })
	public ModelAndView enterCommodity2(@RequestParam("groupId") int groupId , @RequestParam("itemId") int itemId){
		
		//根据小类itemId获取小类下所有商品
		List<CommodityShow> commodityShowList = service.getCommodityByGroupIdItemId(groupId , itemId);
		
		ModelAndView modelAndView  = new ModelAndView("consumer/commodity2");
		modelAndView.addObject("commodityShowList", commodityShowList);
		logger.info("根据小类itemId获取小类下所有商品");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/commodity3.do" , params = { "itemId" })
	public ModelAndView enterCommodity3(@RequestParam("groupId") int groupId , @RequestParam("itemId") int itemId) {
		
		// 根据小类itemId获取小类下所有商品
		List<CommodityShow> commodityShowList = service.getCommodityByGroupIdItemId(groupId , itemId);

		ModelAndView modelAndView = new ModelAndView("consumer/commodity3");
		modelAndView.addObject("commodityShowList", commodityShowList);

		return modelAndView;
	}
	
	/**
	 * 搜索跳转2
	 * @param groupId
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value = "/commoditySearch2.do" , params = { "search" })
	public ModelAndView enterCommoditySearch2(@RequestParam("search") String search){
		
		//根据搜索内容所有商品
		List<CommodityShow> commodityShowList = service.getCommodityBySearch(search);
		
		ModelAndView modelAndView  = new ModelAndView("consumer/commodity2");
		modelAndView.addObject("commodityShowList", commodityShowList);
		logger.info("根据搜索内容所有商品");
		
		return modelAndView;
	}
	
}
