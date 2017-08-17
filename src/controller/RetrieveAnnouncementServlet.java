package controller;

import java.io.IOException;
import java.util.ArrayList;

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
		
		String assessmentID = request.getParameter("assessmentID");
		
		AnnouncementManager db = new AnnouncementManager();

		ArrayList<AnnouncementDetails> Announcement = db.retrieveAnnouncement(assessmentID);

		HttpSession session = request.getSession();
		
		if (session.getAttribute("REFRESH") == "TRUE") {
			session.removeAttribute("REFRESH");
		}

		session.setAttribute("announcement", Announcement);
		response.sendRedirect("RetrieveDomainServlet?assessmentID="+assessmentID);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
