package day07Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servey2")
public class SurveyServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String animal=req.getParameter("animal");
		
		//세션저장소 저장하기
		
		//1.세션 얻어오기
		HttpSession session = req.getSession();
		//2.세션에 저장하기
		session.setAttribute("animal", animal);
		
		req.getRequestDispatcher("WEB-INF/views/serveyView2.jsp").forward(req, resp);
		
	}
}
