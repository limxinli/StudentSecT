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
      <form action="RetrieveStudentServlet" method="post" class="form-signin">
        <div style="color: #FF0000;">${errorMessage}</div>
        <h3 class="form-signin-heading">Admission Number:</h3>
        <input type="text" name="adminNo" id="adminNo" class="form-control" placeholder="E.g. P1234567" required autofocus><br>
        <h3 class="form-signin-heading">Exam Code:</h3>
        <input type="text" name="examCode" id="examCode" class="form-control" placeholder="E.g. ABC123" required autofocus><br><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Enter</button>
      </form>
    </div>
    <footer class="footer">
	   <p id="copyright">&copy; 2017 Singapore Polytechnic (DISM/FT/3A/62)</p>
	</footer>
  </body>
</html>