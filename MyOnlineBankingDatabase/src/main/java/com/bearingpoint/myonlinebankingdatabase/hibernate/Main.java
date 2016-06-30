package com.bearingpoint.myonlinebankingdatabase.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(LegalEntity.class)
									.buildSessionFactory();

		try {
			// Save example
			Session session = factory.getCurrentSession();
			LegalEntity aLegalEntity = saveExample(session);
			
			// Query example
			session = factory.getCurrentSession();
			queryExample(session, aLegalEntity.getId());
			
			// HQL Query example I
			session = factory.getCurrentSession();
			queryHQLExample(session);
			
			// HQL Query example II
			session = factory.getCurrentSession();
			queryHQLExampleWithWhereClause(session);
			
			// HQL Query example III
			session = factory.getCurrentSession();
//			queryHQLEcxampleWithParameter(session);
			
			// Update example
			session = factory.getCurrentSession();
			updateExample(session);
			
			// Update example II
			session = factory.getCurrentSession();
			updateExample2(session);

		} catch (Exception e) {
		} finally {
			factory.close();
		}

	}
	
	public static LegalEntity saveExample(Session session) {
		// create a legal entity object
		LegalEntity aLegalEntity = new LegalEntity("aLegalEntityID", "HibernateUSR", "str. Exemplu", "1", "1");

		// start the transaction
		session.beginTransaction();

		// save the legal entity object
		session.save(aLegalEntity);

		// commit the transaction
		session.getTransaction().commit();
		
		return aLegalEntity;
	}
	
	public static void queryExample(Session session, String primaryKey) {
		// start the transaction
		session.beginTransaction();

		LegalEntity aLegalEntity = session.get(LegalEntity.class, primaryKey);
		
		System.out.println("Found Legal Entity: " + aLegalEntity.toString());
		
		// commit the transaction
		session.getTransaction().commit();
	}
	
	public static void queryHQLExample(Session session) {
		// start the transaction
		session.beginTransaction();
		
		List<LegalEntity> legalEntityList = session.createQuery("from LegalEntity ").list();
		
		if(legalEntityList != null) {
			for (LegalEntity legalEntity : legalEntityList) {
				System.out.println(legalEntity);
			}
		}
		
		// commit the transaction
		session.getTransaction().commit();
	}
	
	public static void queryHQLExampleWithWhereClause(Session session) {
		// start the transaction
		session.beginTransaction();
		
		List<LegalEntity> legalEntityList = session.createQuery("from LegalEntity e where e.name='GAIDOS CRISTIAN' ").list();
		
		if(legalEntityList != null) {
			for (LegalEntity legalEntity : legalEntityList) {
				System.out.println(legalEntity);
			}
		}
		
		// commit the transaction
		session.getTransaction().commit();
	}
	
	public static void queryHQLExampleWithParameter(Session session) {
		// start the transaction
		session.beginTransaction();
		
		List<LegalEntity> legalEntityList = session.createQuery("from LegalEntity e where e.name= :name and e.address = :anAddress")
															.setString("name", "GAIDOS CRISTIAN")
															.setString("anAddress", "BearingPoint")
															.list();
		
		if(legalEntityList != null) {
			for (LegalEntity legalEntity : legalEntityList) {
				System.out.println(legalEntity);
			}
		}
		
		// commit the transaction
		session.getTransaction().commit();
	}
	
	public static void updateExample(Session session) {
	// start the transaction	
	session.beginTransaction();
	
	// retrieve an entity
	LegalEntity legalEntity = session.get(LegalEntity.class, "LEGAL_ENTITY_01");
	
	// modify the entity
	legalEntity.setAddress("altceva");
		
	// commit the transaction
	session.getTransaction().commit();	
	}
	
	public static void updateExample2(Session session) {
		// start the transaction	
		session.beginTransaction();
		
		//create query
		session.createQuery("update LegalEntity set address='BearingPoint', name = 'Test' ").executeUpdate();
			
		// commit the transaction
		session.getTransaction().commit();	
		}
}
