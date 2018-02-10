package com.eilikce.osm.service;

import javax.servlet.http.HttpSession;

public interface CartService {
	/** 向购物车添加货品 **/
	int addCommodity(String commodityId , HttpSession session);
	
	/** 向购物车减少货品 **/
	int dropCommodity(String commodityId , HttpSession session);
	
	/** 获取购物车总价 **/
	float findTotalPrice(HttpSession session);
	
	/** 清空购物车 **/
	void emptyCommodity(HttpSession session);
	
}
