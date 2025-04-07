package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteReview")
public class ReviewDeleteServlet  extends HttpServlet {
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out  = response.getWriter(); 		
		
		String id  =request.getParameter("id") ;	 
		
		System.out.println(  id);
		ReviewService service = new ReviewService();
		int cnt= service.cancleDelete(id);
		 //0 실패 , 1:성공	 		
		out.print(cnt);
	}

}
