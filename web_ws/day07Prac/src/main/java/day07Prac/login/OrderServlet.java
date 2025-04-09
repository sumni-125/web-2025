package day07Prac.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인 한 회원만 이 서비스를 제공하려고 한다
		//로그인 한 회원 => 주문정보 응답
		//로그인 안한 회원  => 로그인 서비스가 요청될 수 있도록  sendRedirect
		
		//세션에 저장한 로그인 정보 얻어와서 로그인 여부를 확인 할 수 있다
		
		HttpSession session = req.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		if(loginId != null) {
			
		
		
		//모델(주문정보)
		
		//모델얻어오기
		//모델저장하기
		
		String item ="티셔츠 25000원";
		
		req.setAttribute("item", item);
		
		req.getRequestDispatcher("WEB-INF/views/order.jsp").forward(req, resp);
		}else {
			//로그인 하지 않으면 로그인 재요청
			resp.sendRedirect("/day07Prac/login");
			
		}
		
	}
}
