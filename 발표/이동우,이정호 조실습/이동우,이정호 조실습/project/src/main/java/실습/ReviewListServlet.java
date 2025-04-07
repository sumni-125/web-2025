package 실습;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reviewList")
public class ReviewListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReviewService service = new ReviewService();
		ArrayList<Review> list = service.getReview();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/reviewList.jsp").forward(req, resp);
	}
}
