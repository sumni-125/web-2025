package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/acorn")
public class AcornOneServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id  =request.getParameter("id");
		
		AcornService service  = new AcornService();
		Acorn acorn =service.getMember(id);		
		
		request.setAttribute("acorn", acorn);
		
		request.getRequestDispatcher("WEB-INF/views/member.jsp").forward(request, response);
	}
	
}
