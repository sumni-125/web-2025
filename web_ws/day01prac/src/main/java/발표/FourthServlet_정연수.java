package 발표;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/printStars")
public class FourthServlet_정연수 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		String num_ = request.getParameter("num");
		int num = Integer.parseInt(num_);
		
		
//		for (int i=1; i<=num; i++) {
//			System.out.println("*");
//		}
//		
		PrintWriter out = response.getWriter();
		 out.println("<html>");
		 out.println("<head>");
		 out.println("</head>");
		 out.println("<body>");
		 for (int i=1; i<=num; i++) {
			     out.println("*");
			}
		 out.println("</body>");
		 out.println("</html>");
	}

}
