package day07Prac.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logOut")
public class LogOutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//세션 얻어오기
		//세션저장소 삭제하기
		
		HttpSession session = req.getSession();
		session.invalidate();	//사용자에 대한 세션 저장소에 있는 값 모두 삭제하기
		
		// 하나만 지우고싶을때
		//session.removeAttribute("키"); 
		
		resp.sendRedirect("/day07Prac/main");
		
	}
}
