package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서비스
//회원아이디 => 회원정보 제공하기

//get

//컨트롤러 : 서블릿
//모델 : 회원정보 한개
//뷰 : 회원정보 화면

@WebServlet("/acornOne")
public class AcornOneServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//사용자 정보 가져오기	(쿼리스트링 ?id=	)
		
		String id = req.getParameter("id");
		
		//모델
		AcornService a =new AcornService(); 
		Acorn acorn = a.getMemberInfo(id);
		//응답
		
		req.setAttribute("info", acorn);
		req.getRequestDispatcher("WEB-INF/views/acornInfo.jsp").forward(req, resp);
		
	}
	
}
