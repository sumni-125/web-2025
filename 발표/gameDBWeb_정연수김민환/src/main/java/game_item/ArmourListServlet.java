package game_item;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ArmourListServlet")
public class ArmourListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ItemService s = new ItemService();
		ArrayList<Armour> list = s.getArmours();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/armourList.jsp").forward(req, resp);
	
	}
}
