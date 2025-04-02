package 박수경;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sayHi")
public class HiController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		HiService hs = new HiService();
		String hi = hs.hi();
		
		
		request.setAttribute("hi", hi);
		request.setAttribute("user", user);
		request.getRequestDispatcher("WEB-INF/views/hiView_박수경.jsp").forward(request, response);
	}
}
