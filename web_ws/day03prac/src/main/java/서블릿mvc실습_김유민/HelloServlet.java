package 서블릿mvc실습_김유민;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello김유민")
public class HelloServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=1; i<=5; i++) {
			list.add("안녕~v(^o^)v");
		}
		
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		//응답하기
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>인사하기</h1>");
		out.println("<ul>");

        for (String msg : list) {
            out.println("<li>" + msg + "</li>");
        }

        out.println("</ul>");
		
		out.println("</body>");
		out.println("</html>");
		
	}
}
