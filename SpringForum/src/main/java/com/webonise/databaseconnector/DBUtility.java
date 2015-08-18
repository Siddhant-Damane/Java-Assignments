package com.webonise.databaseconnector;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null) {
			System.out.println("enter ssses");
			return connection;

		} else {
			try {
				System.out.println("enter db");

				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("before connection db dmr");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restDB", "root", "root");
				System.out.println("afte connection dmr");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}

}