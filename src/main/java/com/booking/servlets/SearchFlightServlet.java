package com.booking.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.booking.helper.DatabaseConnectionProvider;

public class SearchFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\"> <title>Search Results</title> <link rel=\"stylesheet\" href=\"./css/style.css\">");
		out.println("</head>");
		out.println("<body>");
			request.getRequestDispatcher("background.jsp").include(request, response);
			String city_from = request.getParameter("booking_from");
			String city_to = request.getParameter("booking_to");
			String date = request.getParameter("date");
			
			Connection connection = DatabaseConnectionProvider.getConnection();
			try {
				if(!checkRunningFlight(connection,city_from,city_to).equals("")) {
					String number = checkRunningFlight(connection, city_from, city_to);
					PreparedStatement pstmt = connection.prepareStatement("insert into flights values(?,?,?,?,?)");
					pstmt.setString(1, number);
					pstmt.setString(2, city_from);
					pstmt.setString(3, city_to);
					pstmt.setInt(4, 60);
					pstmt.setString(5, date);
					pstmt.executeUpdate();
					
					//now fetching flights
					
					pstmt = connection.prepareStatement("select * from flights where city_from =? and city_to=? and flight_date=?");
					pstmt.setString(1, city_from);
					pstmt.setString(2, city_to);
					pstmt.setString(3, date);
					ResultSet set = pstmt.executeQuery();
					
					out.println("<div class=\"container\" style=\"left:50%; top:50%; transform: translate(-50%, -50%);\">");
					out.println("<table border=\"1 width=50% height=50%\"><tr>\r\n <th>Flight Number</th>\r\n <th>From</th>\r\n <th>To</th>\r\n <th>Date</th>\r\n <th>Available</th>\r\n </tr>");
					while(set.next()) {
						String flight_number = set.getString(1);
						String city1 = set.getString(2);
						String city2 = set.getString(3);
						String tdate = set.getString(5);
						int available = set.getInt(4);
						out.println("<tr><td>"+flight_number+"</td><td>"+city1+"</td><td>"+city2+"</td><td>"+tdate+"</td><td>"+available+"</td></tr>");
					}
					out.println("</table>");
					out.println("</div>");
					out.println("</body>");
					out.println("</html>");
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		//SearchFlightClass flight = new SearchFlightClass(city_from, city_to, date);;
		
	}

	private String checkRunningFlight(Connection connection, String city_from, String city_to) throws SQLException {
		// TODO Auto-generated method stub
		String value="";
		PreparedStatement pstmt = connection.prepareStatement("select * from flights where city_from=? and city_to=?");
		pstmt.setString(1, city_from);
		pstmt.setString(2, city_to);
		ResultSet set = pstmt.executeQuery();
		if(set.next()) {
			value = set.getString("flight_number");
		}
		return value;
	}
}