package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		boolean result;
		
		Service s = new Service();
		Member m = s.selectMember(id);
		
		if(id.equals(m.getId()) && pw.equals(m.getPw())) {
			result=true;
		}else {
			result=false;
		}
		
		if(result==true) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			
			resp.sendRedirect("/Board/main");
		}else {
			System.out.println(id+pw);
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		}
		
		
	}
	
}
