package day07Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sample2")
public class SampleServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//이전 요청에서 request 에 저장한 값은 다른 요청에서 사용할 수 없다
		//이유는 요청이 들어오면 새로운 request, response 가 생성된다.
		
		// String data = (String) req.getAttribute("data");
		// System.out.println(data);

		// 세션 저장소에서 data값 꺼내기

		HttpSession session = req.getSession(); // 하나의 사용자가 사용하는 유지기간이 더 긴 저장소
		String data = (String) session.getAttribute("data");

	}

}
