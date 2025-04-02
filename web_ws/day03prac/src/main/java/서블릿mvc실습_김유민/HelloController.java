package 서블릿mvc실습_김유민;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloMvc")
public class HelloController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HelloService service = new HelloService();
		String msg = service.getHello();
		
		req.setAttribute("hello", msg);
		
		req.getRequestDispatcher("WEB-INF/views/helloView_김유민.jsp").forward(req, resp);
	}
	
}
