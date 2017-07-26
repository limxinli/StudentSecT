<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,db.*,controller.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Secured-T</title>
		<!-- Jquery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	    <!-- Bootstrap core CSS -->
	    <link href="dist/css/bootstrap.min.css" rel="stylesheet">
	
	    <!-- Custom styles for this template -->
	    <link href="css/home.css" rel="stylesheet">
	    
	    <!-- Favicon -->
	    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
		<link rel="icon" href="images/favicon.ico" type="image/x-icon">

		<%
			if(session.getAttribute("LOGIN") != "TRUE") {
				response.sendRedirect("login.jsp");
			}
		%>
</head>
<body>
	<% 
	ArrayList<AssessmentDetails> retrieveAssessment = (ArrayList<AssessmentDetails>)session.getAttribute("assessment");
	
	 if (retrieveAssessment != null) {
		for(AssessmentDetails assessment:retrieveAssessment) { 
		%>
	<div class="container">
	      <div class="header clearfix">
	        <nav>
	          <ul class="nav nav-pills pull-right">
	            <li role="presentation"><a href="RetrieveAnnouncementServlet?assessmentID=<%=assessment.getId()%>">Announcements</a></li>
	<% 
		 ArrayList<StudentDetails> retrieveStudent = (ArrayList<StudentDetails>)session.getAttribute("student");
				
		 if (retrieveStudent != null) {
			for(StudentDetails student:retrieveStudent) {
	%>			
				<li role="presentation" class="active"><a href="RetrieveStudentSubmissionServlet?adminNo=<%=student.getAdminNo()%>&uCode=<%=student.getUniqueCode()%>">Submissions</a></li>
				<li role="presentation" id="notif"><a href="LogOutServlet?adminNo=<%=student.getAdminNo()%>" onclick="return confirmlogout()">Logout</a></li>
		<%
		break;
			}
		 }
		%>
				</ul>
	        </nav>
	        <h3 class="text-muted"><img src="images/logo.png" alt="Secured-T logo" id="logo">Secured-T</h3>
	      </div>
		  <h3>
		  	<%=assessment.getModuleCode()%> -
			<%=assessment.getModuleName()%>
		  </h3>
		  <%
					break;}}
		%>
	<% 
		 ArrayList<StudentSubmissionDetails> retrieveStudentSub = (ArrayList<StudentSubmissionDetails>)session.getAttribute("studentsub");
				
		 if (retrieveStudentSub != null) {
			for(StudentSubmissionDetails studentsub:retrieveStudentSub) {
	%>	
	      <div class="row marketing">
		  <p id="imptmessage2">Please include your admission number in the naming convention: <br>Admission Number.&lt;extension&gt; <br>E.g. P1234567.doc</p>
	      <div onsubmit="return confirmation()" class="row marketing" id="uploadcontainer">
				<form action="FileUploadServlet" method="post" enctype="multipart/form-data">
					<input type="file" name="file"/>
					<input type="hidden" name="adminNo" value="<%=studentsub.getAdminNo()%>">
					<input type="Submit" class="btn btn-primary" id="submitbutton">
				</form>
	      </div>
	      <div style="color: #FF0000;">${cfmMessage}</div>
	      </div>
	      <%
				}
			 }
	      %>
		</div>
	<footer class="footer">
	   <p id="copyright">&copy; 2017 Singapore Polytechnic (DISM/FT/3A/62)</p>
	</footer>
	
	<script type="text/javascript">
	function confirmlogout() {
		var result = confirm("Are you sure you want to logout?");
		if (result) {
			return true;
		}
		return false;
	}    
	</script>
	   
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="dist/js/bootstrap.min.js"></script>
	</body>
</html>