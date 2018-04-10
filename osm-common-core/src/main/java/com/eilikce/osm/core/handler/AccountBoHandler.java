package com.eilikce.osm.core.handler;

import java.sql.Timestamp;

import com.eilikce.osm.core.bo.transformable.Account;
import com.eilikce.osm.core.bo.transformable.RecordOrderCommodity;
import com.eilikce.osm.util.MathUtil;
import com.eilikce.osm.util.UniqueIdCreater;

public class AccountBoHandler {
	
	public static Account accountBoCreater(RecordOrderCommodity recordOrderCommodityBo){
		Integer id = null;
		String orderId = recordOrderCommodityBo.getOrderId();
		String orderCommodityId = recordOrderCommodityBo.getOrderCommodityId();
		String commodityId = recordOrderCommodityBo.getCommodityId();
		String commodityName = recordOrderCommodityBo.getCommodityName();
		Integer barcode = recordOrderCommodityBo.getBarcode();
		String unit = recordOrderCommodityBo.getUnit();
		Float original = recordOrderCommodityBo.getOriginal();
		Float price = recordOrderCommodityBo.getPrice();
		Float profit = recordOrderCommodityBo.getProfit();
		Integer salesVolume = recordOrderCommodityBo.getSalesVolume();
		Timestamp accountDate = null;
		
		String accountId = accountIdCreater(orderId, orderCommodityId);
		Float accountOriginal = MathUtil.multiplcativeRound2(original, salesVolume);
		Float accountPrice = MathUtil.multiplcativeRound2(price, salesVolume);
		Float accountProfit = MathUtil.multiplcativeRound2(profit, salesVolume);
		String accountDetail = "";
		
		Account accountBo = new Account(id, accountId, orderId, orderCommodityId, commodityId, commodityName, barcode, unit, original, price, profit, salesVolume, accountOriginal, accountPrice, accountProfit, accountDetail, accountDate);
		
		return accountBo;
	}
	
	/**
	 * 生成账单id，根据账单模型对象accountBo
	 * @param accountBo
	 * @return
	 */
	public static String accountIdCreater(Account accountBo){
		String unique_msg = accountBo.getOrderId()+accountBo.getOrderCommodityId();
		unique_msg += System.currentTimeMillis();
		String accountId = UniqueIdCreater.uniqueIdCreater(unique_msg);
		return accountId;
	}
	
	/**
	 * 生成账单id，根据账单的订单号和订单商品号
	 * @param accountBo
	 * @return
	 */
	public static String accountIdCreater(String orderId, String orderCommodityId){
		String unique_msg = orderId+orderCommodityId;
		unique_msg += System.currentTimeMillis();
		String accountId = UniqueIdCreater.uniqueIdCreater(unique_msg);
		return accountId;
	}
	
}
