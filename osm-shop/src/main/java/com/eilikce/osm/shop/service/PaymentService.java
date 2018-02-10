package com.eilikce.osm.shop.service;

import javax.servlet.http.HttpSession;

public interface PaymentService {
	
	/**
	 * 在线支付
	 * @param session
	 * @return
	 */
	public boolean onlinePayment(HttpSession session);
	
	/**
	 * 现金支付
	 * @param session
	 * @return
	 */
	public boolean cashOnDelivery(HttpSession session);
	
}
