package getpost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/helloGet")
public class HelloServletGet  extends HttpServlet{

	
	//부모의  service가 요청정보를 확인하고  get => doGet호출   , post => doPost호출하는 역할을 함 
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 		 
		PrintWriter   out  = resp.getWriter();
		out.println(" GET !!! hello servlet");		
	}
}
