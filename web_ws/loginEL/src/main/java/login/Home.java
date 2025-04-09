package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		//req.getRequestDispatcher("WEB-INF/views/home.jsp").forward(req, resp);
		//req.getRequestDispatcher("WEB-INF/views/home2.jsp").forward(req, resp);
		// req.getRequestDispatcher("WEB-INF/views/home3.jsp").forward(req, resp);
		// req.getRequestDispatcher("WEB-INF/views/hometest.jsp").forward(req, resp);
		req.getRequestDispatcher("WEB-INF/views/homePrac.jsp").forward(req, resp);
	}
}
