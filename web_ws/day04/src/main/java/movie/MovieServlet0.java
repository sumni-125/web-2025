package movie;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//영화조회 서비스


@WebServlet("/movieAll1")
public class MovieServlet0  extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 
 	
	 
		req.getRequestDispatcher("WEB-INF/views/movieList0.jsp").forward(req, resp);
		
		 
		 
		
	}
}
