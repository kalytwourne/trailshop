package com.trailshop.service;

import java.util.Collection;
import java.util.List;

import com.trailshop.entities.CartOrder;
import com.trailshop.entities.OrderItem;

public interface OrderItemService {

	public OrderItem createOrderItem(OrderItem orderItem) throws Exception;
	
	public OrderItem getOrderItem(long itemID);

	public List<OrderItem> getOrderItems(CartOrder order);

	public OrderItem updateOrderItem(OrderItem orderItem) throws Exception;

	public void deleteOrderItem(OrderItem orderItem) throws Exception;
}
