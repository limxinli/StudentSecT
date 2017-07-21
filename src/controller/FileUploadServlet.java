package controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.StudentSubmissionDetails;
import model.StudentSubmissionManager;

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
		String adminNo = request.getParameter("adminNo");
		
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();
	   
	    StudentSubmissionManager db = new StudentSubmissionManager();
	    
	    ArrayList<StudentSubmissionDetails> StudentSub = db.retrieveStudentSubmission(adminNo);
	    
	    for (StudentSubmissionDetails student: StudentSub) {
	    	int version = student.getVersion();
	    	version++;
	    	
		    String[] fileNameSplits = fileName.split("\\.");
		    // extension is assumed to be the last part
		    int extensionIndex = fileNameSplits.length - 1;
		    //filename with version number
		    fileName = fileNameSplits[0]+"_"+version+"."+fileNameSplits[extensionIndex];
		    
	    	// /home/securedt/submission/
			filePart.write("C:/temp/"+fileName);
			db.updateStudentSubmission(fileName, version, adminNo);
			
			request.setAttribute("cfmMessage", "You have submitted "+version+" time(s).");
			request.getRequestDispatcher("submission.jsp").forward(request, response);
			return;	
	    }
	
	}

}
