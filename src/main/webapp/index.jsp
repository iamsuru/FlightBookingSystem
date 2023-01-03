<%@page import="com.booking.helper.DatabaseConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
    	<title>Flight Ticket Booking</title>
    	<link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
    	<%@include file="background.jsp" %>
        <div class="nav-bar">Book Your Flight Ticket With Us</div>
        <div class="container">
            <a href="admin.jsp"><button>Admin</button></a><br>
            <a href="signin.jsp"><button>Sign in</button></a><br>
            <a href="signup.jsp"><button>Join us</button></a><br>
        </div>
    </body>
</html>