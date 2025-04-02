
package mvc실습하기;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SquidGameMVC")
public class SquidGameController extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SquidGameService sgServ = new SquidGameService();
		
		ArrayList<SquidGameService> list = sgServ.sgList();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/squidForm.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		SquidGameService sgServ = new SquidGameService();
		
		ArrayList<SquidGameService> list = sgServ.searchId(id);
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/squidResult.jsp").forward(req, resp);
		
		
	}
	
}
