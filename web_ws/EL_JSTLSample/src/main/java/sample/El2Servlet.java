package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/el2")
public class El2Servlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 		
		String result="EL은 저장소에 있는 경우에만 사용할 수 있어요 !";
		request.setAttribute("data2", result);
		request.getRequestDispatcher("WEB-INF/views/el2.jsp").forward(request, response);
	}
}
