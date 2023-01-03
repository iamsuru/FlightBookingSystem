package com.booking.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.helper.DatabaseConnectionProvider;
import com.booking.main.FlightDetails;

@MultipartConfig
public class RemoveFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flight_number = request.getParameter("flight_number");
		FlightDetails flightDetails = new FlightDetails(DatabaseConnectionProvider.getConnection());
		if(flightDetails.removeFlight(flight_number)) {
			response.getWriter().append("success");
		}
		else {
			response.getWriter().append("fail");
		}
	}

}
