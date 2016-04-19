package com.bearingpoint.onlinebanking.tests;

import static org.junit.Assert.*;

import java.io.*;
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
		
		List<LegalEntity> oameni = cluster.getLegalEntities();
		try 
		{
			@SuppressWarnings("resource")
			BufferedReader buf = new BufferedReader(new InputStreamReader
								(new FileInputStream("src/main/resources/oameni.txt")));
			for(LegalEntity om : oameni)
				assertTrue(om.getName().equals(buf.readLine()));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
	}

	

}
