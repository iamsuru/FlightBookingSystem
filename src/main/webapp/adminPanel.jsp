<%@page import="com.booking.entry.UserRegistration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	UserRegistration user = (UserRegistration)session.getAttribute("currentUser");
	if(user==null){
		response.sendRedirect("admin.jsp");
	}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin Panel</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
<body>
    <%@include file="background.jsp" %>
        <div class="nav-bar">Book Your Flight Ticket With Us
            <a href="LogoutServlet"><button style="height: 30px; width: 100px; float:right; margin:0px;">Signout</button></a>
        </div>
        <div class="container">
            <a href="addFlights.jsp"><button>Add Flights</button></a><br>
            <a href="removeFlights.jsp"><button>Remove Flights</button></a><br>
            <a href="viewBookingAdmin.jsp"><button>View Bookings</button></a><br>
        </div>
</body>
</html>