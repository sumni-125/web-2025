package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/el1")
public class El1Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		 
		String result="EL은 좋아요";
		request.setAttribute("data", result);		
		
		request.getRequestDispatcher("WEB-INF/views/el1.jsp").forward(request, response);
		
	}

}
