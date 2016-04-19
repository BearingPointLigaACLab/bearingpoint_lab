package com.bearingpoint.onlinebanking;

import java.util.*;

public class Individual implements LegalEntity
{
	private String ID;
	private String nume;
	private Cluster cluster;
	private String adresa;
	private List<Account> accounts;
	private List<Transaction> transactions;
	public String getId() 
	{
		return this.ID;
	}
	public void setId(String id) 
	{
		this.ID = id;
	}
	public String getName() 
	{
		return this.nume;
	}

	public void setName(String name) 
	{
		this.nume = name;
	}
	public Cluster getCluster() 
	{
		return this.cluster;
	}
	public void setCluster(Cluster cluster)
	{
		this.cluster = cluster;
	}
	public String getAddress()
	{
		return this.adresa;
	}
	public void setAddress(String address) 
	{
		this.adresa = address;	
	}
	public List<Account> getAccounts() 
	{
		return accounts;
	}
	public void setAccounts(List<Account> account)
	{
		this.accounts = account;
	}
	public List<Transaction> getTransactions()
	{
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) 
	{
		this.transactions = transactions;	
	}
	public String getFormattedString()
	{
		String s = "<" + this.getClass().getSimpleName() + ">";
		s += "[" + "<" + this.ID + ">" + ":" + "<" + this.nume + ">]";
		return s;
	}
	public String toString()
	{
		int i;
		String s = "";
		s += "ID: " + this.ID + "\nNume: " + this.nume;
		s += "\nAdresa: " + this.adresa + "\nCluster: " + cluster.getName();
		String accounts = "Accounts list: [";
		String transactions = "Transactions list: [";
		if(this.accounts != null)
		{
			for(i = 0 ; i < this.accounts.size() ; i++)
			{
				accounts += this.accounts.get(i).getId();
				if(i + 1  != this.accounts.size())
					accounts += ",";
			}
		}
		accounts += "]";
		if(this.transactions != null)
		{
			for(i = 0 ; i < this.transactions.size() ; i++)
			{
				transactions += this.transactions.get(i).getId();
				if(i + 1  != this.transactions.size())
					transactions += ",";
			}
		}
		transactions += "]";
		return s + "\n" + accounts + "\n" + transactions;
	}
}
