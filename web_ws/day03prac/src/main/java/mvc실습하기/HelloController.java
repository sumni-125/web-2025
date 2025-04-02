package mvc실습하기;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HelloService h = new HelloService();
		String st = h.hello();
		
		request.setAttribute("st",st);
		
		request.getRequestDispatcher("WEB-INF/views/helloView.jsp").forward(request, response);
		
	}
}
