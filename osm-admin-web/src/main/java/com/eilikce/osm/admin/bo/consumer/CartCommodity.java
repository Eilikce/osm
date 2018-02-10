package com.eilikce.osm.admin.bo.consumer;

public class CartCommodity {
	private CommodityShow commodityShow;
	private int count;

	public CartCommodity(CommodityShow commodityShow) {
		super();
		this.commodityShow = commodityShow;
		this.count = 1;
	}

	public CommodityShow getCommodityShow() {
		return commodityShow;
	}

	public void setCommodityShow(CommodityShow commodityShow) {
		this.commodityShow = commodityShow;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CartCommodity [commodityShow=" + commodityShow + ", count=" + count + "]";
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
