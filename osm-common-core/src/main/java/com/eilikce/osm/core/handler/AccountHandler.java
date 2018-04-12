package com.eilikce.osm.core.handler;

import java.sql.Timestamp;

import com.eilikce.osm.core.bo.transformable.Account;
import com.eilikce.osm.core.bo.transformable.RecordOrderCommodity;
import com.eilikce.osm.util.MathUtil;

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
		
		String accountId = OsmIdHandler.accountIdCreater(orderId, orderCommodityId);
		Float accountOriginal = MathUtil.multiplcativeRound2(original, salesVolume);
		Float accountPrice = MathUtil.multiplcativeRound2(price, salesVolume);
		Float accountProfit = MathUtil.multiplcativeRound2(profit, salesVolume);
		String accountDetail = "";
		
		Account account = new Account(id, accountId, orderId, orderCommodityId, commodityId, commodityName, barcode, unit, original, price, profit, salesVolume, accountOriginal, accountPrice, accountProfit, accountDetail, accountDate);
		
		return account;
	}
	
}
