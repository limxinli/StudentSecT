package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StudentSubmissionDetails;
import model.StudentSubmissionManager;

/**
 * Servlet implementation class InsertStudentSubmissionServlet
 */
@WebServlet("/InsertStudentSubmissionServlet")
public class InsertStudentSubmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudentSubmissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminNo = request.getParameter("adminNo");
		String uCode = request.getParameter("uCode");
		String assessmentID = request.getParameter("assessmentID");
		
		StudentSubmissionManager db = new StudentSubmissionManager();
		
		int result = db.insertStudentSubmission(adminNo, uCode);
		// check if insert is successful.
		if (result == 1) {
			response.sendRedirect("RetrieveStudentSubmissionServlet?adminNo="+adminNo+"&uCode="+uCode);
		} else {		
			response.sendRedirect("RetrieveAnnouncementServlet?assessmentID="+assessmentID);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
