package getpost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/hello")
public class HelloServlet  extends HttpServlet  {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
	resp.setCharacterEncoding("utf-8");  //보내는 데이터를 인코딩하는 방법 설정
	resp.setContentType("text/html;charset=utf-8"); //  보내는데이터의형식이 html, 웹브라우저가 utf-8로 해석
	//resp.setContentType("text/plain;charset=utf-8");
	
	
	//클라이언트가 보내온 데이터 가져오기 
	
	String su = req.getParameter("su");	
	
    PrintWriter out  =  resp.getWriter();
    out.println("hello servelt 안녕 서블릿" + su);
		
	}

}
