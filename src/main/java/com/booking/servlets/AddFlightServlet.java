package com.booking.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.entry.addFlight;
import com.booking.helper.DatabaseConnectionProvider;
import com.booking.main.FlightDetails;

@MultipartConfig
public class AddFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flight_number = request.getParameter("flight_number");
		String city_from = request.getParameter("city_from");
		String city_to = request.getParameter("city_to");
		
		addFlight flight = new addFlight(flight_number, city_from, city_to);
		FlightDetails flightDetails = new FlightDetails(DatabaseConnectionProvider.getConnection());
		if(flightDetails.updateFlight(flight)) {
			response.getWriter().append("success");
		}
		else {
			response.getWriter().append("fail");
		}
	}

}
