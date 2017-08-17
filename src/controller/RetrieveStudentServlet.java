package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StudentDetails;
import model.StudentManager;

/**
 * Servlet implementation class RetrieveStudentServlet
 */
@WebServlet("/RetrieveStudentServlet")
public class RetrieveStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String examCode = request.getParameter("examCode");
		String adminNo = request.getParameter("adminNo");
		int tableNo = Integer.parseInt(request.getParameter("tableNo"));
		
		StudentManager db = new StudentManager();

		ArrayList<StudentDetails> Student = db.retrieveStudent(adminNo);

		HttpSession session = request.getSession();
		
		for (StudentDetails student: Student) {
			if (student.getLogin() == 1) {
				request.setAttribute("errorMessage", "The admission number has been logged in.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			else if (student.getDisconnected() == 1) {
				request.setAttribute("errorMessage", "You are not allowed to log in, you have been disconnected.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			else{
				db.updateStudentInfo(tableNo, examCode, student.getId());
				ArrayList<StudentDetails> StudentById = db.retrieveStudent(student.getId());
				session.setAttribute("studentById", StudentById);
				response.sendRedirect("RetrieveAnnouncementServlet?assessmentID="+student.getAssessmentId());
				return;
			}
		}
		request.setAttribute("errorMessage", "You need to enter your information in CSI before you can log in here.");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
