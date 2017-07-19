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
 * Servlet implementation class RetrieveStudentUniqueCodeServlet
 */
@WebServlet("/RetrieveStudentUniqueCodeServlet")
public class RetrieveStudentUniqueCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveStudentUniqueCodeServlet() {
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
		String uCode = request.getParameter("uCode");
		String adminNo = request.getParameter("adminNo");
		
		StudentManager db = new StudentManager();

		ArrayList<StudentDetails> Student = db.retrieveStudent(adminNo);

		HttpSession session = request.getSession();
		
		for (StudentDetails student: Student) {
			if (student.getUniqueCode().equals(uCode)) {
				response.sendRedirect("fileupload.jsp");
				return;
			}
			else {
				request.setAttribute("errorMessage", "Invalid Unique Code");
				request.getRequestDispatcher("submission.jsp").forward(request, response);
				return;
			}
		}
	}

}
