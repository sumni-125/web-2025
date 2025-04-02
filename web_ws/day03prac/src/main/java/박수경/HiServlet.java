package 박수경;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/sayHi2")
public class HiServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청 정보 끄내기
		String user = request.getParameter("user");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;char-set=uft-8");
		
		PrintWriter out = response.getWriter();
		
		//모델 만들기
		
		
		//응답하기
		out.println("<html>");
		
		out.println("<head>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>"+user+"</h1>");
		out.println("</body>");
		
		out.println("</html>");
		
	}
}
