package com.trailshop.service;

import com.trailshop.entities.CartOrder;

public interface OrderService {

	public CartOrder createOrder(CartOrder order) throws Exception;
	
	public CartOrder getOrder(long orderId)  throws Exception;

	//public CartOrder getCustomerOrder(String orderId)  throws Exception;

		public CartOrder updateOrder(CartOrder order) throws Exception;

}
