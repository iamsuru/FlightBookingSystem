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
        <title>Remove Flights</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
    	<%@include file="background.jsp" %>
	    <div class="nav-bar">Book Your Flight Ticket With Us
	        <a href="LogoutServlet"><button style="height: 30px; width: 100px; float:right; margin:0px;">Signout</button></a>
	    </div>
	    <div class="container">
	    	<form id="remove-flight" action="RemoveFlight" method="post">
	    		<input type="text" placeholder="Enter Flight Number" name="flight_number"><br>
	    		<button type="submit">Remove Flight</button>
	    	</form>
	    </div>
        <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
            <script>
                $(document).ready(function(){
                	console.log('ready')
                    $('#remove-flight').on('submit',function(event){
                        event.preventDefault();
                        let form = new FormData(this);
                        $.ajax({
                            url:"RemoveFlight",
                            type:'POST',
                            data:form,
                            success:function(data,textStatus,jqXHR){
                            	if(data.trim()==='success'){
                                    alert("Flight Removed")
                            		window.location="adminPanel.jsp"
                                }
                            	else{
                            		alert("Flight not found")
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