package com.trailshop.actions;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.trailshop.entities.CartOrder;
import com.trailshop.entities.OrderItem;
import com.trailshop.entities.Product;
import com.trailshop.service.OrderItemService;
import com.trailshop.service.OrderService;
import com.trailshop.service.ProductService;
import com.trailshop.service.impl.OrderItemServiceImpl;
import com.trailshop.service.impl.OrderServiceImpl;
import com.trailshop.service.impl.ProductServiceImpl;
import com.trailshop.util.HibernateUtil;

public class ProductAddCartAction extends ActionSupport {
	private static final long serialVersionUID = 1L;


	private String userId;
	
	private String cartTotal;
	
	
	private String cartQuantity;

	
	private String orderId;
	
	
//	private JSONObject cartList;

	
	
	
	

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(String cartTotal) {
		
		this.cartTotal = cartTotal;
	}

	public String getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(String cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	

	public String execute() throws Exception {
		
			String rtn = SUCCESS;
	        HttpServletRequest request = ServletActionContext.getRequest(); 
			String productId = request.getParameter("productId");
			System.out.println(getClass().getName() + "::execute() -- Adding Product [" + productId + "] to cart");

			Product retreiveProduct;
			ProductService productService = new ProductServiceImpl();
			retreiveProduct = productService.getProduct(productId);
			
			
			
			CartOrder order = new CartOrder();
			
			order.setCustomeruniqueId(request.getSession().getId());
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			   System.out.println(dateFormat.format(date));
			order.setOrderDate(new Date());
			order.setOrderStatus("1");
			order.setTotalCost(new Float(0));
			
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setProduct(retreiveProduct);
			orderItem.setQuantity(new Long(1l));
			
			List<OrderItem> orderItems = new ArrayList<OrderItem>();
			orderItems.add(orderItem);
			order.setOrderItems(orderItems);
			
			OrderService orderService = new OrderServiceImpl();
			CartOrder createdOrder = orderService.createOrder(order);
			
			OrderItemService orderItemAddService = new OrderItemServiceImpl();
			OrderItem createdItem = orderItemAddService.createOrderItem(orderItem);
			
			setUserId(createdOrder.getCustomeruniqueId());
			setCartQuantity(String.valueOf(createdOrder.getOrderItems().size()));
			setCartTotal(countCartTotal(createdOrder));
			setOrderId("1010");
			return SUCCESS;
	}
	
	
	public String countCartTotal(CartOrder order){
		
		int cartTotal = 0;
		
		OrderItemService orderItemService = new OrderItemServiceImpl();
		List<OrderItem> orderItems = (List<OrderItem>) orderItemService.getOrderItems(order);
		for(OrderItem orderItem: orderItems){
			cartTotal += orderItem.getProduct().getUnitPrice().intValue() ;
			
		}
		return String.valueOf(cartTotal);
		
	}
	
	
/*	
public CartOrder createOrderForUser(String id){
		
		int cartTotal = 0;
		
		OrderService orderService = new OrderServiceImpl();
		CartOrder createdOrder = orderService.getOrder();
		
		
		OrderItemService orderItemService = new OrderItemServiceImpl();
		List<OrderItem> orderItems = (List<OrderItem>) orderItemService.getOrderItems(order);
		for(OrderItem orderItem: orderItems){
			cartTotal += orderItem.getProduct().getUnitPrice().intValue() ;
			
		}
		return String.valueOf(cartTotal);
		
	}
	
	*/
	
	

		
	
}
