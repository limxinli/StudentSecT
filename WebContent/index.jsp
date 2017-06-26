<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Secured-T</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/index.css" rel="stylesheet">
    
    <!-- Favicon -->
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
	
	<%
		session.setAttribute("LOGIN","FALSE");
	%>

  </head>

  <body>

    <div class="container">

      <form action="RetrieveAnnouncementServlet" class="form-signin">
        <div style="color: #FF0000;">${errorMessage}</div>
        <h2 class="form-signin-heading">Exam Code:</h2>
        <input type="text" name="examCode" id="examCode" class="form-control" placeholder="E.g. ABC123" required autofocus><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="submitCode()">Enter</button>
      </form>

    </div>
  </body>
</html>