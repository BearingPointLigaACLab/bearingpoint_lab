package com.bearingpoint.onlinebanking;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class XMLClusterFactory extends AbstractClusterFactory{

	
	public Cluster read(Object o) 
	{
		URL url = (URL)o;
		File file = new File(url.getPath());
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		Cluster cluster = new Cluster();
		LegalEntity om;
		Account contulmeu;
		Transaction tranz;
		DateFormat df;
		Date d;
		
		ArrayList<Account> conturi;
		ArrayList<LegalEntity> oameni = new ArrayList<LegalEntity>();
		ArrayList<Transaction> t1;
		ArrayList<Transaction> t = new ArrayList<Transaction>();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			
			cluster.setId(doc.getDocumentElement().getAttribute("id"));
			cluster.setName(doc.getDocumentElement().getAttribute("name"));
			Node legalEntities = doc.getElementsByTagName("legalEntities").item(0);
			Node transactions = doc.getElementsByTagName("transactions").item(0);
			NodeList indivizi = ((Element)legalEntities).getElementsByTagName("individual");
			NodeList tranzactii = ((Element)transactions).getElementsByTagName("transaction");
			for(int i = 0 ; i < tranzactii.getLength() ; i++)
			{
				Node transaction = tranzactii.item(i);
				if(transaction.getNodeType() == Node.ELEMENT_NODE)
				{
					tranz = new Transaction();
					tranz.setId(((Element)transaction).getAttribute("id"));
					tranz.setSource(((Element)transaction).getAttribute("source"));
					tranz.setDestination(((Element)transaction).getAttribute("destination"));
					df = new SimpleDateFormat("dd/MM/yyyy");
					d = df.parse(((Element)transaction).getAttribute("date"));
					tranz.setDate(d);
					tranz.setAmount(Double.parseDouble(((Element)transaction).getAttribute("amount")));
					t.add(tranz);
				}
			}
			for(int i = 0 ; i < indivizi.getLength() ; i++)
			{
				Node individ = indivizi.item(i);
				if(individ.getNodeType() == Node.ELEMENT_NODE)
				{
					om = new Individual();
					om.setId(((Element)individ).getAttribute("id"));
					om.setName(((Element)individ).getAttribute("name"));
					om.setAddress(((Element)individ).getAttribute("adresa"));
					Node accounts = ((Element)individ).getElementsByTagName("accounts").item(0);
					NodeList account = ((Element)accounts).getElementsByTagName("account");
					conturi = new ArrayList<Account>();
					for(int j = 0 ; j < account.getLength() ; j++)
					{
						Node cont = account.item(j);
						if(cont.getNodeType() == Node.ELEMENT_NODE)
						{
							contulmeu = new Account();
							contulmeu.setId(((Element)cont).getAttribute("id"));
							contulmeu.setAmount(Double.parseDouble(((Element)cont).getAttribute("amount")));
							contulmeu.setCurrency(((Element)cont).getAttribute("currency"));
							conturi.add(contulmeu);
						}
					}
					t1 = new ArrayList<Transaction>();
					for(int l = 0 ; l < t.size() ; l++)
						for(int k = 0 ; k < conturi.size() ; k++)
							if(t.get(l).getSource().equals(conturi.get(k).getId()) || t.get(l).getDestination().equals(conturi.get(k).getId()))
							{
								t1.add(t.get(l));
							}
					t1 = new ArrayList<Transaction>(new LinkedHashSet<Transaction>(t1));
					om.setTransactions(t1);
					om.setAccounts(conturi);
					oameni.add(om);
				}
			}
		cluster.setLegalEntities(oameni);
		} catch (ParserConfigurationException e) 
		{
			System.out.println(e);
		} catch (SAXException e) 
		{
			System.out.println(e);
		} catch (IOException e) 
		{
			System.out.println(e);
		} catch (ParseException e)
		{
			System.out.println(e);
		}
		return cluster;
	}
}
