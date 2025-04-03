package acorn;

 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delete")
public class DeleteServlet   extends HttpServlet{

 
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 				
		String id  =request.getParameter("id");
		 
		
		AcornService service = new AcornService();
		service.deleteMember(id );		
		
		//
		request.getRequestDispatcher("WEB-INF/views/updateok.jsp").forward(request, response);
		
	}
	
}
