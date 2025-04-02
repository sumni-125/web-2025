package 발표;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findDivisors")
public class FindDivisors_이정호 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num_ = req.getParameter("num");
		int num = Integer.parseInt(num_);
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>");
		
			for(int i = 1; i <= num; i++) {
				if(num % i == 0) {
					out.print(i + ", ");
				}
			}
			
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
