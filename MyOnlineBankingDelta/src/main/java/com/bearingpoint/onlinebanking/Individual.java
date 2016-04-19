package com.bearingpoint.onlinebanking;


import java.util.List;

public class Individual implements LegalEntity{

	private String id;
	private String name;
	private Cluster cluster;
	private String address;
	private List<Account> accounts;
	private List<Transaction> transactions;
	
	public Individual(String id, String name, Cluster cluster, String address, List<Account> accounts,
			List<Transaction> transactions) {
		this.id = id;
		this.name = name;
		this.cluster = cluster;
		this.address = address;
		this.accounts = accounts;
		this.transactions = transactions;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Cluster getCluster() {
		return cluster;
	}

	@Override
	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public List<Account> getAccounts() {
		return accounts;
	}

	@Override
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public List<Transaction> getTransactions() {
		return transactions;
	}

	@Override
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	

	@Override
	public String getFormattedString() {
		StringBuilder formattedString = new StringBuilder();
		formattedString.append("\n\t\tIndividual [ID - " + id + "; Name - " + name + "; Cluster - " + 
							cluster.getName() + "; Adress - " + address + "] Accounts: ");
		
		for (Account account : accounts) {
			formattedString.append("\n\t\t\t" + account.getFormattedString());
		}
		
		formattedString.append("\n\t\t\tTransactions: ");
		
		for (Transaction transaction : transactions) {
			formattedString.append("\n\t\t\t\t" + transaction.getFormattedString());
		}
		
		return formattedString.toString();
	}

}
