package player;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/playerslist")
public class PlayerListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String keyword = req.getParameter("keyword");

	    PlayerService service = new PlayerService();
	    ArrayList<Player> list;

	    if (keyword != null && !keyword.trim().isEmpty()) {
	        list = service.searchPlayerByKeyword(keyword);
	    } else {
	        list = service.getPlayerListAll();
	    }

	    req.setAttribute("list", list);
	    req.getRequestDispatcher("WEB-INF/views/playerList.jsp").forward(req, resp);
	}

}
