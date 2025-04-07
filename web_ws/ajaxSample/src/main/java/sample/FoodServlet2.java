package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/food2")
public class FoodServlet2  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
	 
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");		
		
		Food food = new Food("볶음밥","6000"); 
		JSONObject  o= new JSONObject();
		o.put("name", food.getName());
		o.put("price", food.getPrice());	
		resp.getWriter().println( o);
		
		
		
		
	}

}
