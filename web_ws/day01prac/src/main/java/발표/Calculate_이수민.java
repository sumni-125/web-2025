package 발표;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class Calculate_이수민 extends HttpServlet {
	
	 @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String su_1 = req.getParameter("su1");
		String su_2 = req.getParameter("su2");
		String a = req.getParameter("a");
		
		int su1 = Integer.parseInt(su_1);
		int su2 = Integer.parseInt(su_2);
		
		
		int result;
		
		switch(a) {
		
		case "+":
			result = su1+su2;
			break;
		case "-":
			result = su1-su2;
			break;
		case "*":
			result = su1*su2;
			break;
		case "/":
			result = su1/su2;
			break;
		default :
			result=0;
		
		}
		
		//System.out.println(result);
		//http://localhost:8080/day02/calculate?su1=15&su2=5&a=/
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>result = "+result+"</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
		
	}
	
}
