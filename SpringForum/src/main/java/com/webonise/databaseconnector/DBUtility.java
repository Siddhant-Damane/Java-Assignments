package com.webonise.databaseconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class DBUtility {

	private static final Logger logger = Logger.getLogger(DBUtility.class);
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null) {
			logger.info("Checking Connection");
			return connection;
		} else {
			try {
				logger.info("Creating Connection to Database");
				Class.forName("com.mysql.jdbc.Driver");
				logger.info("Driver Loaded");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restDB", "root", "root");
				logger.info("Connection Created");
			}
			catch (ClassNotFoundException e){
				logger.error(e);
			}
			catch (SQLException e) {
				logger.error(e);
			}
			return connection;
		}
	}
}