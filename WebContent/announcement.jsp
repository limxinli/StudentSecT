<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,db.*,controller.*,model.*,java.util.Date,java.text.*"%>
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
				
				//When student click the refresh button in browser, it goes through the servlet
				if(session.getAttribute("REFRESH")!= null){ %>
					<script type="text/javascript">
		            	window.location.href = "RetrieveAnnouncementServlet?assessmentID=<%=assessment.getId()%>"
		        	</script>
		        <%
				}
				else{    
					session.setAttribute("REFRESH","TRUE");
				}

		%>
	    <div class="container">
	      <div class="header clearfix">
	        <nav>
	          <ul class="nav nav-pills pull-right">
	            <li role="presentation" class="active" id="notif"><a href="RetrieveAssessmentServlet?examCode=<%=assessment.getExamCode()%>">Announcements</a></li>
	<% 
		 ArrayList<StudentDetails> retrieveStudent = (ArrayList<StudentDetails>)session.getAttribute("student");
				
		 if (retrieveStudent != null) {
			for(StudentDetails student:retrieveStudent) {
	%>			
				<li role="presentation"><a href="RetrieveStudentSubmissionServlet?adminNo=<%=student.getAdminNo()%>&uCode=<%=student.getUniqueCode()%>">Submissions</a></li>
				<li role="presentation" id="notif"><a href="LogOutServlet?adminNo=<%=student.getAdminNo()%>" onclick="return confirmlogout()">Logout</a></li>
		<%
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
					break;}
		  %>
	      <div class="row marketing">
			<div class="announcement">
			  <h2 id="announcement_title">Announcements</h2>
			  	<p id="imptmessage">**Important**<br>
					Please note that your activities are being monitored the entire time you are connected to this network. You are only allowed to access the following domains for this assessment:<br></p>	 
					<%
			  		ArrayList<DomainDetails> retrieveDomain = (ArrayList<DomainDetails>)session.getAttribute("domain");
					if (retrieveDomain != null) {
						for(DomainDetails domain:retrieveDomain) {
			  		%>
			  		<p id="domains<%=domain.getId()%>" class="domains"><%=domain.getDomainName()%></p>
			  		<p id="domainName<%=domain.getId()%>" class="domainName"></p>
			  		<script type="text/javascript">
					$(document).ready(function(){
						var domainName = $("#domains<%=domain.getId()%>").html();
						domain = domainName.replace(/\\/g, '');
						$("#domainName<%=domain.getId()%>").prepend("- " + domain);
					});
					</script> 
			  		<%
						}
					 }
					else { %>
					<p>All domains allowed</p>
				  <%
					}
					%>
			  	<p id="imptmessage2">
			  		If you attempt to go to domains not allowed for this assessment, you will be blocked.	
			  	</p>
			  		<%
			  		ArrayList<AnnouncementDetails> retrieveAnnouncement = (ArrayList<AnnouncementDetails>)session.getAttribute("announcement");
			  		for(AnnouncementDetails announcement:retrieveAnnouncement) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			  		%>
					<p id="individual_announcement">
						<%=announcement.getLecturerName()%>
						(<%=dateFormat.format(announcement.getTimestamp())%>)
					</p>
					<p>
						<%=announcement.getAnnouncement()%>
					</p>

			<%
			  		}
				}
				else { %>
					<p>No announcements</p>
			  <%
				}
			  %>
			  
			</div>
	      </div>
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