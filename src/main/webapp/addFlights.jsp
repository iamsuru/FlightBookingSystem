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
        <title>Add Flights</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
<body>
    <%@include file="background.jsp" %>
    <div class="nav-bar">Book Your Flight Ticket With Us
        <a href="LogoutServlet"><button style="height: 30px; width: 100px; float:right; margin:0px;">Signout</button></a>
    </div>
    <div class="container">
        <form id="add-flight" action="AddFlightServlet" method="post">
            <input type="text" name="flight_number" placeholder="Enter Flight Number"><br>
            <input type="text" name="city_from" placeholder="Enter City From"><br>
            <input type="text" name="city_to" placeholder="Enter City To"><br>
            <button type="submit">Add Flight</button>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
            <script>
                $(document).ready(function(){
                	console.log('ready')
                    $('#add-flight').on('submit',function(event){
                        event.preventDefault();
                        let form = new FormData(this);
                        $.ajax({
                            url:"AddFlightServlet",
                            type:'POST',
                            data:form,
                            success:function(data,textStatus,jqXHR){
                            	if(data.trim()==='success'){
                                    alert("Flight Added")
                            		window.location="adminPanel.jsp"
                                }
                            	else{
                            		alert(data)
                            	}
                            },
                            error:function(jqXHR,textStatus,errorThrown){
                                alert('Please Try Again')
                                window.location='adminPanel.jsp'
                            },
                            processData: false,
                            contentType:false
                        })
                    })
                })
            </script>
</body>
</html>