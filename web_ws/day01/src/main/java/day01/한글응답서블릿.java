package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿으로 등록함
// url매핑 이름 정의 :  이 이름을  클라이언트가   요청하면 해당 서블릿이 실행되어 결과가 응답됨
@WebServlet("/servlet1")
public class 한글응답서블릿  extends HttpServlet{
	
	
	 
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		 System.out.println(" hello servlet");
		 
		 //서버가 응답하기전에
		 //보내는 데이터의 인코딩을 설정해야 한다.
		 //한글을 위해서 utf-8지정함 
		 // 주의사항은  보내는 스트림을 얻어오기전에 설정해야함 ! 순서가 중요합니다
		 
		 
		 resp.setCharacterEncoding("utf-8");
		 resp.setContentType("text/html;charset=utf-8");
		 
		 //응답을 보내기 위한 스트림 얻어오기		 
		 PrintWriter out  =  resp.getWriter();
		 
		 //보내는 스트림에 응답할 내용을 흘려보낸다 
		 out.println( "요청에 대한 응답입니다.   반갑습니다.  한글이 문제가 없이 전송됩니다 서버가 응답합니다. welcome !!!!!! ^^");
		
	}

}
