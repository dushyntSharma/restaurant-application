package com.project.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String JDBCURL = "jdbc:mysql://127.0.0.1:3306/restaurant";
	private static String USERNAME = "root";
	private static String PASSWORD = "9909";

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return con;

	}

}
