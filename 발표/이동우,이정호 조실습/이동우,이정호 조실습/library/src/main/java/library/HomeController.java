package library;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 메인페이지를 제공하는 서비스


// 컨트롤러 : 컨트롤러
// 뷰 : 메인화면

@WebServlet("/libraryhome")
public class HomeController extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LibraryService s = new LibraryService();
		ArrayList<Library> list = s.getLibraryList();
		
		
		req.setAttribute("library", list);
			
		req.getRequestDispatcher("WEB-INF/views/reservation.jsp").forward(req, resp);
	}
	
	
	
}
