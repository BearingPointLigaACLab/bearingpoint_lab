/**
 * 
 */
package com.bearingpoint.myonlinebankingdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author cristian.gaidos
 *
 */
public class ConnectionContext {
	
	private static Connection connection = null;
	
	private ConnectionContext() {
		
	}
	
	public static final Connection getDBConnection() {
		
		try {
			if(connection == null || connection.isClosed()) {
				
				/* For MySQL we can use the following driver init
				 Class.forName("com.mysql.jdbc.Driver");
			     connection = DriverManager.getConnection("jdbc:mysql://localhost/feedback?"
			              + "user=sqluser&password=sqluserpw");
				*/
				
				 // This will load the Oracle driver, each DB has its own driver
			      Class.forName("oracle.jdbc.driver.OracleDriver");
			      
			      // Setup the connection with the DB
			      connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
			    		  									"abacus_eiopa_master",
															"abacus_eiopa_master");
			      
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return connection;
		}
		
		return connection;
		
	}
	
	
}
