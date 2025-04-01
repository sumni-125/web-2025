package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿으로 등록함, 서블릿 이름 정의 :  이 이름을  클라이언트가   요청함
@WebServlet("/mapping")
public class 요청에대한응답서블릿url매핑  extends HttpServlet{
	
	
	 
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		 System.out.println(" hello servlet");
		  
		 resp.setCharacterEncoding("utf-8");
		 resp.setContentType("text/html;charset=utf-8");
		 
		 //응답을 보내기 위한 스트림 얻어오기		 
		 PrintWriter out  =  resp.getWriter();
		 
		 //보내는 스트림에 응답할 내용을 흘려보낸다 
		 out.println( "서버는 클라이언트가 요청해야만 응답합니다 <br>");
		 out.println( "이떼 서버쪽의 작은프로그램(서블릿)을 요청할 때 (호출할때 ) 사용하는 이름이 mapping 이름이다 <br>");
		 out.println( "서버가 제공하는 내용에 맞게 매핑이름을 정하면 된다.  주문->order, 상세 ->detail");
		 
		
	}

}
