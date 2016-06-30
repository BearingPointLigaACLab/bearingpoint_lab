package com.bearingpoint.dbutils;

import com.bearingpoint.gui.AdminPage.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.bearingpoint.gui.HomePage;
import com.bearingpoint.myonlinebankingdatabase.hibernate.Account;
import com.bearingpoint.myonlinebankingdatabase.hibernate.AppUser;
import com.bearingpoint.myonlinebankingdatabase.hibernate.HibernateContext;
import com.bearingpoint.myonlinebankingdatabase.hibernate.LegalEntity;
import com.bearingpoint.myonlinebankingdatabase.hibernate.Transaction;
import com.bearingpoint.userimport.Cluster;

//@SuppressWarnings("all")
public class DBUtils {

	/**
	 * Adds all cluster information to the DB
	 * 
	 * @param cluster
	 */
	public static void addDBUsers(Cluster cluster) {
		// TODO
		
	}

	/**
	 * Adds a transaction to the DB
	 * 
	 * @param t
	 */
	public static void addDBTransaction(HomePage.Transaction t) {
		
		Session session = HibernateContext.getHibernateSession();
		session.beginTransaction();
		
		Transaction transaction = new Transaction();
		
		transaction.setSourceAccountID(t.getSource());
		transaction.setDestAccountID(t.getDestination());
		transaction.setDueDate(new Date(new java.util.Date(t.getDate()).getTime()));
		transaction.setAmount(new Double(t.getAmount()));
		session.saveOrUpdate(transaction);
		
		List<Account> sourceAccountList = session.createQuery("from Account e where e.id= :id")
				.setString("id", transaction.getSourceAccountID()).list();
		
		List<Account> destAccountList = session.createQuery("from Account e where e.id= :id")
				.setString("id", transaction.getDestAccountID()).list();
		
		if(sourceAccountList != null && !sourceAccountList.isEmpty() && destAccountList != null && !destAccountList.isEmpty()) {
			Account sourceAccount = sourceAccountList.iterator().next();
			Account destAccount = destAccountList.iterator().next();
			
			sourceAccount.setAmount(sourceAccount.getAmount() - transaction.getAmount());
			destAccount.setAmount(destAccount.getAmount() + transaction.getAmount());
			
			session.update(sourceAccount);
			session.update(destAccount);
		}
		
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * Gets all users from the DB
	 * 
	 * @return
	 */
	public static User[] getDBUsers() {
		User[] users = { new User("id_u1", "u1", "id_c1", "c1"), new User("id_u2", "u2", "id_c2", "c2") };
		return users;
	}

	/**
	 * Gets all accounts for the specified user from the DB
	 * 
	 * @return
	 */
	public static HomePage.Account[] getDBAccounts(String user) {
		
		Session session = HibernateContext.getHibernateSession();
		session.beginTransaction();
		List<Account> accountList = new ArrayList<>();
		
		List<LegalEntity> legalEntities = session
				.createQuery("from LegalEntity e where e.appUserID= :user")
				.setString("user", user).list();
		
		if(legalEntities != null && !legalEntities.isEmpty()) {
			String id = legalEntities.iterator().next().getId();
			
			if(id != null) {
				accountList = session
						.createQuery("from Account e where e.legalEntityID= :id")
						.setString("id", id).list();

			}
			
		}
		List<HomePage.Account> accounts = new ArrayList<>();
		for (Account account : accountList) {
			accounts.add(new HomePage.Account(account.getId(), account.getAmount().toString(), account.getCurrency()));
		}
		
		session.close();
		
		return (HomePage.Account[]) accounts.toArray(new HomePage.Account[accounts.size()]);
	}

	/**
	 * Gets all transactions for the specified account ID from the DB
	 * 
	 * @param accountID
	 * @return
	 */
	public static HomePage.Transaction[] getDBTransactions(String accountID) {
		if (accountID == null) {
			return null;
		}

		Session session = HibernateContext.getHibernateSession();
		session.beginTransaction();
		List<Transaction> transactionList = session
				.createQuery("from Transaction e where e.sourceAccountID= :accountID or e.destAccountID = :accountID")
				.setString("accountID", accountID).list();

		List<HomePage.Transaction> homePageList = new ArrayList<>();

		for (Transaction transaction : transactionList) {
			HomePage.Transaction localTrans = new HomePage.Transaction(transaction.getId().toString(),
					transaction.getSourceAccountID(), transaction.getDestAccountID(),
					transaction.getDueDate().toString(), transaction.getAmount().toString());
			homePageList.add(localTrans);
		}

		session.close();
		return (HomePage.Transaction[]) homePageList.toArray(new HomePage.Transaction[homePageList.size()]);
	}

	/**
	 * Returns true if user is valid.
	 * 
	 * @return
	 */
	public static boolean isValidUser(String user, String password) {
		Session session = HibernateContext.getHibernateSession();
		session.beginTransaction();
		List<AppUser> appUserList = session
				.createQuery("from AppUser e where e.username= :username and e.password = :pass")
				.setString("username", user).setString("pass", password).list();
		session.close();
		return !appUserList.isEmpty();
	}

	/**
	 * Returns true if user is an administrator.
	 * 
	 * @return
	 */
	public static boolean isAdminUser(String user, String password) {
		Session session = HibernateContext.getHibernateSession();
		session.beginTransaction();
		List<AppUser> appUserList = session
				.createQuery("from AppUser e where e.username= :username and e.password = :pass")
				.setString("username", user).setString("pass", password).list();
		session.close();
		return appUserList.iterator().next().isAdmin();
	}
}
