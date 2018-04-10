package com.eilikce.osm.shop.service;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.core.bo.common.Cart;
import com.eilikce.osm.core.bo.common.CommodityShow;
import com.eilikce.osm.core.bo.transformable.Commodity;
import com.eilikce.osm.dao.CommodityDao;
import com.eilikce.osm.entity.consumer.CommodityFurtherPo;

@Service
public class CartServiceImpl implements CartService{
	
	private static Logger logger = Logger.getLogger(CartServiceImpl.class);
	
	@Autowired
	private CommodityDao commodityDao;

	@Override
	public int addCommodity(String commodityId , HttpSession session) {
		
		CommodityFurtherPo commodityFurther =commodityDao.selectCommodityFurtherById(commodityId);
		Commodity commodity = new Commodity(commodityFurther);
		Cart cart = (Cart)session.getAttribute("cart");
		int count = cart.addCommodity(commodity);
		
		logger.debug("购物车货品列表："+cart.getCartHashMap().toString());
		logger.info("购物车新增货品："+commodity.getCommodityDetail());
		
		return count;
	}

	@Override
	public int dropCommodity(String commodityId, HttpSession session) {
		
		CommodityFurtherPo commodityFurther = commodityDao.selectCommodityFurtherById(commodityId);
		CommodityShow commodityShow = new CommodityShow(commodityFurther);
		
		Cart cart = (Cart) session.getAttribute("cart");
		int count = cart.dropCommodity(commodityShow);

		logger.debug("购物车货品列表：" + cart.getCartHashMap().toString());
		logger.info("购物车减少货品：" + commodityShow.getCommodityDetail());

		return count;
	}

	@Override
	public float findTotalPrice(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		float totalPrice = cart.getTotalPrice();
		return totalPrice;
	}
	
	@Override
	public void emptyCommodity(HttpSession session) {
		
		Cart cart = (Cart) session.getAttribute("cart");
		cart.emptyCart();
		
		logger.info("购物车已经被清空");
	}

}
