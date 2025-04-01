package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿으로 등록함, 서블릿 이름 정의 :  이 이름을  클라이언트가   요청함
@WebServlet("/diff")
public class 사용자요청GetPost차이  extends HttpServlet{
	 
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		 System.out.println(" hello servlet");
	  
		 resp.setCharacterEncoding("utf-8");
		 resp.setContentType("text/html;charset=utf-8");
		 //응답을 보내기 위한 스트림 얻어오기		 
		 PrintWriter out  =  resp.getWriter();
		 
		 
		 
	 	out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head> ");
		out.println("<meta charset=\"UTF-8\">");
		out.println( "<title>Insert title here</title> ");
		out.println( "</head> ");
		out.println( "<body>");
		out.println( "<h2>서버에 요청할 때 방법: GET, POST   기본값은 GET</h2>" );
		out.println( "<ul> " );
		out.println( "<li>get : url요청, from에서 method=\"get\"  </li>" );
		out.println( "<li>get : 보통 서버에 어떤 정보를 얻어올 때 사용하며, 요청의 기본방법  </li>" );
		out.println( "<li>get : 요청시 서버에 쿼리스트링으로 데이타보낼 수 있다. url에 데이터가 표시됨, 데이터크기 제한됨  </li>" );
			
	 
		out.println( "<li>post :  form에서  method=\"post\"  </li>" );
		out.println( "<li>post 요청은 서버에 어떤 정보들을 등록할 때 사용함 , 회원가입 서비스 </li>" );
		out.println( "<li>post로 서버에 데이터를 보내면 보이지 않는형태로 데이터크기의 제한없이 보낼 수 있음 </li>" );
		out.println( "<li>post는  회원가입 , 파일업로드시 사용 된다. </li>" );
	
		out.println( "</ul> " );	 
		out.println("</body> ");
		out.println("</html> "); 
		 
	}

}
