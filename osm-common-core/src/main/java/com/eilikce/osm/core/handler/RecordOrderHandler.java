package com.eilikce.osm.core.handler;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.eilikce.osm.core.bo.common.Cart;
import com.eilikce.osm.core.bo.common.CartCommodity;
import com.eilikce.osm.core.bo.common.CommodityShow;
import com.eilikce.osm.core.bo.transformable.Commodity;
import com.eilikce.osm.core.bo.transformable.ConsumerInfo;
import com.eilikce.osm.core.bo.transformable.RecordOrder;
import com.eilikce.osm.core.bo.transformable.RecordOrderCommodity;
import com.eilikce.osm.entity.consumer.RecordOrderFurtherPo;
import com.eilikce.osm.util.MathUtil;
import com.eilikce.osm.util.UniqueIdCreater;

public class RecordOrderHandler {

	private static Logger logger = Logger.getLogger(RecordOrderHandler.class);

	/**
	 * 订单生成器
	 * 通过购物车和顾客，生成订单
	 * @param cart		购物车
	 * @param consumerInfo	顾客
	 * @return
	 */
	public static RecordOrder recordOrderCreater(Cart cart,ConsumerInfo consumerInfo){
		RecordOrder recordOrder = new RecordOrder(consumerInfo);
		Float totalCost = 0F;
		Float totalPrice = 0F;
		Float totalProfit = 0F;;
		String orderId = recordOrder.getOrderId();
		HashMap<String, CartCommodity> commodityMap = cart.getCartHashMap();
		List<RecordOrderCommodity> recordOrderCommodityList = new ArrayList<RecordOrderCommodity>();
		for(CartCommodity cc : commodityMap.values()){
			
			Commodity commodity = cc.getCommodity();//商品模型
			CommodityShow commodityShow = new CommodityShow(commodity);//商品展示模型
			
			RecordOrderCommodity recordOrderCommodity = new RecordOrderCommodity(commodityShow, orderId, consumerInfo);
			recordOrderCommodityList.add(recordOrderCommodity);
			
			totalCost += recordOrderCommodity.getTotalOriginal();
			totalPrice += recordOrderCommodity.getTotalPrice();
			totalProfit += recordOrderCommodity.getTotalProfit();
		}
		
		//对计算合计数值保留两位小数
		totalCost = MathUtil.floatRound2(totalCost);
		totalPrice = MathUtil.floatRound2(totalPrice);
		totalProfit = MathUtil.floatRound2(totalProfit);
		
		Timestamp orderDate = null;	//生成订单默认不传时间
		Integer paymentStatus = 0;			//默认订单支付状态 未支付 0
		Integer orderInvalid = 1;			//默认订单正常
		String orderCancelDetail = "";
		
		recordOrder.fillRecordOrder(totalCost, totalPrice, totalProfit, paymentStatus ,orderInvalid, orderCancelDetail, orderDate, recordOrderCommodityList);
		
		logger.info("顾客："+ recordOrder.getConsumerName() +" 提交了一笔订单，订单号：" + recordOrder.getOrderId());
		
		return recordOrder;
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
	 * 将RecordOrderFurther的List转换为RecordOrder的List
	 * 
	 * @param recordOrderFurtherList
	 * @return
	 */
	public static List<RecordOrder> recordOrderListTransform(List<RecordOrderFurtherPo> recordOrderFurtherList) {
		if (null == recordOrderFurtherList) {
			logger.error("RecordOrder的List转换失败，recordOrderFurtherList为空");
		}
		List<RecordOrder> recordOrderList = new ArrayList<RecordOrder>();
		for (RecordOrderFurtherPo rof : recordOrderFurtherList) {
			RecordOrder bo = new RecordOrder(rof);
			recordOrderList.add(bo);
		}
		return recordOrderList;
	}
	
}
