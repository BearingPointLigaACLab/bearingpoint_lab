package com.bearingpoint.myonlinebankingdatabase.hibernate;
/**
 * 
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author cristian.gaidos
 *
 */
public class HibernateContext {
	
	private static SessionFactory factory;
	
	static { 
		
		 factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(LegalEntity.class)
				.addAnnotatedClass(AppUser.class)
				.addAnnotatedClass(Account.class)
				.addAnnotatedClass(Transaction.class)
				.buildSessionFactory();
	}
	
	
	public static Session getHibernateSession() {
		return factory.getCurrentSession();
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}
	
	

}
