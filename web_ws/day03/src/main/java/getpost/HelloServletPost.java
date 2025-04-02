package getpost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloPost")
public class HelloServletPost extends HttpServlet {

	
	//sevice매서드가 요청정보를 확인하고 post -> doPost를 호출함  (  doPost 재정의)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		PrintWriter   out  = resp.getWriter();
		out.println(" POST  !! hello servlet");
		
	}
	
	/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter   out  = resp.getWriter();
		out.println(" get ~~~~ !! hello servlet");
	}
	
	*/
	
}
