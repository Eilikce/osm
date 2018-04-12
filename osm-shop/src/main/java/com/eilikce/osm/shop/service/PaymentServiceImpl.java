package com.eilikce.osm.shop.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	OrderService recordOrderService;
	
	@Override
	public boolean onlinePayment(HttpSession session) {
		
		
		boolean paymentFlag = false;
		//TODO 支付流程操作。
		
		
		//TODO 支付失败，处理失败

		//TODO 支付成功，记录订单。
		paymentFlag = true;
		if(paymentFlag){

		}
		
		return false;
	}

	@Override
	public boolean cashOnDelivery(HttpSession session) {
		// TODO Auto-generated method stub
		return false;
	}

}
