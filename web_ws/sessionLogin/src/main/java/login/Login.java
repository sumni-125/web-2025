package login;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);		
	}
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		 //
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// LoginService service = new LoginService( );
		// boolean result  =  service.userCheck(id, pwd);
		
		boolean result=true;
		//회원인경우 , 세션에 아이디저장 , 주문정보화면 (뷰)  포워드
		//1. session 저장소 얻어오기 => 사용자에 대한 저장소 얻어오기 세션 id값으로 얻어온다

		//세션id=> 서버에 최초로 접속하면 서버가 발급하는 키

		//2. 저장하기
		//심플하게 테스트하기 위해 아이디와 비번이 같으면 회원으로 정함 !!
		
		result =  (id.equals(pwd))?true:false;
		if(result) {
	     	//회원인경우 session저장소에 저장하기
			HttpSession session  = request.getSession();
			session.setAttribute("id", id);			
			
			//메인페이지가 요청되게 하기
			response.sendRedirect("/sessionLogin/main.do");		 			
		
		}
		else {		   
			
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);			
			
		}
	}

}
