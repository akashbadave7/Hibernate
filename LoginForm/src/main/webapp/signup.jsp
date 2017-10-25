<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/form.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Sign Up</title>

<script src="js/Validation.js"></script>
</head>
<body style="background-color:#F2F3F4;">
<div class="container">
 			<form name="document" action="SignupPage" method="post" role="form">
 			<h3>Sign up</h3>
           
              <div class="form-group"> 	 
                <label for="name"><span class="req" style="color:red;">* </span> Name </label>
                    <input class="form-control" type="text" name="name" id ="name" onkeyup = "Validate(this)" placeholder="Enter name" /> 
                        <div id="errName"></div>    
            	</div>

				<div class="form-group">
                <label for="email"><span class="req" style="color:red;">* </span> Email </label> 
                    <input class="form-control" type="text" name="email" id = "email"  onchange="email_validate(this.value)" placeholder="Enter email" />   
                        <div class="status" id="status"></div>
            	</div>
				 <div class="form-group">
                	<label for="password"><span class="req" style="color:red;">* </span> Password: </label>
                    <input  name="password" type="password" class="form-control inputpass" minlength="8"  id="pass" name="pass" onkeyup="checkPass(); return false;" placeholder="Enter password"/> </p>
                 </div>
				<div class="form-group">
            	<label for="phonenumber"><span class="req" style="color:red;">* </span> Phone Number: </label>
                    <input type="number" name="mobile" id="mobile" class="form-control phone" maxlength="13" min="0" onkeyup="validatephone(this);" placeholder="Enter Phone Number"/> 
            	</div>
				
				<br>
				      <button type="submit" class="btn btn-primary"><b>Sign up</b></button>
				      <a  class="btn btn-primary" href="login" role="button"  style="margin-right: 20%; width:80px"><b>Cancel</b></a>
				<br>
				
				<% String message= (String) session.getAttribute("error");
               if(message!=null)
               {          	   	
               		out.println("<center><font color='red'><h4>" + message);
               		session.removeAttribute("error");
               }
               %> 
			</form>
        </div>
</body>
</html>