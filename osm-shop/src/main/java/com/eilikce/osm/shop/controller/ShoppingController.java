package com.eilikce.osm.shop.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eilikce.osm.core.bo.common.CommodityShow;
import com.eilikce.osm.shop.service.ShoppingService;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

	private static Logger logger = Logger.getLogger(ShoppingController.class);
	
	@Autowired
	private ShoppingService service;
	
	@RequestMapping(value = "/commodity.do" , params = { "itemId" })
	public List<CommodityShow> enterCommodity(@RequestParam("groupId") int groupId , @RequestParam("itemId") int itemId){
		
		//根据小类itemId获取小类下所有商品
		List<CommodityShow> commodityShowList = service.getCommodityByGroupIdItemId(groupId , itemId);
		
		logger.info("根据小类itemId获取小类下所有商品");
		
		return commodityShowList;
	}
	
	/**
	 * 搜索跳转
	 * @param groupId
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value = "/commoditySearch.do" , params = { "search" })
	public List<CommodityShow> enterCommoditySearch2(@RequestParam("search") String search){
		
		//根据搜索内容所有商品
		List<CommodityShow> commodityShowList = service.getCommodityBySearch(search);
		
		logger.info("根据搜索内容所有商品");
		
		return commodityShowList;
	}
	
}
