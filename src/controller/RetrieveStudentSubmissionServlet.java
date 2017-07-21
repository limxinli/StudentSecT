package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class RetrieveStudentSubmissionServlet
 */
@WebServlet("/RetrieveStudentSubmissionServlet")
public class RetrieveStudentSubmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveStudentSubmissionServlet() {
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
		
		StudentSubmissionManager db = new StudentSubmissionManager();
		
		ArrayList<StudentSubmissionDetails> StudentSub = db.retrieveStudentSubmission(adminNo);

		HttpSession session = request.getSession();
		
		for (StudentSubmissionDetails student: StudentSub) {
			session.setAttribute("studentsub", StudentSub);
			response.sendRedirect("RetrieveStudentUniqueCodeServlet?adminNo="+adminNo+"&uCode="+uCode);
			return;
		}
		response.sendRedirect("InsertStudentSubmissionServlet?adminNo="+adminNo+"&uCode="+uCode);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
