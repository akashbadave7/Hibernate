<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.bridgeit.Model.UserDetails" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>


</script>
</head>

<body style="padding: 10px;">

    <%
	
		if (session.getAttribute("email") == null) 
		{
			response.sendRedirect("login");
		}    
	%>
	
	
	<div class="container" style="position:relative;">
		 
			 <form action="logout" method="post">	   			 
	   			
				  <div class="row">
			 		<div class="col-sm-4">
					    <div class="well well-sm" style="background-color:lavender;">Email : <%=session.getAttribute("email") %></div>
					</div>
					<div class="col-sm-6">
					    <div class="well well-sm" style="background-color:lavenderblush;width:30%;">Name : <%= session.getAttribute("name") %></div>
					</div>
					<div class="col-sm-2">    
					    <button type="submit" class="btn btn-success">Logout</button>

				  	</div>
				 </div>
	   			
	    	</form>
	</div>
</body>
</html>