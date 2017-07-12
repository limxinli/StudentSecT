package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DomainDetails;
import model.DomainManager;

/**
 * Servlet implementation class RetrieveDomainServlet
 */
@WebServlet("/RetrieveDomainServlet")
public class RetrieveDomainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveDomainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String assessmentID = request.getParameter("assessmentID");
		
		DomainManager db = new DomainManager();

		ArrayList<DomainDetails> Domain = db.retrieveDomain(assessmentID);

		HttpSession session = request.getSession();
		
		session.removeAttribute("REFRESH");

		session.setAttribute("domain", Domain);
		response.sendRedirect("announcement.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
