package survey;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/result")
public class SurveyResult  extends HttpServlet{
	
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
 	 
	 String flower = req.getParameter("flower");
	
	 
	 //세션에 저장하기
	 HttpSession session  =req.getSession();
	 session.setAttribute("flower", flower); 
	 

	 
	 req.getRequestDispatcher("WEB-INF/views/result.jsp").forward(req, resp);
	 
 }
}
