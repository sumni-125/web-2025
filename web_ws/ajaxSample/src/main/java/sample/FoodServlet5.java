package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

@WebServlet("/food5")
public class FoodServlet5  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");	
		
		FoodService service = new FoodService();
		JSONArray foodlist= service.getFoodRealList();
		resp.getWriter().println( foodlist); 
		
		
	}

}
