package gameDBWeb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gameSignUp") //url 패턴
public class GameSignUpServlet extends HttpServlet{
	
	
	
	//
	//로그인
	
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		 req.getRequestDispatcher("WEB-INF/views/signUp.jsp").forward(req, resp);
		 
	}
	
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String account_id = req.getParameter("account_id");
		String account_pw = req.getParameter("account_pw");
		String account_name = req.getParameter("account_name");
		
		
		
		
		GameAccount account = new GameAccount(account_id, account_pw, account_name);
		
		GameService service = new GameService();
		service.registerMember(account);
		
		//req.getRequestDispatcher("WEB-INF/views/gameLogin.jsp").forward(req, resp);
		
		resp.sendRedirect("/gameDBWeb/gameLogin");
	}

}
