package com.bearingpoint.onlinebanking.tests;

import static org.junit.Assert.*;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.junit.Test;

import com.bearingpoint.onlinebanking.*;


public class XMLReaderTestCase {
	
	@Test
	public void testXMLLoading(){
		
		
		XMLClusterFactory xmlFactory = new XMLClusterFactory();
		
		Cluster cluster = xmlFactory.read(getClass().getClassLoader().getResource("sample2.xml"));
		assertTrue(cluster.getId().equals("cl_001"));
		assertTrue(cluster.getName().equals("myCluster"));
		assertTrue(cluster.getFormattedString().equals(
				"<myCluster>[Paun Corian, Gaidos Cristian, Mihut Andrei, Panfilii Ion, Stoian Diana]"));
		List<LegalEntity> oameni = cluster.getLegalEntities();
		List<Account> accounts;
		List<Transaction> transactions;
		DateFormat df;
		Date d;
		try 
		{
			@SuppressWarnings("resource")
			BufferedReader bufom = new BufferedReader(new InputStreamReader
								(new FileInputStream("src/main/resources/oameni.txt")));
			@SuppressWarnings("resource")
			BufferedReader bufcont = new BufferedReader(new InputStreamReader
					(new FileInputStream("src/main/resources/accounts.txt")));
			@SuppressWarnings("resource")
			BufferedReader buftran = new BufferedReader(new InputStreamReader
					(new FileInputStream("src/main/resources/transactions.txt")));
			@SuppressWarnings("resource")
			BufferedReader bufform = new BufferedReader(new InputStreamReader
					(new FileInputStream("src/main/resources/formatedString.txt")));
			for(LegalEntity om : oameni)
			{
				assertTrue(om.getFormattedString().equals(bufform.readLine()));
				assertTrue(om.getId().equals(bufom.readLine()));
				assertTrue(om.getName().equals(bufom.readLine()));
				assertTrue(om.getAddress().equals(bufom.readLine()));
				accounts = om.getAccounts();
				transactions = om.getTransactions();
				for(Account account : accounts)
				{
					assertTrue(account.getId().equals(bufcont.readLine()));
					assertTrue(account.getAmount() == Double.parseDouble(bufcont.readLine()));
					assertTrue(account.getCurrency().equals(bufcont.readLine()));
				}
				for(Transaction transaction : transactions)
				{
					assertTrue(transaction.getId().equals(buftran.readLine()));
					assertTrue(transaction.getSource().equals(buftran.readLine()));
					assertTrue(transaction.getDestination().equals(buftran.readLine()));
					df = new SimpleDateFormat("dd/MM/yyyy");
					d = df.parse(buftran.readLine());
					assertTrue(transaction.getDate().equals(d));
					assertTrue(transaction.getAmount() == Double.parseDouble(buftran.readLine()));
				}
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(ParseException e)
		{
			System.out.println(e);
		}	
	}
}
