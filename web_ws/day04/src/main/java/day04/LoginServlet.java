package day04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		System.out.println("get");
		String  method = request.getMethod();
		System.out.println( method);
		//로그인화면을 응답		
		RequestDispatcher r=request.getRequestDispatcher("WEB-INF/views/login.jsp");
		r.forward(request, response);
		
	}
	
	 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String method = request.getMethod();
		 System.out.println(method);
		 System.out.println("post");
		 
		 
		 String userid =request.getParameter("userid");
		 String userpw= request.getParameter("userpw");
		 
		 System.out.println( userid);		 
		 System.out.println( userpw);
		 
		 
		 //로그인, 비번을 가지고 데이터베이스 정보를 확인한후 정상로그인후 메인페이지,
		 //아이디 비번 문제 있는 경우 다시 로그인화면으로 응답할 수 있다.		 
		 //데이터베이스에서 아이디 비번으로 회원인지 확인 하는 코드를 작성한다 => 모델
		 
		 boolean result =true;		 
		 if( result ){
			 //정상적이면  main페이지가 응답될 수 있도록 한다.
			 System.out.println("메인페이지");
			 response.sendRedirect("/day04/home");
			  
			 
		 }else {
			 //비정상적인 경우 로그인페이지가 응답될 수 있도록 한다.
			 
			 System.out.println("다시 로그인");
			 request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
			  
		 } 
		 
	}
	
}
