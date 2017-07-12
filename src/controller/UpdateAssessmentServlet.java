package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentInfoManager;

/**
 * Servlet implementation class UpdateAssessmentServlet
 */
@WebServlet("/UpdateAssessmentServlet")
public class UpdateAssessmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAssessmentServlet() {
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
		String examCode = request.getParameter("examCode");
		String adminNo = request.getParameter("adminNo");
		
		StudentInfoManager db = new StudentInfoManager();
		
		db.updateStudentInfo(examCode, adminNo);

		response.sendRedirect("RetrieveAssessmentServlet?examCode="+examCode);

	}

}
