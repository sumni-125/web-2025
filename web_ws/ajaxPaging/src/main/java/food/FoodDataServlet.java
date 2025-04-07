package food;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

//@WebServlet("/foodPage")
public class FoodDataServlet  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int currentPage=1;
		String page = req.getParameter("page");
		if( page!=null) currentPage= Integer.parseInt(page);
		 
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");	
		
		
	 
		FoodService service = new FoodService();
		JSONObject  result= service.getFoodRealListPaging(currentPage);
		resp.getWriter().println( result); 
		
		 
		
		
		
	}

}
