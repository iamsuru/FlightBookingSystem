package com.booking.main;

import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
import com.booking.entry.addFlight;

public class FlightDetails {
	private Connection con;
	public FlightDetails(Connection con) {
		this.con = con;
	}
	


	public boolean updateFlight(addFlight flight) {
		boolean status = false;
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into flights values(?,?,?,60,curdate());");
			//one way
			pstmt.setString(1,flight.getFlight_number());
			pstmt.setString(2, flight.getCity_from());
			pstmt.setString(3, flight.getCity_to());
			pstmt.executeUpdate();
			
			//return
			pstmt = con.prepareStatement("insert into flights values(?,?,?,60,curdate());");
			pstmt.setString(1,Integer.toString(Integer.parseInt(flight.getFlight_number())+1));
			pstmt.setString(2, flight.getCity_to());
			pstmt.setString(3, flight.getCity_from());
			
			pstmt.executeUpdate();
			status = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean removeFlight(String flight_number) {
		boolean status = false;
		try {
			PreparedStatement pstmt = con.prepareStatement("delete from flights where flight_number=?");
			pstmt.setString(1, flight_number);
			pstmt.executeUpdate();
			status = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}
}
