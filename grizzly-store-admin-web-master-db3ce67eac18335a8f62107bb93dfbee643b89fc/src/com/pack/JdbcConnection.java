package com.pack;

import java.sql.*;

public class JdbcConnection {
	
	
	public static Connection getConnection() {
		 Connection con=null;	
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cts","root","root");
		
			
			
			}
		catch(Exception e) {
			System.out.println(e);
			
		}
		return con;
	}

}
