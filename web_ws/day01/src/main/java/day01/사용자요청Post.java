package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿으로 등록함, 서블릿 이름 정의 :  이 이름을  클라이언트가   요청함
@WebServlet("/login")
public class 사용자요청Post  extends HttpServlet{
	 
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		 System.out.println(" hello servlet");
	  
		 resp.setCharacterEncoding("utf-8");
		 resp.setContentType("text/html;charset=utf-8");
		 //응답을 보내기 위한 스트림 얻어오기		 
		 PrintWriter out  =  resp.getWriter();
		 
		 
		 
		 //post로 요청이 온 경우 클라이언트의 값 얻어오기 
		 
		 String id =  req.getParameter("id");
		 String pw  = req.getParameter("pw");
		 
	  
		 
		 
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head> ");
		out.println("<meta charset=\"UTF-8\">");
		out.println( "<title>Insert title here</title> ");
		out.println( "</head> ");
		out.println( "<body>");
		out.println( "<h2>"+id+"님 로그인 되었습니다</h2>" );
	 
		 
		out.println("</body> ");
		out.println("</html> "); 
		 
		 
		 
	}

}
