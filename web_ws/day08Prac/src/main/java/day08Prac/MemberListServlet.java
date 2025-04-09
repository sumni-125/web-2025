package day08Prac;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberlist")
public class MemberListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberService s = new MemberService();
		ArrayList<Member> list = s.selectAll();
		
		req.setAttribute("list", list);
		
		//req.getRequestDispatcher("WEB-INF/views/memberList.jsp").forward(req, resp);
		req.getRequestDispatcher("WEB-INF/views/memberList2.jsp").forward(req, resp);

	}
}
