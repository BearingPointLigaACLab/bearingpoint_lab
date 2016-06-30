package com.bearingpoint.myonlinebankingdatabase.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="legalentityid")
	private String legalEntityID;
	
	
	public Account(String id, Double amount, String currency, String legalEntityID) {
		super();
		this.id = id;
		this.amount = amount;
		this.currency = currency;
		this.legalEntityID = legalEntityID;
	}


	public Account() {
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getLegalEntityID() {
		return legalEntityID;
	}


	public void setLegalEntityID(String legalEntityID) {
		this.legalEntityID = legalEntityID;
	}


	@Override
	public String toString() {
		return "Account [id=" + id + ", amount=" + amount + ", currency=" + currency + ", legalEntityID="
				+ legalEntityID + "]";
	}
	
}
