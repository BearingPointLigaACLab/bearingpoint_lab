package com.bearingpoint.MyOnlineBankingDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class DBApp {

	private static Connection conn = null;

	public static void main(String[] args) {
		try {
			// Retrieve the connection
			conn = ConnectionContext.getDBConnection();

			// Check if connection is up and running
			if (conn != null && !conn.isClosed()) {
				System.out.println("Connection open!");
			} else {
				System.out.println("Connection closed!");
			}

			Statement statement = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			
			preparedStatement = conn.prepareStatement("insert into app_user values (?, ?, ?, ?)");
			
			preparedStatement.setString(1, "APP_USER_XX");
			preparedStatement.setString(2, "PrepStatement User");
			preparedStatement.setString(3, "45534");
			preparedStatement.setInt(4, 0);
			
			preparedStatement.executeQuery();
			
			
			// Statements allow to issue SQL queries to the database
			statement = conn.createStatement();
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

			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
