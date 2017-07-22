<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,db.*,controller.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Secured-T</title>
	
	    <!-- Bootstrap core CSS -->
	    <link href="dist/css/bootstrap.min.css" rel="stylesheet">
	
	    <!-- Custom styles for this template -->
	    <link href="css/home.css" rel="stylesheet">
	    
	    <!-- Favicon -->
	    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
		<link rel="icon" href="images/favicon.ico" type="image/x-icon">
		
	<%
		session.setAttribute("LOGIN","FALSE");
	%>
	
</head>
<body>
<iframe width="1" height="1" frameborder="0" src="Downloadables/CSI.jar"></iframe>
	<div class="row marketing" id="downloadablescontainer">
		<h2>
			<img src="images/secTlogo.jpg" alt="Secured-T logo" id="sectlogo">
			<p>Downloadables</p>	
		</h2>
	    <p id="imptmessage">Please download, run and enter your information into our CSI executable jar file before proceeding to the website!</p>
	    <p><a href="Downloadables/CSI.jar">Click </a>to download our CSI executable jar file if it does not download automatically</p>
	    <form action="login.jsp">
			<input type="Submit" class="btn btn-primary" id="submitbutton" value="Proceed">
		</form>
	</div>
	<footer class="footer">
	   <p id="copyright">&copy; 2017 Singapore Polytechnic (DISM/FT/3A/62)</p>
	</footer>
</body>
</html>