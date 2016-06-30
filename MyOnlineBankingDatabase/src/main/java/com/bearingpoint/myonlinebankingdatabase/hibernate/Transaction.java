/**
 * 
 */
package com.bearingpoint.myonlinebankingdatabase.hibernate;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author cristian.gaidos
 *
 */
@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@Column(name="id")
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	private Integer id;
	
	@Column(name="srcaccid")
	private String sourceAccountID;
	
	@Column(name="destaccid")
	private String destAccountID;
	
	@Column(name="duedate")
	private Date dueDate;
	
	@Column(name="amount")
	private Double amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourceAccountID() {
		return sourceAccountID;
	}

	public void setSourceAccountID(String sourceAccountID) {
		this.sourceAccountID = sourceAccountID;
	}

	public String getDestAccountID() {
		return destAccountID;
	}

	public void setDestAccountID(String destAccountID) {
		this.destAccountID = destAccountID;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", sourceAccountID=" + sourceAccountID + ", destAccountID=" + destAccountID
				+ ", dueDate=" + dueDate + ", amount=" + amount + "]";
	}
	
	
}
