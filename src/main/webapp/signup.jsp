<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Account</title>
        <link rel="stylesheet" href="./css/style.css">
    </head>
    <body>
        <%@include file="background.jsp" %>
        <div class="container">
            <form id="new-user" action="RegisterServlet" method="post">
	            <h2>Create Account</h2>
                <label>Enter Full Name</label><br>
                <input type="text" name="user_name" required><br>
	            <label>Email Address</label><br>
	            <input type="email" name="user_email" required><br>
	            <label>Gender</label>
	            <input id="gen" type="radio" value="male" name="user_gender"><label style="color: white; margin:0px">Male</label>
                <input id="gen" type="radio" value="female" name="user_gender"><label style="color: white; margin:0px">Female</label><br>
	            <label>Password</label><br>
	            <input type="password" name="user_password" required><br>
	            <input id="signup-btn" name="submit" type="submit" value="Sign Up"><br>
        	</form>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
        <script>
            $(document).ready(function(){
                $('#new-user').on('submit',function(event){
                    event.preventDefault();
                    let form = new FormData(this);
                    $.ajax({
                        url:"RegisterServlet",
                        type:'POST',
                        data:form,
                        success:function(data,textStatus,jqXHR){
                            if(data.trim()==='success'){
                                alert("Account Created Successfully")
                                window.location="signin.jsp"
                            }
                            else{
                                alert(data)
                            }
                        },
                        error:function(jqXHR,textStatus,errorThrown){
                            alert('Please Try Again')
                        },
                        processData: false,
                        contentType:false
                    })
                })
            })
        </script>
    </body>
</html>