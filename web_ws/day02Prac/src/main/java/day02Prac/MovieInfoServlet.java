package day02Prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//영화정보 응답하는 서블릿 만들기
// 
@WebServlet("/movieInfo")
public class MovieInfoServlet extends HttpServlet {
	
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//
		Movie m = new Movie("베테랑2","118분","황정민");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style> "
				+ "table, tr, td{"
				+ "border: 1px solid black;"
				+ "}"
				+ "</style>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		
		out.println("<tr>");
		
		out.println("<td>영화이름");
		out.println("</td>");
		out.println("<td>러닝타임");
		out.println("</td>");
		out.println("<td>주연배우");
		out.println("</td>");
		
		out.println("</tr>");
		
		out.println("<tr>");
		
		out.println("<td>"+m.getName()+"</td>");

		out.println("<td>"+m.getRunningtime()+"</td>");

		out.println("<td>"+m.getActor()+"</td>");

		
		out.println("</tr>");
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
	
	
}
