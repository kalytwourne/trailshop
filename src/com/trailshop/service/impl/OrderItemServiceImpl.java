package com.trailshop.service.impl;

import java.util.Collection;




import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.trailshop.entities.CartOrder;
import com.trailshop.entities.OrderItem;
import com.trailshop.persistance.PersistenceManager;
import com.trailshop.service.OrderItemService;
import com.trailshop.util.HibernateUtil;

public class OrderItemServiceImpl implements OrderItemService {

	public OrderItem createOrderItem(OrderItem orderItem) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(orderItem);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return orderItem;
	}

	

	public void deleteOrderItem(OrderItem orderItem) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(orderItem);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public OrderItem getOrderItem(long itemID) {
		
		OrderItem orderItem = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(itemID);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return orderItem;
	}

	
	public List<OrderItem> getOrderItems(CartOrder order) {
		
		List<OrderItem>  orderItems;
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Query query= session.createQuery("from OrderItem where orderId = :orderId");
			query.setParameter("orderId", order.getOrderId() );
			orderItems = query.list();
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return orderItems;
		
		
	}

	

	public OrderItem updateOrderItem(OrderItem orderItem) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(orderItem);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return orderItem;
	}
}
