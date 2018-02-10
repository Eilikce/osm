package com.eilikce.osm.admin.bo.admin.handler;

import com.eilikce.osm.admin.bo.UniqueIdCreater;
import com.eilikce.osm.admin.bo.consumer.ConsumerBo;

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
