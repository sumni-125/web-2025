package day07Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/result")
public class ServeyResult extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//
		req.setCharacterEncoding("utf-8");//한글이 깨지지 않도록 설정
		
		String flower = req.getParameter("flower");
		
		HttpSession session = req.getSession();
		session.setAttribute("flower", flower);
		
		//result view
		req.getRequestDispatcher("WEB-INF/views/result.jsp").forward(req, resp);
		
	}
}
