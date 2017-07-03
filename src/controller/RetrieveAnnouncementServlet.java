package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AnnouncementDetails;
import model.AnnouncementManager;
import model.AssessmentDetails;

/**
 * Servlet implementation class RetrieveAnnouncementServlet
 */
@WebServlet("/RetrieveAnnouncementServlet")
public class RetrieveAnnouncementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveAnnouncementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String examCode = request.getParameter("examCode");
		
		AnnouncementManager db = new AnnouncementManager();

		ArrayList<AnnouncementDetails> Announcement = db.retrieveAnnouncement(examCode);

		HttpSession session = request.getSession();
		
		session.removeAttribute("REFRESH");

		session.setAttribute("announcement", Announcement);
		response.sendRedirect("announcement.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
