package com.eilikce.osm.core.handler;

import java.sql.Timestamp;

import com.eilikce.osm.core.bo.transformable.Account;
import com.eilikce.osm.core.bo.transformable.RecordOrderCommodity;
import com.eilikce.osm.util.MathUtil;
import com.eilikce.osm.util.UniqueIdCreater;

public class AccountHandler {
	
	public static Account accountCreater(RecordOrderCommodity recordOrderCommodity){
		Integer id = null;
		String orderId = recordOrderCommodity.getOrderId();
		String orderCommodityId = recordOrderCommodity.getOrderCommodityId();
		String commodityId = recordOrderCommodity.getCommodityId();
		String commodityName = recordOrderCommodity.getCommodityName();
		Integer barcode = recordOrderCommodity.getBarcode();
		String unit = recordOrderCommodity.getUnit();
		Float original = recordOrderCommodity.getOriginal();
		Float price = recordOrderCommodity.getPrice();
		Float profit = recordOrderCommodity.getProfit();
		Integer salesVolume = recordOrderCommodity.getSalesVolume();
		Timestamp accountDate = null;
		
		String accountId = accountIdCreater(orderId, orderCommodityId);
		Float accountOriginal = MathUtil.multiplcativeRound2(original, salesVolume);
		Float accountPrice = MathUtil.multiplcativeRound2(price, salesVolume);
		Float accountProfit = MathUtil.multiplcativeRound2(profit, salesVolume);
		String accountDetail = "";
		
		Account account = new Account(id, accountId, orderId, orderCommodityId, commodityId, commodityName, barcode, unit, original, price, profit, salesVolume, accountOriginal, accountPrice, accountProfit, accountDetail, accountDate);
		
		return account;
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
