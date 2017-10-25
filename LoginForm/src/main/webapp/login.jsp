<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/form.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Login</title>
<!-- <style type="text/css">
.container
{
	border : 1px solid black;
	box-shadow: 0 0 10px black;
	background-color : white;
	padding : 10px;
	bottom : 0;
	posirion : relative;
	max-width: 325px; 
	/* max-height: 700px; */
	margin-top: 10%;
	margin-bottom: 10%;
	padding-bottom: 50px;

}
.body
{
	baggroung-color: #F2F3F4;
    direction: ltr;
    font-family: 'Roboto'',sans-serif;
    font-size: 14px;
    line-height: 20px;
}

</style> -->
<script type="text/javascript">

</script>
</head>
<body class = "body">
	
		<form action="LoginPage" method="post">
  		<div class="container">
  		
 			<h2>Sign in</h2>
                <!--  <b><font color="white">Login Form</font> </b> -->
              <% String message= (String) session.getAttribute("error");
               if(message!=null)
               {
               		out.println("<font color='red'><h4>"+message+"</h4></font>");
               		session.removeAttribute("error");
               }
               %> 
               
                <div class="input-control">
				<label for="email">Email:</label>
		      	<input type="email" class="form-control" id="email" autocomplete="username" name="email" placeholder="Enter email" required onsubmit="validate(this)">   
			</div><br>

			<div class="input-control">
				<label for="password">Password:</label>
		      	<input type="password" class="form-control" id="password" name ="pass" placeholder="Enter password" required>
				<div id="errUser"></div>  
			</div>
			<br>
				      <button type="submit" class="btn btn-primary" style="margin-left: 20%; width:80px"><b>Login</b></button>
				      <a  class="btn btn-primary" href="signup" role="button"  style="margin-right: 20%; width:80px"><b>SignUp</b></a>
			<br>
		</div>
			 
		</form>
</body>
</html>