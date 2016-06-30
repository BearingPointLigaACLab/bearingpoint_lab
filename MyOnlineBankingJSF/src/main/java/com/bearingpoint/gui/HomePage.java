package com.bearingpoint.gui;

import java.util.Calendar;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.bearingpoint.dbutils.DBUtils;
import com.bearingpoint.userimport.XMLClusterFactory;

@ManagedBean(name = "homePage", eager = true)
@ViewScoped
public class HomePage {

	private String accountID;
	private String accountAmount;
	private String accountCurrency;

	private String amount;
	private String destination;
	private String name;

	private Account[] accounts = DBUtils.getDBAccounts(getUser());
	private Transaction[] transactions = DBUtils.getDBTransactions(accountID);

	public String getUser() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		return (String) sessionMap.get("user");
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public Transaction[] getTransactions() {
		return transactions;
	}

	public void setTransactions(Transaction[] transactions) {
		this.transactions = transactions;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(String accountAmount) {
		this.accountAmount = accountAmount;
	}

	public String getAccountCurrency() {
		return accountCurrency;
	}

	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = accountCurrency;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setSourceAccount(ActionEvent event) {
		this.accountID = (String) event.getComponent().getAttributes().get("accountID");
		this.accountAmount = (String) event.getComponent().getAttributes().get("accountAmount");
		this.accountCurrency = (String) event.getComponent().getAttributes().get("accountCurrency");

		transactions = DBUtils.getDBTransactions(accountID);
	}

	public void submitTransaction() {
		Transaction t = new Transaction(null, accountID, destination, XMLClusterFactory.DATE_FORMAT.format(Calendar.getInstance().getTime()), amount);
		DBUtils.addDBTransaction(t);

		// clear
		this.accountID = null;
		this.accountAmount = null;
		this.accountCurrency = null;
		this.destination = null;
		this.name = null;
		this.amount = null;
	}

	public static class Account {
		String id;
		String amount;
		String currency;

		public Account(String id, String amount, String currency) {
			super();
			this.id = id;
			this.amount = amount;
			this.currency = currency;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}
	}

	public static class Transaction {
		String id;
		String source;
		String destination;
		String date;
		String amount;

		public Transaction(String id, String source, String destination, String date, String amount) {
			super();
			this.id = id;
			this.source = source;
			this.destination = destination;
			this.date = date;
			this.amount = amount;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

	}
}
