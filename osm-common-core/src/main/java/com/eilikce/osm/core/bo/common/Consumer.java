package com.eilikce.osm.core.bo.common;

import org.apache.log4j.Logger;

import com.eilikce.osm.core.bo.CommonBo;
import com.eilikce.osm.core.bo.transformable.Commodity;
import com.eilikce.osm.core.bo.transformable.ConsumerInfo;
import com.eilikce.osm.core.bo.transformable.RecordOrder;
import com.eilikce.osm.redis.entity.RedisStorable;

/**
 * 顾客
 * @author wanghw
 *
 */
public class Consumer implements CommonBo, RedisStorable {

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(Consumer.class);

	/**
	 * 用户信息
	 */
	private ConsumerInfo info;
	
	/**
	 * 购物车
	 */
	private Cart cart;
	
	/**
	 * 订单
	 */
	private RecordOrder record;

	
	/**
	 * @param addr
	 * @param name
	 * @param phone
	 */
	public Consumer(String addr, String name, String phone) {
		this(new ConsumerInfo(addr, name, phone));
	}
	
	public Consumer(ConsumerInfo info) {
		this.info = info;
		logger.info("用户:"+ info.getName() +"创建成功！");
		createCart();//创建购物车
	}

	/**
	 * 创建一个购物车
	 * @return
	 */
	private Cart createCart() {
		cart = new Cart(this);
		logger.info("用户:"+ info.getName() +",创建了一个购物车");
		return cart;
	}

	/**
	 * 添加一个商品
	 * @param commodity
	 */
	public void addCommodity(Commodity commodity) {
		// TODO
	}

	/**
	 * 减少一个商品
	 * @param commodity
	 */
	public void catCommodity(Commodity commodity) {
		// TODO
	}

	/**
	 * 删除一种商品
	 * @param commodity
	 */
	public void removeCommodity(Commodity commodity) {
		// TODO
	}
	
	
	/**
	 * 创建订单
	 * @return
	 */
	public RecordOrder createRecordOrder() {
		record = new RecordOrder(info);
		
		logger.info("用户:"+ info.getName() +",创建了一个订单");
		return record;
	}

	/**
	 * 提交订单
	 * @return
	 */
	public void submitRecordOrder() {
		//TODO 提交订单
		
		logger.info("用户:"+ info.getName() +",提交了一个订单");
	}
	
	
	/**
	 * 付款
	 * @return
	 */
	public boolean pay() {

		return false;
	}
	
	public ConsumerInfo getInfo() {
		return info;
	}

	public void setInfo(ConsumerInfo info) {
		this.info = info;
	}

	public Cart getCart() {
		return cart;
	}

}
