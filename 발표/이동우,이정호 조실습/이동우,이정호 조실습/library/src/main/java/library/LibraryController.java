package library;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 테이블 조회
@WebServlet("/libaryseat")
public class LibraryController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LibraryService s = new LibraryService();
		ArrayList<Library> list = s.getLibraryList();
		
		req.setAttribute("library", list);
		
	
		req.getRequestDispatcher("WEB-INF/views/librarySeat.jsp").forward(req, resp);
	}
	

	
}
