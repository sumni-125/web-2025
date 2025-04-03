package prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// hello servlet    제공하는 서비스 만들기   => GET  요청 


@WebServlet("/pracHello2")
public class HelloServlet2  extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		PrintWriter   out  = resp.getWriter();
		out.print("hello servlet");
	}
}
