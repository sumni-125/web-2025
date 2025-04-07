package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;


@WebServlet("/reviewList")
public class ReviewListServlet   extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter  out = response.getWriter();	 
		
		ReviewService service = new ReviewService();
		JSONArray  arr  =service.getReviewJsonArray();		
		out.print( arr);
		
		
	     //String  jsonString  =service.getFoodJsonArray2();		
		 //out.print( jsonString);
				
	 
		
	}
}
