package mvc실습하기;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cuteImage")
public class CuteController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CuteServer c = new CuteServer();
		ArrayList<String> list =c.cuteImg();
		
		request.setAttribute("imglogs", list);
		request.getRequestDispatcher("WEB-INF/views/cuteimgView.jsp");
	} 
}
