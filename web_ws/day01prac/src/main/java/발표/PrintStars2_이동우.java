package 발표;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/starprint")
public class PrintStars2_이동우 extends HttpServlet{


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		String star = req.getParameter("stars");
		int stars = Integer.parseInt(star);


		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + "원하는 수만큼  피라미드 별 출력하기" + "</h1>");

		for(int i = 1; i < stars; i++) {
			
			for(int j = 1; j < i; j++) {
				out.println("*");
			}
			out.println("<h1>" + "</h1>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
