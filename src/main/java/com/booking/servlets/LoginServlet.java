package com.booking.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.booking.entry.UserRegistration;
import com.booking.helper.DatabaseConnectionProvider;
import com.booking.main.User;

@MultipartConfig
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User(DatabaseConnectionProvider.getConnection());
		UserRegistration current = user.getUser(email, password);
		if(current==null) {
			response.getWriter().append("No user found");
		}
		else{
			response.getWriter().append("success");
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("currentUser", current);
			httpSession.setAttribute("id", current);
			//response.sendRedirect("userPanel.jsp");
		}
	}
}
