package teamproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteOne")
public class DeleteOne extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String parent_id = req.getParameter("parent_id");

		Service s = new Service();
		s.deleteParents(parent_id);

		resp.sendRedirect("/day05Prj/parentsList");

	}

}
