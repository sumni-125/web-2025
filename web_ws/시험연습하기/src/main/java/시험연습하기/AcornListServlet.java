package 시험연습하기;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/acornlist")
public class AcornListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Service s = new Service();
		ArrayList<Acorn> list = new ArrayList<Acorn>();
		
		list = s.selectAll();
		
		req.setAttribute("acornList", list);
		
		req.getRequestDispatcher("WEB-INF/views/acornList.jsp").forward(req, resp);		
	}
}
