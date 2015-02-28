package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	final static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final static String USER = "dbuser";
	final static String PASS = "82664442";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}
}
