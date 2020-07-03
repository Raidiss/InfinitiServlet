package com.infiniti.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	public static Connection conn = null;

	public static Connection getConnection() {
		try {
			if (conn == null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String endpoint = "jdbc:oracle:thin:@infinitidb.cwen3yeqhixc.us-east-2.rds.amazonaws.com:1521:ORCL";
				String username = "raidis";
				String password = "testing1234";

				conn = DriverManager.getConnection(endpoint, username, password);
				return conn;
			} else {
				return conn;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String args[]) {

		// This main method is only for testing purposes
		// It won't be where our actual application runs from.
		Connection conn1 = getConnection();
		Connection conn2 = getConnection();
		Connection conn3 = getConnection();

		System.out.println(conn1);
		System.out.println(conn2);
		System.out.println(conn3);
	}
}
