package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstl3")
public class Jstl3  extends HttpServlet	{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int kor=90;    // int    <- > Integer
		
		
		request.setAttribute("kor", kor);
		
		request.getRequestDispatcher("WEB-INF/views/jstl3.jsp").forward(request, response);
		
		
	}
}
