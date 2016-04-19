package com.bearingpoint.onlinebanking.tests;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.util.*;
import org.junit.Test;

import com.bearingpoint.onlinebanking.*;


public class XMLReaderTestCase {
	
	@Test
	public void testXMLLoading() throws URISyntaxException {
		
		
		XMLClusterFactory xmlFactory = new XMLClusterFactory();
		
		Cluster cluster = xmlFactory.read(getClass().getClassLoader().getResource("sample.xml"));
		assertTrue(cluster.getId().equals("cl_001"));
		assertTrue(cluster.getName().equals("myCluster"));
		
			
		
		
		
		// Add assertion check for each legal entity
		
	}

	

}
