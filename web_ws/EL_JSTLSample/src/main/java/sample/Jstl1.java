package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jstl1")
public class Jstl1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		
		
		String[] music= {"밤양갱" , "ak47" , "우리들의블루스" };		
		request.setAttribute("music", music);
		request.getRequestDispatcher("WEB-INF/views/jstl1.jsp").forward(request, response);
		
	}
}
