<%@page import="com.booking.entry.UserRegistration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	UserRegistration user = (UserRegistration)session.getAttribute("currentUser");
	if(user==null){
		response.sendRedirect("signin.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Your Ticket</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
    <%@include file="background.jsp" %>
        <div class="nav-bar">Book Your Flight Ticket With Us
            <a href="LogoutServlet"><button style="height: 30px; width: 100px; float:right; margin:0px;">Signout</button></a>
        </div>
        <div class="container">
            <form action="BookFlightServlet" method="get" >
                <input type="text" name="booking_from" placeholder="Enter City From" required><br>
                <input type="text" name="booking_to" placeholder="Enter City To" required><br>
                <input type="date" name="date" required><br>
                <button type="submit">Book Flight</button>
            </form>
        </div>
</body>
</html>