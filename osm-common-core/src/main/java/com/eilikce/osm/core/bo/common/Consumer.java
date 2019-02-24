package com.eilikce.osm.core.bo.common;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eilikce.osm.core.bo.CommonBo;
import com.eilikce.osm.core.bo.transformable.Commodity;
import com.eilikce.osm.core.bo.transformable.ConsumerInfo;
import com.eilikce.osm.core.bo.transformable.RecordOrder;

/**
 * 顾客
 * @author wanghw
 *
 */
public class Consumer implements CommonBo, Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

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

	public Consumer(String cosumerId) {
		
		LOG.info("临时用户创建成功！");
		createCart();//创建购物车
	}

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
		LOG.info("用户:"+ info.getName() +"创建成功！");
		createCart();//创建购物车
	}

	/**
	 * 创建一个购物车
	 * @return
	 */
	private Cart createCart() {
		cart = new Cart(this);
		LOG.info("用户:"+ info.getName() +",创建了一个购物车");
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
		
		LOG.info("用户:"+ info.getName() +",创建了一个订单");
		return record;
	}

	/**
	 * 提交订单
	 * @return
	 */
	public void submitRecordOrder() {
		//TODO 提交订单
		
		LOG.info("用户:"+ info.getName() +",提交了一个订单");
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

	@Override
	public String toString() {
		return "ConsumerPo [info=" + info + ", cart=" + cart + ", record=" + record + "]";
	}

}
