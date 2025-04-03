package prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pracDan")
public class DanServlet  extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		String su_ = req.getParameter("su");
		
		int su=2;
		
		
		if( su_ != null) {
			su  = Integer.parseInt(su_);
		}
		
		
		//2단 정보  => 데이터(모델)
		String result="";   // " 2*1 =2   2*2 =4   2*3 =6 "
		
		for( int i=1 ; i<=9 ; i++) {			
			String unit = su  +"* " + i  +"=" + su*i  +"<br>";
			result += unit; 
		}
	 
		System.out.println( result);
		
		//응답 	
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		 
		PrintWriter  out  = resp.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<style>");
		out.print("  .content{ border:1px solid black; } ");
		out.print("</style>");
		out.print("<body>");
		out.print("</body>");
		out.print("<div class=\"content\">");
		out.print(result);
		out.println("</div>");
		out.print("</html>");
		
	}
}
