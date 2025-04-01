package day01prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/suAdd")
public class SecondServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String su_=request.getParameter("su");
		int su = Integer.parseInt(su_);
		
		int sum=0;
		for(int i=1;i<=su;i++) {
			sum += i;
		}
		
		System.out.println(sum);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+sum+"</h1>");
		out.println( "<img src=\"/day01Prac/b.jpg\">");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
	}
}
