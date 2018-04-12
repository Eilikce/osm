package com.eilikce.osm.core.handler;

import com.eilikce.osm.core.bo.transformable.Account;
import com.eilikce.osm.core.bo.transformable.ConsumerInfo;
import com.eilikce.osm.util.UniqueIdCreater;

/**
 * Id生成器
 * 
 * @author wanghw
 *
 */
public class OsmIdHandler {

	
	/**
	 * 顾客Id生成器
	 * 以姓名电话地址
	 * 作为第一唯一性标识
	 * @param name
	 * @param phone
	 * @param addr
	 * @return
	 */
	public static String consumerIdCreater(String name,String phone,String addr){
		String unique_msg = name+phone+addr;
		String consumerId = UniqueIdCreater.uniqueIdCreater(unique_msg);
		return consumerId;
	}
	
	/**
	 * 商品Id 生成器
	 * 变量设置
	 * 13毫秒值后6位
	 * 商品名称前后拼接两位随机数取哈希再取正数
	 * @param commodityName
	 * @return commodityId
	 */
	public static String commodityIdCreater(String commodityName) {
		String commodityId = UniqueIdCreater.uniqueIdCreater(commodityName);
		return commodityId;
	}
	
	/**
	 * 通过用户信息，订单号，商品id作为关键信息生成唯一订单商品id
	 * @param consumerInfo	用户信息
	 * @param orderId	订单号
	 * @param commodityId	商品id
	 * @return
	 */
	public static String orderCommodityIdCreater(ConsumerInfo consumerInfo,String orderId,String commodityId){
		String unique_msg =consumerInfo.getName()+consumerInfo.getPhone()+consumerInfo.getAddr()+consumerInfo.getConsumerId()+orderId+commodityId;
		unique_msg += System.currentTimeMillis();
		String orderCommodityId = UniqueIdCreater.uniqueIdCreater(unique_msg);
		return orderCommodityId;
	}
	
	/**
	 * 由用户信息和毫秒值，组成唯一性信息参数，用以生成唯一订单id
	 * @param consumerName
	 * @param consumerPhone
	 * @param consumerAddr
	 * @param consumerId
	 * @return
	 */
	public static String orderIdCreater(String consumerName,String consumerPhone,String consumerAddr,String consumerId){
		String unique_msg = consumerName+consumerPhone+consumerAddr+consumerId;
		unique_msg += System.currentTimeMillis();
		String orderId = UniqueIdCreater.uniqueIdCreater(unique_msg);
		return orderId;
	}
	
	/**
	 * 由用户信息和毫秒值，组成唯一性信息参数，用以生成唯一订单id
	 * @param consumerInfo	用户对象
	 * @return
	 */
	public static String orderIdCreater(ConsumerInfo consumerInfo){
		String unique_msg =consumerInfo.getName()+consumerInfo.getPhone()+consumerInfo.getAddr()+consumerInfo.getConsumerId();
		unique_msg += System.currentTimeMillis();
		String orderId = UniqueIdCreater.uniqueIdCreater(unique_msg);
		return orderId;
	}
	
	/**
	 * 生成账单id，根据账单模型对象account
	 * @param account
	 * @return
	 */
	public static String accountIdCreater(Account account){
		String unique_msg = account.getOrderId()+account.getOrderCommodityId();
		unique_msg += System.currentTimeMillis();
		String accountId = UniqueIdCreater.uniqueIdCreater(unique_msg);
		return accountId;
	}
	
	/**
	 * 生成账单id，根据账单的订单号和订单商品号
	 * @param account
	 * @return
	 */
	public static String accountIdCreater(String orderId, String orderCommodityId){
		String unique_msg = orderId+orderCommodityId;
		unique_msg += System.currentTimeMillis();
		String accountId = UniqueIdCreater.uniqueIdCreater(unique_msg);
		return accountId;
	}
}
