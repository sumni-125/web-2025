package 발표;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/math03")
public class prac3_최지태 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글 출력을 위한 세팅
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		// 출력 내용
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head> ");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>삼단출력</title>");
		out.println("</head> ");
		out.println("<body>");
		out.println("<h1>3단 출력</h1>");
		for (int i = 1; i < 10; i++) {
			out.println("<h3>" + "3 * " + i + " = " + (i * 3) + "</h3>");
		}
		out.println("</body> ");
		out.println("</html> ");
	}
}
