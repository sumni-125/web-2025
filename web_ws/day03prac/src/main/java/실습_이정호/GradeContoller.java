package 실습_이정호;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/grade")
public class GradeContoller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GradeService service = new GradeService();
		ArrayList<Grade> list = service.getList();
		
		req.setAttribute("grade", list);
		req.getRequestDispatcher("WEB-INF/views/GradeView_이정호.jsp").forward(req, resp);
	}
}
