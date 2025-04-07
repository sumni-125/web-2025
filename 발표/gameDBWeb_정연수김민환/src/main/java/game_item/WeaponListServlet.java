package game_item;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WeaponListServlet")
public class WeaponListServlet extends HttpServlet {
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ItemService s = new ItemService();
		ArrayList<MiscItem> list = s.getMiscItems();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/MiscItemList.jsp").forward(req, resp);
	
	}
        
}
