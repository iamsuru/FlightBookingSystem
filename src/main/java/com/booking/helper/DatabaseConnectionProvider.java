package com.booking.helper;
import java.sql.*;
public class DatabaseConnectionProvider {
	private static Connection con;
	public static Connection getConnection() {
		try {
			if(con==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");	
				con = DriverManager.getConnection("jdbc:mysql://localhost:7969/flight_ticket_booking", "root", "@Suru_07112000@");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
