package getpost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/helloGetPost")
public class HelloServletGetPost  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		
		//회원등록
		//회원등록화면
		resp.setCharacterEncoding("utf-8");  //보내는 데이터를 인코딩하는 방법 설정
		resp.setContentType("text/html;charset=utf-8"); //  보내는데이터의형식이 html, 웹브라우저가 utf-8로 해석
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>회원가입 </h2>");
		out.println("<form action=\"/day03/helloGetPost\"  method=\"post\">");
		out.println("<input type=\"text\" name=\"id\">");
		out.println("<button>등록</button");
		out.println("</form>");	
		out.println("</body>");
		out.println("</html>");
		
		 
	}
	
	
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 
	     resp.setCharacterEncoding("utf-8");  //보내는 데이터를 인코딩하는 방법 설정
		 resp.setContentType("text/html;charset=utf-8"); //  보내는데이터의형식이 html, 웹브라우저가 utf-8로 해석
			
		 //회원정보 추출 , 데이터베이스 등록
		 //(회원정보가 등록)		 
		 
		 String id  =req.getParameter("id");		 
		 resp.getWriter().println( id + "회원정보 데이터베이스 등록 완료");
	}

}
