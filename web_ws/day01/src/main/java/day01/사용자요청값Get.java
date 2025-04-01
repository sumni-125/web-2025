package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿으로 등록함,
//서블릿 이름 정의 :  이 이름을  클라이언트가   요청함  ( url매핑 이름)
@WebServlet("/getreq")
public class 사용자요청값Get  extends HttpServlet{
	 
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		 System.out.println(" hello servlet");
	  
		 resp.setCharacterEncoding("utf-8");
		 resp.setContentType("text/html;charset=utf-8");
		 //응답을 보내기 위한 스트림 얻어오기		 
		 PrintWriter out  =  resp.getWriter();
		 
		 //보내는 스트림에 응답할 내용을 흘려보낸다 
		 
		 
		 //클라이언트의 쿼리스트링 가져오기
		 //클라이언트에서 요청이름?키=값 으로 전달함
		 String cnt_ = req.getParameter("cnt");
		 int cnt=0;
		 if( cnt_ !=  null) {
			 cnt= Integer.parseInt( cnt_);
			 
				
			 for(int i=1; i<=cnt; i++) {
				  out.println("hi^^");
			 }
			 
			 
		 }else {  
			 
			 // null이면
			
			 for(int i=1; i<=3; i++) {
				  out.println("hi");
			 }
			 
		 }
		 
	}

}
