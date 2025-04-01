package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bookInfo")

public class BookInfoServlet  extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
	resp.setCharacterEncoding("utf-8");
	resp.setContentType("text/html;charset=utf-8");
	
	PrintWriter out =resp.getWriter();
		
	Book book =new Book();
	book.setAuthor("김진명");
	book.setPrice(15400);
	book.setTitle("고구려 도망자 을불");
	//	out.println( book.toString());
	out.println( book );
	out.close();	
	
}
}
