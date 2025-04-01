package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/serviceHap")
public class 두수의합구하는서비스 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//클라이언트가 보낸 값 얻어오기 
		// String   값  = getParameter("키이름") ;
		// 문자열로 얻어오기 때문에 숫자형의 데이터라면 숫자로 쓰기 위해 숫자형으로 변환을 해야한다.
	 
		
		int su1  = Integer.parseInt( request.getParameter("su1"));
		int su2  = Integer.parseInt( request.getParameter("su2"));
		int sum = su1+su2;
		
		response.setContentType("text/html");   //서버가 보내는 데이터의 형식   html형식임을 알려줌  
	
		response.setCharacterEncoding("utf-8");  //utf-8형식으로 데이터를 보낸다는 의미
		PrintWriter out = response.getWriter();  //출력스트림 얻어오기
		
		
		
		out.println("<html>");                  
		out.println("<head>");       
		out.println("</head>"); 
		out.println("<body>");
		out.println(sum);
		out.println("</body>"); 
		out.println("</html>"); 
		
	}	
}
