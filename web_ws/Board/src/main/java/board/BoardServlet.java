package board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/boardmain")
public class BoardServlet extends HttpServlet{
	
	ArrayList<BoardPost> posts = new ArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("posts", posts);
		
		req.getRequestDispatcher("WEB-INF/views/board.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 req.setCharacterEncoding("utf-8");
		
		 HttpSession session = req.getSession();
		 session.setAttribute("id","id");			

		 String writer = (String) session.getAttribute("id");
		 
		 String title = req.getParameter("title");
		 String content = req.getParameter("content");
		 
		 String deleteId = req.getParameter("deleteId");
		 
		 if (deleteId != null) {
		     int id = Integer.parseInt(deleteId);
		     for (int i = 0; i < posts.size(); i++) {
		    	    if (posts.get(i).getPostId() == id) {
		    	        posts.remove(i);
		    	        break;
		    	    }
		    	}
		     resp.sendRedirect("boardmain");
		     return;
		 }

		 
		 BoardPost post = new BoardPost(title, content, writer);
		 posts.add(post);
		 
		 
		 resp.sendRedirect("boardmain");
		
		
		
		
		
	}
	
	
	
	
	
}
