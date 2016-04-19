package com.bearingpoint.onlinebanking;
import java.io.File;
import java.util.*;
public class Main 
{
	public static void main(String[] args)
	{
		XMLClusterFactory xml = new XMLClusterFactory();
		File file = new File("src/main/resources/sample.xml");
		Cluster cluster = xml.read(file);
		System.out.println(cluster.getFormattedString());
		System.out.println(cluster);
		System.out.println("--------------------------------------------------------------------------------");
		List<LegalEntity> oameni = cluster.getLegalEntities();
		for(LegalEntity l : oameni)
		{
			List<Account> conturi = l.getAccounts();
			List<Transaction> transactions = l.getTransactions();
			System.out.println(l);
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println(l.getFormattedString());
			System.out.println("--------------------------------------------------------------------------------");
			for(Account c : conturi)
			{
				System.out.println(c);
				System.out.println("--------------------------------------------------------------------------------");
			}
			for(Transaction t : transactions)
			{
				System.out.println(t);
				System.out.println("--------------------------------------------------------------------------------");
			}
		}
		
	}
}
