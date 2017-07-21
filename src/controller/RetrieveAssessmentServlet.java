package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AssessmentDetails;
import model.AssessmentManager;

/**
 * Servlet implementation class RetrieveAssessmentServlet
 */
@WebServlet("/RetrieveAssessmentServlet")
public class RetrieveAssessmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveAssessmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String examCode = request.getParameter("examCode");
		
		AssessmentManager db = new AssessmentManager();

		ArrayList<AssessmentDetails> Assessment = db.retrieveAssessment(examCode);

		HttpSession session = request.getSession();
			
		for(AssessmentDetails assessment:Assessment) {
			session.setAttribute("LOGIN", "TRUE");
			session.setAttribute("assessment", Assessment);
			response.sendRedirect("RetrieveAnnouncementServlet?assessmentID="+assessment.getId());
			return;
		}
		session.setAttribute("LOGIN", "FALSE");
		request.setAttribute("errorMessage", "Invalid Exam Code");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
