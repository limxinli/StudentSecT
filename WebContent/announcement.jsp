<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,db.*,controller.*,model.*,java.util.Date,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Secured-T</title>
	
	    <!-- Bootstrap core CSS -->
	    <link href="dist/css/bootstrap.min.css" rel="stylesheet">
	
	    <!-- Custom styles for this template -->
	    <link href="css/announcement.css" rel="stylesheet">
	    
	    <!-- Favicon -->
	    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
		<link rel="icon" href="images/favicon.ico" type="image/x-icon">
	
	</head>

	<body>
		 <%
		 ArrayList<AnnouncementDetails> retrieveAnnouncement = (ArrayList<AnnouncementDetails>)session.getAttribute("announcement");
				
		 if (retrieveAnnouncement != null) {
			for(AnnouncementDetails announcement:retrieveAnnouncement) {

		%>
	    <div class="container">
	      <div class="header clearfix">
	        <nav>
	          <ul class="nav nav-pills pull-right">
	            <li role="presentation" class="active"><a href="RetrieveAnnouncementServlet?examCode=<%=announcement.getExamCode()%>">Announcements</a></li>
	            <li role="presentation"><a href="downloadable.jsp">Downloadables</a></li>
	            <li role="presentation"><a href="submission.jsp">Submissions</a></li>
	          </ul>
	        </nav>
	        <h3 class="text-muted"><img src="images/logo.png" alt="Secured-T logo" id="logo">Secured-T</h3>
	      </div>
		  <h3>
		  	<%=announcement.getModuleCode()%> -
			<%=announcement.getModuleName()%>
		  </h3>
		  <%
					break;}
		  %>
	      <div class="row marketing">
			<div class="announcement">
			  <h2 id="announcement_title">Announcements</h2>
			  		<%
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
	
	      <footer class="footer">
	        <p>&copy; 2017 Singapore Polytechnic</p>
	      </footer>
	
	    </div>
	
	</body>
</html>