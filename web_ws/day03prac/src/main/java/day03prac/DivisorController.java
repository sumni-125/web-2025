package day03prac;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/divisorMvc")
public class DivisorController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String su_ = request.getParameter("su");
		int su = Integer.parseInt(su_);
		
		//요청만득릭
		DivisorService service = new DivisorService();
		ArrayList<Integer> list = service.getDivisor(su);
		
		//응답하기
		request.setAttribute("divisor", list);
		
		request.getRequestDispatcher("WEB-INF/views/divisorView.jsp").forward(request, response);
		
		
		
		
		
	}
}
