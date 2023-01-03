<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.booking.helper.DatabaseConnectionProvider"%>
<%@page import="java.sql.Connection"%>
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
<title>View Bookings</title> 
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<%@include file="background.jsp" %>
        <div class="nav-bar">Book Your Flight Ticket With Us
            <a href="LogoutServlet"><button style="height: 30px; width: 100px; float:right; margin:0px;">Signout</button></a>
        </div>
        <div style="top: 50%; left: 50%; transform: translate(-50%,-50%);" class="container">
        	<%
        		Connection con = DatabaseConnectionProvider.getConnection();
        		PreparedStatement pstmt = con.prepareStatement("select * from bookings");
        		ResultSet set = pstmt.executeQuery();
        	%>
        	<table border="1">
        		<tr>
        			<th>Name</th>
        			<th>Age</th>
        			<th>Gender</th>
        			<th>Flight</th>
        			<th>From</th>
        			<th>To</th>
        			<th>Date</th>
        		</tr>
        		<%while(set.next()){%>
        			<tr>
        				<td><%= set.getString(2) %></td>
        				<td><%= set.getString(3) %></td>
        				<td><%= set.getString(4) %></td>
        				<td><%= set.getString(5) %></td>
        				<td><%= set.getString(6) %></td>
        				<td><%= set.getString(7) %></td>
        				<td><%= set.getString(8) %></td>
        			</tr>
        		<%} %>
        	</table>
        </div>
</body>
</html>