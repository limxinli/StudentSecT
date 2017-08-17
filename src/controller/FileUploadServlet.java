package controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.StudentDetails;
import model.StudentManager;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int hiddenID = Integer.parseInt(request.getParameter("hiddenID"));
		
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();
	   
	    StudentManager db = new StudentManager();
	    
	    ArrayList<StudentDetails> StudentSub = db.retrieveStudent(hiddenID);
	    
	    for (StudentDetails student: StudentSub) {
	    	if (!fileName.equals("")) {
	    		int version = student.getVersion();
		    	version++;
		    	
		    	String ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");  
				if (ipAddress == null) {  
				   ipAddress = request.getRemoteAddr();  
				}
				String [] ipSubnet = ipAddress.split("\\.");
				int subnetIndex = ipSubnet.length - 1;
		    	
			    String[] fileNameSplits = fileName.split("\\.");
			    int length = fileNameSplits[0].length();
			    if (length <= 20) {
				    // extension is assumed to be the last part
				    int extensionIndex = fileNameSplits.length - 1;
				    //filename with subnet and adminNo
				    String newFileName = ipSubnet[subnetIndex]+"_"+student.getAdminNo()+"_"+fileNameSplits[0]+"."+fileNameSplits[extensionIndex];
				    
					filePart.write("/home/securedt/submission/"+newFileName);
					db.updateStudentSubmission(newFileName, version, hiddenID);
					
					request.setAttribute("cfmMessage", "You have submitted "+version+" time(s).");
					request.getRequestDispatcher("submission.jsp").forward(request, response);
					return;	
			    }
			    else {
			    	request.setAttribute("cfmMessage", "Please rename your file to less than 20 characters!");
					request.getRequestDispatcher("submission.jsp").forward(request, response);
					return;	
			    }
	    	}
	    	else {
				request.setAttribute("cfmMessage", "Please choose a file.");
				request.getRequestDispatcher("submission.jsp").forward(request, response);
				return;	
	    	}
	    }
	
	}

}
