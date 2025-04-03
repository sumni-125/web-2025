package prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/pracHello5")
public class HelloServletMVC3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		HelloService  service  = new HelloService();
		String data  =service.getData();
		
		//모델 저장
		req.setAttribute("data", data);
		
		req.getRequestDispatcher("WEB-INF/views/pracHello5.jsp").forward(req, resp) ;
		
	}
}
