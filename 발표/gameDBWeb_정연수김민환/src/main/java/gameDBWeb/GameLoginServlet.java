package gameDBWeb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gameLogin") //url 패턴
public class GameLoginServlet extends HttpServlet {

	//로그인 서블릿
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/views/gameLogin.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		GameService s = new GameService();

		int result = s.login(id, pw);

		if (result == 1) {
			request.getSession().setAttribute("id", id);
			response.sendRedirect(request.getContextPath() + "/index");
			System.out.println("로그인 성공");
		} else {
			response.sendRedirect(request.getContextPath() + "/gameLogin");
			System.out.println("로그인 실패");
		}
	}
	
	
	

}
