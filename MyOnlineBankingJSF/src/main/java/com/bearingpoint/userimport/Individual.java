package com.bearingpoint.userimport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * An individual user of MyOnlineBanking.
 * 
 * @author corian.paun
 *
 */
public class Individual implements LegalEntity {
	private String ID;
	private String name;
	private String address;
	private List<Account> accounts = new ArrayList<Account>();
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public String getId() {
		return this.ID;
	}

	public void setId(String id) {
		this.ID = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> account) {
		this.accounts = account;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String toString() {
		return this.getClass().getSimpleName() + "[id[" + this.ID + "],name[" + this.name + "]," + "address[" + this.address + "]" + "accounts"
				+ this.accounts + ",transactions" + this.transactions + "]";
	}

	public static void main(String[] args) {
		LegalEntity e1 = new Individual();
		e1.setName("e1");
		e1.setId("id_e1");
		e1.setAddress("addr_e1");
		// Accounts for e1
		List<Account> accounts = e1.getAccounts();
		Account a = new Account();
		a.setId("id_a_e1");
		a.setCurrency("curr_a_e1");
		a.setAmount(200);
		accounts.add(a);
		// Transactions for e1
		List<Transaction> transactions = e1.getTransactions();
		Transaction t = new Transaction();
		t.setAmount(100);
		t.setDate(new Date());
		t.setDestination("dest_t_e1");
		t.setId("id_t_e1");
		t.setSource("src_t_e1");
		transactions.add(t);

		System.out.println(e1);
	}
}
