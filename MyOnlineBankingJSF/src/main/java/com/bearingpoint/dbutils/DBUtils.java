package com.bearingpoint.dbutils;

import com.bearingpoint.gui.AdminPage.User;
import com.bearingpoint.gui.HomePage.Account;
import com.bearingpoint.userimport.Cluster;
import com.bearingpoint.userimport.Transaction;

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
	public static void addDBTransaction(Transaction t) {
		// TODO
	}

	/**
	 * Gets all users from the DB
	 * 
	 * @return
	 */
	public static User[] getDBUsers() {
		User[] users = {new User("id_u1", "u1", "id_c1", "c1"), new User("id_u2", "u2", "id_c2", "c2")};
		return users;
	}

	/**
	 * Gets all accounts for the specified user from the DB
	 * 
	 * @return
	 */
	public static Account[] getDBAccounts(String user) {
		Account[] accounts = {new Account("id_a1", "1000", "RON"), new Account("id_a2", "2000", "EUR")};
		return accounts;
	}

	/**
	 * Returns true if user is valid.
	 * 
	 * @return
	 */
	public static boolean isValidUser(String user, String password) {
		boolean isValid = false;
		if (user.equals("admin") && password.equals("admin") || user.equals("user") && password.equals("user")) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * Returns true if user is an administrator.
	 * 
	 * @return
	 */
	public static boolean isAdminUser(String user, String password) {
		boolean isAdminUser = false;
		if (user.equals("admin")) {
			isAdminUser = true;
		}
		return isAdminUser;
	}
}