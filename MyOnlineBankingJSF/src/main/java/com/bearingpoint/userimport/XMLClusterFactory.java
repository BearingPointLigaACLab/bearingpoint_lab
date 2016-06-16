package com.bearingpoint.userimport;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * A MyOnlineBanking cluster factory that reads input from an XML file or an XML input stream in custom format.
 * 
 * @author corian.paun
 *
 */
public class XMLClusterFactory extends AbstractClusterFactory {

	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public Cluster read(Object o) throws Exception {
		Cluster cluster = null;
		if (!(o instanceof File || o instanceof InputStream)) {
			throw new Exception("Expected a File or an InputStream object!");
		}
		cluster = new Cluster();

		// parse XML file
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = null;
		if (o instanceof File) {
			doc = dBuilder.parse((File) o);
		}
		if (o instanceof InputStream) {
			doc = dBuilder.parse((InputStream) o);
		}

		// read cluster basic info
		cluster.setId(doc.getDocumentElement().getAttribute("id"));
		cluster.setName(doc.getDocumentElement().getAttribute("name"));

		// read transactions
		Node transactionsNode = doc.getElementsByTagName("transactions").item(0);
		NodeList transactionNodes = null;
		List<Transaction> transactions = null;
		if (transactionsNode != null) {
			transactionNodes = ((Element) transactionsNode).getElementsByTagName("transaction");
			transactions = new ArrayList<Transaction>();
			for (int i = 0; i < transactionNodes.getLength(); i++) {
				Node transactionNode = transactionNodes.item(i);
				if (transactionNode.getNodeType() == Node.ELEMENT_NODE) {
					Transaction transaction;
					transaction = new Transaction();
					transaction.setId(((Element) transactionNode).getAttribute("id"));
					transaction.setSource(((Element) transactionNode).getAttribute("source"));
					transaction.setDestination(((Element) transactionNode).getAttribute("destination"));
					Date date = DATE_FORMAT.parse(((Element) transactionNode).getAttribute("date"));
					transaction.setDate(date);
					transaction.setAmount(Double.parseDouble(((Element) transactionNode).getAttribute("amount")));
					transactions.add(transaction);
				}
			}
		}
		// read legal entities
		Node legalEntitiesNode = doc.getElementsByTagName("legalEntities").item(0);
		if (legalEntitiesNode != null) {
			NodeList individualNodes = ((Element) legalEntitiesNode).getElementsByTagName("individual");
			List<LegalEntity> legalEntities = cluster.getLegalEntities();
			for (int i = 0; i < individualNodes.getLength(); i++) {
				Node individual = individualNodes.item(i);
				if (individual.getNodeType() == Node.ELEMENT_NODE) {
					LegalEntity legalEntity = new Individual();
					legalEntity.setId(((Element) individual).getAttribute("id"));
					legalEntity.setName(((Element) individual).getAttribute("name"));
					legalEntity.setAddress(((Element) individual).getAttribute("address"));
					Node accountsNode = ((Element) individual).getElementsByTagName("accounts").item(0);
					NodeList accountNodes = ((Element) accountsNode).getElementsByTagName("account");
					List<Account> accounts = legalEntity.getAccounts();
					for (int j = 0; j < accountNodes.getLength(); j++) {
						Node cont = accountNodes.item(j);
						if (cont.getNodeType() == Node.ELEMENT_NODE) {
							Account account = new Account();
							account.setId(((Element) cont).getAttribute("id"));
							account.setAmount(Double.parseDouble(((Element) cont).getAttribute("amount")));
							account.setCurrency(((Element) cont).getAttribute("currency"));
							accounts.add(account);
						}
					}
					if (transactions != null) {
						List<Transaction> legalEntityTransactions = legalEntity.getTransactions();
						for (int l = 0; l < transactions.size(); l++)
							for (int k = 0; k < accounts.size(); k++)
								if (transactions.get(l).getSource().equals(accounts.get(k).getId())
										|| transactions.get(l).getDestination().equals(accounts.get(k).getId())) {
									legalEntityTransactions.add(transactions.get(l));
								}
					}
					legalEntities.add(legalEntity);
				}
			}
		}
		return cluster;
	}

	public static void main(String[] args) {
		XMLClusterFactory factory = new XMLClusterFactory();
		try {
			URL xmlURL = XMLClusterFactory.class.getClassLoader().getResource("sample.xml");
			File xmlFile = new File(xmlURL.toURI().getPath());
			Cluster c = factory.read(xmlFile);
			System.out.println(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
