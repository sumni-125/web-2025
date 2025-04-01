package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿으로 등록함, 서블릿 이름 정의 :  이 이름을  클라이언트가   요청함


//응답데이터 유형을 설정할 수 있다 
//  resp.setContentType("text/plain;charset=utf-8")
//  resp.setContentType("text/html;charset=utf-8");

@WebServlet("/contentInfo")
public class 응답정보유형설정하기  extends HttpServlet{
	
	
	 
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		 System.out.println(" hello servlet");
	 
		 
		 resp.setCharacterEncoding("utf-8");
		 
		 //서버가 보내는 데이터 타입 mime 이라고 한다.
		 
		 //두 개의 차이를 경험하자 !!! 
		 //resp.setContentType("text/plain;charset=utf-8");
		 resp.setContentType("text/html;charset=utf-8");
		 
		 //https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
		 
		 //응답을 보내기 위한 스트림 얻어오기		 
		 PrintWriter out  =  resp.getWriter();
		 
		 
		 //보내는 스트림에 응답할 내용을 흘려보낸다 
		 // 주로 서버는 웹문서 (html css javascript)를 반환한다
		 out.println("<html>");
		 out.println("<head>");
		 out.println("</head>");
		 out.println("<body>");		 
		 out.println("<h2>서보가 보내는 데이터의 형식 contentType</h2>");		 
		 out.println( "클라이언트의 요청에 응답합니다.<br>  웹문서 타입이나  플레인문서(기본text문서)를 정하면 클라이언트가 이 문서를 그에 맞에 해석합니다. ^^");
		 out.println("</body>");
		 out.println("<html>");
		 out.close();
		 
		
	}

}
