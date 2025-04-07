package 실습;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reviewOne")
public class ReviewOneServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		ReviewService service = new ReviewService();
		Review review = service.getOneReview(id);
		
		req.setAttribute("review", review);
		
		req.getRequestDispatcher("WEB-INF/views/updateReview.jsp").forward(req, resp);
	}
}
