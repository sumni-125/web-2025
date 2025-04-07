package library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/librarycancle")
public class LIbraryCancleServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seat_id = req.getParameter("id");
		
		System.out.println("전달받은 seat_id = " + seat_id);  // << 로그 확인
		
		req.setAttribute("library", seat_id);

		LibraryService s = new LibraryService();
		s.cancelSeat(seat_id);
		
		

		
		
		req.setAttribute("msg", "취소가 완료되었습니다.");
//		req.setAttribute("library", s.getLibraryList());  // 예약 현황 갱신
		req.getRequestDispatcher("WEB-INF/views/ddd.jsp").forward(req, resp);
		
	}
	
}
