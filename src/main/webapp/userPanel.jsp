<%@page import="com.booking.entry.UserRegistration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	UserRegistration user = (UserRegistration)session.getAttribute("currentUser");
	if(user==null){
		response.sendRedirect("index.jsp");
	}
%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Panel</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <%@include file="background.jsp" %>
        <div class="nav-bar">Book Your Flight Ticket With Us
            <a href="LogoutServlet"><button style="height: 30px; width: 100px; float:right; margin:0px;">Signout</button></a>
        </div>
        <div class="container">
            <a href="searchFlight.jsp"><button id="searchFlight">Search Flight</button></a><br>
            <a href="userDetailsForBooking.jsp"><button id="book-ticket">Book Ticket</button></a><br>
            <a href="myBookings.jsp"><button id="booking">My Booking</button></a><br>              
        </div>
    </body>
</html>