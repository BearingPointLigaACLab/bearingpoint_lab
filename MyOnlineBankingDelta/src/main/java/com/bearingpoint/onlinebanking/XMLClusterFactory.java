package com.bearingpoint.onlinebanking;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLClusterFactory extends AbstractClusterFactory {

	/**
	 * Reads Cluster information from the specified file.
	 */
	@Override
	public Cluster read(Object source) {

		Cluster cluster = new Cluster();

		List<LegalEntity> legalEntities = new ArrayList<>();;

		List<Account> accounts = null;
		List<Transaction> transactions = null;

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse((File) source);

			Element clusterElement = doc.getDocumentElement();

			String clusterId = clusterElement.getAttribute("id");
			String clusterName = clusterElement.getAttribute("name");
			
			cluster.setId(clusterId);
			cluster.setName(clusterName);

			Node legalEntitiesNode = clusterElement.getElementsByTagName("legalEntities").item(0);
			Node transactionsNode = clusterElement.getElementsByTagName("transactions").item(0);

			NodeList transactionsNodeList = ((Element) transactionsNode).getElementsByTagName("transaction");

			for (int k = 0; k < transactionsNodeList.getLength(); k++) {
				Node transactionNode = transactionsNodeList.item(k);

				String transactionId = transactionNode.getAttributes().getNamedItem("id").getNodeValue();
				String transactionSource = transactionNode.getAttributes().getNamedItem("source").getNodeValue();
				String transactionDestination = transactionNode.getAttributes().getNamedItem("destination")
						.getNodeValue();

				DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
				Date transactionDate = format
						.parse(transactionNode.getAttributes().getNamedItem("date").getNodeValue());

				Double transactionAmount = Double
						.valueOf(transactionNode.getAttributes().getNamedItem("amount").getNodeValue());

				transactions = new ArrayList<>();

				transactions.add(new Transaction(transactionId, transactionSource, transactionDestination,
						transactionDate, transactionAmount));
			}

			NodeList individualsNodeList = ((Element) legalEntitiesNode).getElementsByTagName("individual");

			for (int i = 0; i < individualsNodeList.getLength(); i++) {
				
				accounts = new ArrayList<>();
				
				Node individualNode = individualsNodeList.item(i);

				
				
				String individualId = individualNode.getAttributes().getNamedItem("id").getNodeValue();
				String individualName = individualNode.getAttributes().getNamedItem("name").getNodeValue();

				Node accountsNode = ((Element) individualNode).getElementsByTagName("accounts").item(0);

				NodeList accountsNodeList = ((Element) accountsNode).getElementsByTagName("account");

				for (int j = 0; j < accountsNodeList.getLength(); j++) {
					Node accountNode = accountsNodeList.item(j);

					String accountId = accountNode.getAttributes().getNamedItem("id").getNodeValue();
					Double accountAmount = Double
							.valueOf(accountNode.getAttributes().getNamedItem("amount").getNodeValue());
					String accountCurrency = accountNode.getAttributes().getNamedItem("currency").getNodeValue();

					accounts.add(new Account(accountId, accountAmount, accountCurrency));
				}

				legalEntities.add(new Individual(individualId, individualName, cluster, "Popa Sapca", accounts, transactions));
			}
			
			cluster.setLegalEntities(legalEntities);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cluster;

	}

}
