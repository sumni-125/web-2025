package library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/libraryUpdate")
public class LibraryUpdateServlet extends HttpServlet {
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		req.getRequestDispatcher("WEB-INF/views/reservation.jsp").forward(req, resp);
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String seat_id = req.getParameter("id");
		
		 System.out.println("전달받은 seat_id = " + seat_id);  // << 로그 확인
		
		
		req.setAttribute("library", seat_id);
		
		LibraryService s = new LibraryService();
		s.modifySeat(seat_id);
		
		
		req.setAttribute("msg", "예약이 완료되었습니다!");
		req.getRequestDispatcher("WEB-INF/views/reservelist.jsp").forward(req, resp);
		
		
	}
	
}
