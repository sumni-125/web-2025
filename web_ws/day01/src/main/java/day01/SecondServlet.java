package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//내가 만든 클래스가  Servlet이 되기 위해 해야 할일
//1. HttpServlet상속받기
//2. 톰캣은 서블릿의 약속된 매서드 service 호출한다
//3. 응답할 내용을  service에 오버라이딩 해야 하다
//4. 서버에 서블릿 정보 등록하기 url매핑

@WebServlet("/second")
public class SecondServlet   extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 	
		//클라이언트에게 보내질 출력스트림을 얻어온다		
		PrintWriter out  = resp.getWriter();		
		out.println("hi servlet");
	}
}
