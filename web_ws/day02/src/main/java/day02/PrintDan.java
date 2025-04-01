package day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dan")
public class PrintDan extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String d_ = req.getParameter("num");
		int num = Integer.parseInt(d_);
		
		String str = "";
		
		for(int i=1;i<10;i++) {
			str+=num+" * "+i+" = "+i*num+"<br>";
		}
		
		System.out.println(str);
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+str+"</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
}
