package gameDBWeb;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gameRecommend") //url 패턴
public class GameRecommendServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GameService s = new GameService();
		
		ArrayList<GameWeb> list = s.getRecommendList();
		
		ArrayList<GameWeb> strList = s.getStrList();
		
		ArrayList<GameWeb> dexList = s.getDexList();
		
		ArrayList<GameWeb> intList = s.getIntList();

		request.setAttribute("list", list);	
		request.setAttribute("strList", strList);		
		request.setAttribute("dexList", dexList);		
		request.setAttribute("intList", intList);
		request.getRequestDispatcher("WEB-INF/views/gameRecommend.jsp").forward(request, response);
	}
	
	
	

}
