package day03prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bmiService")
public class BMIController extends HttpServlet {
	
	
	//사용자가 요청하는 방법에 따라 doGet이 호출되거나 doPost가 호출될 수 있다
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/bmiForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String height_ = req.getParameter("height");
		String weight_ = req.getParameter("weight");
		
		double height = Double.parseDouble(height_);
		double weight = Double.parseDouble(weight_);
		
		System.out.println(height+"\n"+weight);
		
		//응답
		
		String result = "정상체중";
		
		req.setAttribute("result", result);
		req.getRequestDispatcher("WEB-INF/views/bmiResult.jsp").forward(req, resp);
		
	}
	
}
