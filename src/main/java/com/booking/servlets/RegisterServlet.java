package com.booking.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.entry.UserRegistration;
import com.booking.helper.DatabaseConnectionProvider;
import com.booking.main.User;
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String gender = request.getParameter("user_gender");
		String password = request.getParameter("user_password");
		
		//creating user
		UserRegistration userRegistration = new UserRegistration(name, email, gender, password, password);
		//creating addUser object and getting connection from DatabaseConnectionProvider class
		User user = new User(DatabaseConnectionProvider.getConnection());
		//updating user to database
		if(user.registerUser(userRegistration)) {
			response.getWriter().append("success");
		}
		else {
			response.getWriter().append("fail");
		}
	}

}
