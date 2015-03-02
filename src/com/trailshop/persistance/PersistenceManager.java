package com.trailshop.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class PersistenceManager {

	private static String PERSISTENCE_NAME = "store";

	private static EntityManagerFactory emFactory;

	public static synchronized EntityManager getEntityManager() {
		if (emFactory == null) {
			try{
			emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		EntityManager em = emFactory.createEntityManager();
		return em;
	}
}
