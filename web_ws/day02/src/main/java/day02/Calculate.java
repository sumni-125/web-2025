package day02;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class Calculate extends HttpServlet {
	
	 @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String su_1 = req.getParameter("su1");
		String su_2 = req.getParameter("su2");
		
		int su1 = Integer.parseInt(su_1);
		int su2 = Integer.parseInt(su_2);
		
		int sum=su1+su2;
		//int sub=su1-su2;
		//int mul=su1*su2;
		//int div=su1/su2;
		
		System.out.println(sum);
		//System.out.println(sub);
		//System.out.println(mul);
		//System.out.println(div);
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+sum+"</h1>");
		//out.println("<h1>"+sub+"</h1>");
		//out.println("<h1>"+mul+"</h1>");
		//out.println("<h1>"+div+"</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
		
	}
	
}
