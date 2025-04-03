package prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/pracHello")
public class HelloServlet  extends HttpServlet{
	/*
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String  method   = req.getMethod() ;  //요청방법 GET, POST
		
		if(method.equals("GET")) {
			
			doGet( req, resp);
		}else if( method.equals("POST")) {
			doPost(req, resp);
		}
		
	}
	
	*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
	 
		
		System.out.println("get");
		
		resp.getWriter().println("get");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("post");
		 
		 resp.getWriter().println( "post");
	}
	

}
