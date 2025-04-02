package day03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day03.mvcAcorn.Acorn;
import day03.mvcAcorn.AcornDAO;


@WebServlet("/DBTestServlet4")
public class DBTestServlet4 extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

		AcornDAO dao = new AcornDAO();
		ArrayList<Acorn> list  =dao.getAllAcorns();
		
		
		//응답하기
		 // ArrayList 출력
        out.println("<html><body>");
        out.println("<h2>검색 결과</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>비번</th></tr>");

        for (Acorn acorn : list) {
            out.println("<tr>");
            out.println("<td>" + acorn.getId() + "</td>");
            out.println("<td>" + acorn.getName() + "</td>");
            out.println("<td>" + acorn.getPw() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
		
		
	 
}
