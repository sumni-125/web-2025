package day08Prac.eljstl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ex01")
public class Ex01Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String data ="el연습";
		req.setAttribute("data", data);
		req.getRequestDispatcher("WEB-INF/views/ex01.jsp").forward(req, resp);
		
	}
}
