package com.eilikce.osm.core.handler;

import com.eilikce.osm.core.bo.ConsumerBo;
import com.eilikce.osm.util.UniqueIdCreater;

public class RecordOrderCommodityBoHandler {
	
	/**
	 * 通过用户信息，订单号，商品id作为关键信息生成唯一订单号
	 * @param consumerBo	用户信息
	 * @param orderId	订单号
	 * @param commodityId	商品id
	 * @return
	 */
	public static String orderCommodityIdCreater(ConsumerBo consumerBo,String orderId,String commodityId){
		String unique_msg =consumerBo.getName()+consumerBo.getPhone()+consumerBo.getAddr()+consumerBo.getConsumerId()+orderId+commodityId;
		unique_msg += System.currentTimeMillis();
		String orderCommodityId = UniqueIdCreater.uniqueIdCreater(unique_msg);
		return orderCommodityId;
	}
}
