package 발표;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findDivisorsdd")
public class findDivisors_김보성 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));
		A_김보성 a = new A_김보성();
		String result = a.약수구하기(num);
        response.setContentType("text/html");
     
        PrintWriter out = response.getWriter();
        out.println("<html>");                  
        out.println("<head>");       
        out.println("</head>"); 
        out.println("<body>");
        out.println(result);
        out.println("</body>"); 
        out.println("</html>"); 
	}
	
}
