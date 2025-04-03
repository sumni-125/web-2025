package 입력정보가져오기;

 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regSelect")
public class RegSelectServlet  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		
		 //등록화면
		
		req.getRequestDispatcher("WEB-INF/views/regSelect.jsp").forward(req, resp);
		
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		//등록버튼 누르면
		
		String kind = req.getParameter("kind");
		resp.getWriter().println( kind);

	}

}
