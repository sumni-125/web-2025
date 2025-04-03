package prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/pracHello3")
public class HelloServletMVC  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		//입력정보 얻기
		
		//필요한 서비스에 대한 데이터를 만들기    ( 순수자바 : POJO) 
		
		//응답뷰  (VIEW  : jsp) 
		
		
		req.getRequestDispatcher("WEB-INF/views/pracHello3.jsp").forward(req, resp);
		
		
	}
}
