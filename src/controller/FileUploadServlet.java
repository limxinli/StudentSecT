package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.tools.FileObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
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
		try {
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multifiles = sf.parseRequest(request);

			for (FileItem item : multifiles) {
				item.write(new File("C:/temp/"+ FilenameUtils.getName(item.getName())));
			}
			
			response.sendRedirect("submission.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}