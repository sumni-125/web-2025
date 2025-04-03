package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원삭제하는서비스

//컨트롤러	:서블릿 get
//모델	:데이터베이스 회원정보 삭제
//뷰		:삭제되었다 뷰 

@WebServlet("/acornDelete")
public class AcornDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//사용자정의
		//쿼리스트링 ?id=
		
		String id = req.getParameter("id");
		
		req.getRequestDispatcher("WEB-INF/views/deleteOK.jsp").forward(req, resp);
		
		
		AcornService s = new AcornService();
		s.deleteMember(id);
		
	}
}
