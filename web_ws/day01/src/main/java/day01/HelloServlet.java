package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿으로 등록함, 서블릿 이름 정의 :  이 이름을  클라이언트가   요청함
@WebServlet("/hello")
public class HelloServlet  extends HttpServlet{
	
	
	//######### 서블릿 동작 순서
	// 서블릿의 시작 매서드 service 
	// 톰캣이  서블릿으로 등록해 놓는다 ,이때 서블릿 이름이 같이 정의됨
	// 클라이언트가   서블릿의 이름을 요청하면 
	// 서블릿이 실행되어 응답한 결과가 전송되어 
	// 클라이언트의 웹브라우저에 보이게 된다
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		 System.out.println(" hello servlet");
		 
		 //서버가 응답하기전에
		 //보내는 데이터의 인코딩을 설정해야 한다.
		 //한글을 위해서 utf-8지정함 
		 // 주의사항은  보내는 스트림을 얻어오기전에 설정해야함 !
		 
		 resp.setCharacterEncoding("utf-8");              // 서바가 데이터를 보내는 인코딩의 형식 지정함 
		 resp.setContentType("text/html;charset=utf-8");  // 서버가 보내는 문서의형식과 인코딩 방식의 정보 제공함
		 
		 //응답을 보내기 위한 스트림 얻어오기		 
		 PrintWriter out  =  resp.getWriter();
		 
		 //보내는 스트림에 응답할 내용을 흘려보낸다 
		 out.println( " /hello 요청에 대한 응답입니다.   반갑습니다.  서버가 응답합니다. welcome !!!!!! ^^");
		
	}

}
