package com.eilikce.osm.core.bo.common;

import java.io.Serializable;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eilikce.osm.core.bo.CommonBo;
import com.eilikce.osm.core.bo.transformable.Commodity;

public class Cart implements CommonBo, Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(Cart.class);

	//不可修改变量，购物人
	private final Consumer consumer;
	//可修改购物车内物品
	private HashMap<String,CartCommodity> cartHashMap ;
	//购物车总价
	private float totalPrice;
	
	public Cart(Consumer consumer) {
		super();
		this.consumer = consumer;
		this.cartHashMap = new HashMap<String,CartCommodity>();
		this.totalPrice = 0;
	}

	public HashMap<String, CartCommodity> getCartHashMap() {
		return cartHashMap;
	}

	public void setCartHashMap(HashMap<String, CartCommodity> cartHashMap) {
		this.cartHashMap = cartHashMap;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [consumer=" + consumer + ", cartHashMap=" + cartHashMap + ", totalPrice=" + totalPrice + "]";
	}

	/**
	 * 一个新货物，放入购物车
	 *
	 * @param commodity
	 */
	public int addCommodity(Commodity commodity){//TODO 考虑并发锁？
		
		int count = 0 ;
		String commodityId = commodity.getCommodityId();
		//如果购物车内包含此种物品，则取出货物模型，修改count数量加1
		if(cartHashMap.containsKey(commodityId)){
			CartCommodity cartCommodity = cartHashMap.get(commodityId);
			cartCommodity.addCommodity();
			count = cartCommodity.getCount(); 
		}else{//如果购物车不包含此种物品，新增物品并且放入1个
			CartCommodity cartCommodity = new CartCommodity(commodity);
			cartHashMap.put(commodityId, cartCommodity);
			count = cartCommodity.getCount(); 
		}
		
		//修改总价
		modifyTotalPrice();
				
		return count;
	}
	
	/**
	 * 从购物车中，减少一个货物
	 * @param commodityShow
	 */
	public int dropCommodity(CommodityShow commodityShow){//TODO 考虑并发锁？
		
		int count = 0 ;
		String commodityId = commodityShow.getCommodityId();
		//TODO 有问题，用户将物品数改为0是否等同于删除物品？？
		//如果购物车内包含此种物品，则取出货物模型，修改count数量减少1
		//数量大于0时候才减少，如果减少到0，则不再减少
		if(cartHashMap.containsKey(commodityId)){
			CartCommodity cartCommodity = cartHashMap.get(commodityId);
			count = cartCommodity.getCount();
			if(count>0){
				cartCommodity.dropCommodity();
				count = cartCommodity.getCount();
			}
		}else{//如果购物车不包含此种物品，删除操作不应被执行。异步错误
			LOG.error("错误：购物车对已经清空物品做出了删除操作");
		}
		
		//修改总价
		modifyTotalPrice();
		
		return count;
	}
	
	/**
	 * 从购物车删除某种货品
	 * @param commodityShow
	 */
	public void deleteCommodity(CommodityShow commodityShow){
		String commodityId = commodityShow.getCommodityId();
		cartHashMap.remove(commodityId);
		
		//修改总价
		modifyTotalPrice();
				
	}
	
	/**
	 * 清空购物车
	 */
	public void emptyCart(){
		cartHashMap.clear();
		//修改总价
		modifyTotalPrice();
		LOG.info("清空了购物车");
	}
	
	/**
	 * 修改总价
	 */
	private void modifyTotalPrice(){
		float totalPrice = 0 ;
		for(CartCommodity cc : cartHashMap.values()){
			float price = cc.getCommodity().getPrice();
			float count = cc.getCount();
			totalPrice += price * count;
		}
		totalPrice = (float)(Math.round(totalPrice*100))/100;
		this.totalPrice = totalPrice;
	}
	
}
