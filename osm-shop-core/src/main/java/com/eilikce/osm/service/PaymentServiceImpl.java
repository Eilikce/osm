package com.eilikce.osm.service;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eilikce.osm.bo.consumer.RecordOrderBo;
import com.eilikce.osm.bo.consumer.Cart;
import com.eilikce.osm.bo.consumer.ConsumerBo;

@Service
public class PaymentServiceImpl implements PaymentService{

	private static Logger logger = Logger.getLogger(IndexServiceImpl.class);
	
	@Autowired
	RecordOrderService recordOrderService;
	
	@Override
	public boolean onlinePayment(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		ConsumerBo consumerBo = (ConsumerBo) session.getAttribute("consumerBo");
		
		// 创建新订单
		RecordOrderBo recordOrderBo = recordOrderService.recordOrderBoCreate(cart, consumerBo);
		// 订单入库
		recordOrderService.addRecordOrderBo(recordOrderBo);
		logger.debug("订单号："+recordOrderBo.getOrderId()+"，信息入库成功");
		
		boolean paymentFlag = false;
		//TODO 支付流程操作。
		
		
		
		//TODO 支付失败，处理失败

		//TODO 支付成功，记录订单。
		paymentFlag = true;
		if(paymentFlag){
			recordOrderService.updatePaymentStatus(recordOrderBo, true);
			logger.debug("订单号："+recordOrderBo.getOrderId()+" 支付状态更新为已支付");
			logger.info("订单支付成功，用户："+consumerBo.getName()+"，订单号："+recordOrderBo.getOrderId()+"，支付金额："+recordOrderBo.getTotalPrice()+"元。");
		}
		
		return false;
	}

	@Override
	public boolean cashOnDelivery(HttpSession session) {
		// TODO Auto-generated method stub
		return false;
	}

}
