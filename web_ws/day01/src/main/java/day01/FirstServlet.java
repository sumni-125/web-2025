package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//###############################################
//내가 만든 클래스가  Servlet이 되기 위해 해야 할 일
//1. HttpServlet상속받기
//2. 톰캣은 서블릿의 약속된 매서드 service 호출한다
//3. 응답할 내용을  service에 오버라이딩 해야 하다
//4. 클라이언트에 의해 호출되기 위해서 톰캣(웹서버)에 서블릿등록 (등록시 호출될 이름 정한다) url 매핑



public class FirstServlet   extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 
		System.out.println("서버가 응답합니다.");		
		
		PrintWriter out  = resp.getWriter();
		out.println( "hi2 ^^^");
		
		
	}
}
