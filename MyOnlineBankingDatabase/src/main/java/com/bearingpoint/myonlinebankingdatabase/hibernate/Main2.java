package com.bearingpoint.myonlinebankingdatabase.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main2 {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Account.class)
						.addAnnotatedClass(LegalEntity.class)
						.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
//		
//		session.beginTransaction();
//		
//		Account account = new Account("anID", 1000d, "EUR", "legalID");
//		
//		session.save(account);
//		
//		session.getTransaction().commit();
		
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		Account anotherAccount = session.get(Account.class, "anID");
		
		System.out.println(anotherAccount);

	}

}
