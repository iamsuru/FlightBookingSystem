<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
        <head>
            <title>Admin Login</title>
            <link rel="stylesheet" href="./css/style.css">
        </head>
        <body>
        	<%@include file="background.jsp" %>
            <div class="container">
                <form id="admin-login" action="AdminLoginServlet" method="post">
                    <h2>Admin Login</h2>
                    <label>Email Address</label><br>
                    <input type="email" name="email" required><br>
                    <label>Password</label><br>
                    <input type="password" name="password" required><br>
                    <button id="login-btn" type="submit">Admin Login</button>
                </form>
            </div>
            <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
            <script>
                $(document).ready(function(){
                	console.log('ready')
                    $('#admin-login').on('submit',function(event){
                        event.preventDefault();
                        let form = new FormData(this);
                        $.ajax({
                            url:"AdminLoginServlet",
                            type:'POST',
                            data:form,
                            success:function(data,textStatus,jqXHR){
                            	if(data.trim()==='success'){
                            		window.location="adminPanel.jsp"
                                }
                            	else{
                            		alert("You are not a admin")
	                                window.location="index.jsp"
                            	}
                            },
                            error:function(jqXHR,textStatus,errorThrown){
                                alert('Please Try Again')
                                window.location='index.jsp'
                            },
                            processData: false,
                            contentType:false
                        })
                    })
                })
            </script>
        </body>
    </html>