package com.bearingpoint.MyOnlineBankingDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {

	private static Connection connection = null;

	public static void main(String[] args) {
		try {
			// Retrieve the connection
			try {
				if (connection == null) {

					// This will load the Oracle driver, each DB has its own driver
					Class.forName("oracle.jdbc.driver.OracleDriver");

					// Setup the connection with the DB
					connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
							"abacus_eiopa_master", "abacus_eiopa_master");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			// Check if connection is up and running
			if (connection != null && !connection.isClosed()) {
				System.out.println("Connection open!");
			} else {
				System.out.println("Connection closed!");
			}

			Statement statement = null;
			ResultSet resultSet = null;

			// Statements allow to issue SQL queries to the database
			statement = connection.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from app_user");
			
			StringBuilder sb = new StringBuilder("\n");

			// ResultSet is initially before the first data set
			if (!resultSet.isClosed())
				while (resultSet.next()) {
					// It is possible to get the columns via name
					// also possible to get the columns via the column number
					// which starts at 1
					// e.g. resultSet.getString(1) for the first column;

					String user = resultSet.getString("name");
					String pass = resultSet.getString("password");
					Boolean isAdmin = resultSet.getBoolean("admin");

					sb.append("Username: ").append(user).append("\n");
					sb.append("Password: ").append(pass).append("\n");
					sb.append("Has addministrator rights: ").append(isAdmin).append("\n");
					sb.append("-------------------------------------------------------->\n");
				}
			System.out.println(sb.toString());

			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
