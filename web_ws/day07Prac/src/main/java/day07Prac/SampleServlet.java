package day07Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sample")
public class SampleServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터*모ㅗ델
		String data = "sample data";
		
		//request저장소사용
		//하나의 요청이 생기면 만들어지고 응답되면 소멸됨
		//req.setAttribute("data", data);
		
		//data를 다른 요청에서도 계속 사용하고싶다면?
		//세션저장소를 사용할 수 있다
		HttpSession session = req.getSession();	//각 사용자에 맞는 저장소를 제공한다
		
		//
		//view응답
		//
		
		req.getRequestDispatcher("WEB-INF/views/sampleView.jsp").forward(req, resp);
		
		
		
	}
	
}
