package com.booking.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.booking.entry.UserRegistration;
import com.booking.helper.DatabaseConnectionProvider;

@MultipartConfig
public class userBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameString = request.getParameter("name");
		String ageString = request.getParameter("age");
		String genderString= request.getParameter("user_gender");
		String flight_number = request.getParameter("flight_number");
		String date = request.getParameter("date");
		String city_from="",city_to="";
		int available=0;
		
		
		HttpSession session = request.getSession(false);
		UserRegistration u = (UserRegistration)session.getAttribute("id");
		int id = u.getId();
		Connection con = DatabaseConnectionProvider.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from flights where flight_number=? and flight_date=?");
			pstmt.setString(1, flight_number);
			pstmt.setString(2, date);
			ResultSet set = pstmt.executeQuery();
			if(set.next()) {
				city_from = set.getString("city_from");
				city_to = set.getString("city_to");
				available = set.getInt("available");
			}
			bookTicket(response,con,nameString,ageString,genderString,flight_number,date,city_from,city_to,available,id);
			//response.getWriter().append("working");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void bookTicket(HttpServletResponse response, Connection con, String nameString, String ageString, String genderString,String flight_number, String date, String city_from, String city_to, int available,int id) throws SQLException, IOException {
		PreparedStatement pstmt = con.prepareStatement("insert into bookings values(?,?,?,?,?,?,?,?)");
		pstmt.setInt(1, id);
		pstmt.setString(2, nameString);
		pstmt.setString(3, ageString);
		pstmt.setString(4, genderString);
		pstmt.setString(5, flight_number);
		pstmt.setString(6, city_from);
		pstmt.setString(7, city_to);
		pstmt.setString(8, date);
		pstmt.executeUpdate();
		//response.getWriter().append("booked");
		pstmt = con.prepareStatement("update flights set available=? where flight_date=? and flight_number=?");
		pstmt.setInt(1, available-1);
		pstmt.setString(2, date);
		pstmt.setString(3, flight_number);
		pstmt.executeUpdate();
		response.getWriter().append("success");
	}

}
