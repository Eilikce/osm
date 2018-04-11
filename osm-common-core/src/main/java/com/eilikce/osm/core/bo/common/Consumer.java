package com.eilikce.osm.core.bo.common;

import org.apache.log4j.Logger;

import com.eilikce.osm.core.bo.CommonBo;
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
	ConsumerInfo info;

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
	}

	/**
	 * 创建一个购物车
	 * @return
	 */
	public Cart createCart() {
		Cart cart = new Cart(this);
		logger.info("用户:"+ info.getName() +",创建了一个购物车");
		return cart;
	}

	/**
	 * 提交订单
	 * @return
	 */
	public RecordOrder submitRecordOrder() {
		RecordOrder record = new RecordOrder(info);
		
		return record;
	}
	
	public ConsumerInfo getInfo() {
		return info;
	}

	public void setInfo(ConsumerInfo info) {
		this.info = info;
	}

}
