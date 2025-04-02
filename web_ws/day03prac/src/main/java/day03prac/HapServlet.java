package day03prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1~10까지의 합을 응답하는 서블릿 만들기
@WebServlet("/hap")
public class HapServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//
		
		//1~10까지의 합 구하기
		
		int sum =0;
		for(int i=1;i<=10;i++) {
			sum+=i;
		}
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println( "</head>");
		out.println("<body>");
		
		out.println("<h1>"+sum+"</h1>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
