package prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/pracModel")
public class ModelServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		
		String[] likes= {  "아이스아메리카노" ,"사과"  ,"걷기"};		
		req.setAttribute("like", likes);
		
		req.getRequestDispatcher("WEB-INF/views/modelView.jsp").forward(req, resp);
	}

}
