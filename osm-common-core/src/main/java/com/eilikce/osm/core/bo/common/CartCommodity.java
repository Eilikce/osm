package com.eilikce.osm.core.bo.common;

import com.eilikce.osm.core.bo.CommonBo;
import com.eilikce.osm.core.bo.transformable.Commodity;
import com.eilikce.osm.redis.entity.RedisStorable;

public class CartCommodity implements CommonBo, RedisStorable {
	
	private static final long serialVersionUID = 1L;
	
	private Commodity commodity;
	private int count;

	public CartCommodity(Commodity commodity) {
		super();
		this.commodity = commodity;
		this.count = 1;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CartCommodity [commodity=" + commodity + ", count=" + count + "]";
	}

	/**
	 * 增加一个货品
	 */
	public void addCommodity(){
		count++;
	}

	/**
	 * 减少一个货品
	 * 数量大于0时候才减少
	 */
	public void dropCommodity(){
		if(count>0){
			count--;
		}
	}
	
}
