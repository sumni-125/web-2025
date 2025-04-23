package tripMate.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tripMate.model.BlogImgDTO;
import tripMate.service.BlogImgService;

@WebServlet("/img")
public class BlogImgServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		BlogImgService sc = new BlogImgService();
		ArrayList<BlogImgDTO>  list = sc.getImgList();
		
		req.setAttribute("img", list);
		
		req.getRequestDispatcher("WEB-INF/views/imgtest.jsp").forward(req, resp);
	}
	
	
}
