package com.trailshop.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.trailshop.entities.CartOrder;
import com.trailshop.persistance.PersistenceManager;
import com.trailshop.service.OrderService;
import com.trailshop.util.HibernateUtil;

public class OrderServiceImpl implements OrderService {

	public CartOrder createOrder(CartOrder order) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(order);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return order;
	}

	


	public CartOrder getOrder(long orderId) {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		CartOrder order = null;
		try {
			tx.begin();
			order = em.find(CartOrder.class, orderId);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return order;
	}

	
	
	public CartOrder updateOrder(CartOrder order) throws Exception {
		EntityManager em = PersistenceManager.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			order = em.merge(order);
			em.flush();
			tx.commit();
		} catch (PersistenceException pe) {
			tx.rollback();
			throw pe;
		} finally {
			em.close();
		}

		return order;
	}
	
	

}
