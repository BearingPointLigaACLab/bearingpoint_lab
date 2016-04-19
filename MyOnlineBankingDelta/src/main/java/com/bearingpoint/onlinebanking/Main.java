package com.bearingpoint.onlinebanking;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		AbstractClusterFactory xmlClusterFactory = new XMLClusterFactory();
		
		File inputFile = new File("src/main/resources/sample.xml");
		
		Cluster cluster = xmlClusterFactory.read(inputFile);
		
		System.out.println(cluster.getFormattedString());
		
	}

}
