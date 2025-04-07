package 실습;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reviewUpdate")
public class ReviewUpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id"); // ← 수정할 리뷰 ID
		String content = req.getParameter("content");
		String rating = req.getParameter("rating");
		
		ReviewService service = new ReviewService();
		
		service.updateReview(content, rating, id);
		
		resp.sendRedirect("/project/reviewList");
	}
}
