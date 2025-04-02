package 발표;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/구구단")
public class multiplicationTable_박수경 extends HttpServlet{
	//3. 원하는단 제공하기 (원하는단을 제공하는 서비스)
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//응답하기?
		String num_ = req.getParameter("num");
		int num = Integer.parseInt(num_);
		
		
		PrintWriter out= res.getWriter();
		
		out.println("<html>");
		out.println("<head");
		out.println("</head>");
		out.println("<body>");
		for(int i=1; i<=9; i++) {
			out.println(num+"*"+i+"="+ (num*i)+"<br>");
		}
		//out.println("<h1>"+num_+"</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
