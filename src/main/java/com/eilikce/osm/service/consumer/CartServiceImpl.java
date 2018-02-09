package com.eilikce.osm.service.consumer;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.bo.consumer.Cart;
import com.eilikce.osm.bo.consumer.CommodityShow;
import com.eilikce.osm.dao.CommodityDao;
import com.eilikce.osm.entity.consumer.CommodityFurther;

@Service
public class CartServiceImpl implements CartService{
	
	private static Logger logger = Logger.getLogger(CartServiceImpl.class);
	
	@Autowired
	private CommodityDao commodityDao;

	@Override
	public int addCommodity(String commodityId , HttpSession session) {
		
		CommodityFurther commodityFurther =commodityDao.selectCommodityFurtherById(commodityId);
		CommodityShow commodityShow = new CommodityShow(commodityFurther);
		Cart cart = (Cart)session.getAttribute("cart");
		int count = cart.addCommodity(commodityShow);
		
		logger.debug("购物车货品列表："+cart.getCartHashMap().toString());
		logger.info("购物车新增货品："+commodityShow.getCommodityDetail());
		
		return count;
	}

	@Override
	public int dropCommodity(String commodityId, HttpSession session) {
		
		CommodityFurther commodityFurther = commodityDao.selectCommodityFurtherById(commodityId);
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
