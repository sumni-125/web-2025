package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿으로 등록함, 서블릿 이름 정의 :  이 이름을  클라이언트가   요청함
@WebServlet("/getpost")
public class 사용자요청GetPost구분하여응답하기  extends HttpServlet{
	 
	
		//부모의 service는 요청매서드에 따라 doGet 또는 doPost 호출한다
	    // Get요청과 Post요청에 각 각 응답할 수 있다 
	  
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 
			
			 resp.setCharacterEncoding("utf-8");
			 resp.setContentType("text/html;charset=utf-8");
			 //응답을 보내기 위한 스트림 얻어오기		 
			 PrintWriter out  =  resp.getWriter();
			 out.println( "get 요청임  !!!!!!");
			
			
		}
		
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 resp.setCharacterEncoding("utf-8");
			 resp.setContentType("text/html;charset=utf-8");
			 //응답을 보내기 위한 스트림 얻어오기		 
			 PrintWriter out  =  resp.getWriter();
			 out.println( "post 요청임  !!!!!");
			 
		}
}
