<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
        <head>
            <title>User Login</title>
            <link rel="stylesheet" href="./css/style.css">
        </head>
        <body>
        	<%@include file="background.jsp" %>
            <div class="container">
                <form id="login-user" action="LoginServlet" method="post">
                    <h2>User Login</h2>
                    <label>Email Address</label><br>
                    <input type="email" name="email" required><br>
                    <label>Password</label><br>
                    <input type="password" name="password" required><br>
                    <button id="login-btn" type="submit">Login</button>
                </form>
            </div>
            <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
            <script>
                $(document).ready(function(){
                	console.log('ready')
                    $('#login-user').on('submit',function(event){
                        event.preventDefault();
                        let form = new FormData(this);
                        $.ajax({
                            url:"LoginServlet",
                            type:'POST',
                            data:form,
                            success:function(data,textStatus,jqXHR){
                            	if(data.trim()==='success'){
                            		window.location="userPanel.jsp"
                                }
                            	else{
                            		alert("No user found")
	                                window.location="signup.jsp"
                            	}
                            },
                            error:function(jqXHR,textStatus,errorThrown){
                                alert('Please Try Again')
                                window.location='signin.jsp'
                            },
                            processData: false,
                            contentType:false
                        })
                    })
                })
            </script>
        </body>
    </html>