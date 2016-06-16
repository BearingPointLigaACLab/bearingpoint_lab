package com.bearingpoint.userimport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A group of legal entities which use MyOnlineBanking, defined by a name and an id.
 * 
 * @author corian.paun
 *
 */
public class Cluster implements Named, UniquelyIdentifiable {
	private String name;
	private String ID;
	private List<LegalEntity> legalEntities = new ArrayList<LegalEntity>();

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

	public void setLegalEntities(List<LegalEntity> legalEntities) {
		this.legalEntities = legalEntities;
	}

	public List<LegalEntity> getLegalEntities() {
		return this.legalEntities;
	}

	public String toString() {
		return this.getClass().getSimpleName() + "[id[" + this.ID + "],name[" + this.name + "],legalEntities" + legalEntities + "]";
	}

	public static void main(String[] args) {
		Cluster c = new Cluster();
		c.setId("id_c");
		c.setName("c");

		// Individual e1
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

		// Individual e2
		LegalEntity e2 = new Individual();
		e2.setName("e2");
		e2.setId("id_e2");
		e2.setAddress("addr_e2");
		// Accounts for e2
		accounts = e2.getAccounts();
		a = new Account();
		a.setId("id_a_e2");
		a.setCurrency("curr_a_e2");
		a.setAmount(300);
		accounts.add(a);
		// Transactions for e2
		transactions = e2.getTransactions();
		t = new Transaction();
		t.setAmount(400);
		t.setDate(new Date());
		t.setDestination("dest_t_e2");
		t.setId("id_t_e2");
		t.setSource("src_t_e2");
		transactions.add(t);
		e2.setTransactions(transactions);

		List<LegalEntity> legalEntities = c.getLegalEntities();
		legalEntities.add(e1);
		legalEntities.add(e2);

		System.out.println(c);
	}
}
