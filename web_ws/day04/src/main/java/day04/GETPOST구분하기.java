package day04;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class GETPOST구분하기  extends HttpServlet{	 
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 	
		 
		
		//request 객체로 부터  getMethod()정보로 GET, POST 요청인지 확인할 수 있따
		
		String method = req.getMethod();	  
		  if( method.equals("GET")) {
			   doGet(req, resp);
		  }else {
			   doPost(req, resp);
		  }
	}
	

	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 
			System.out.println( "get");
		}
	
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 
			System.out.println("post");
		}
}
