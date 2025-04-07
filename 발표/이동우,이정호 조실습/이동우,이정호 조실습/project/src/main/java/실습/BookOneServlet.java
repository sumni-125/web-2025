package 실습;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectOne")
public class BookOneServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		
		BookService service = new BookService();
		Book book = service.getBookOne(title);
		
		req.setAttribute("book", book);
		req.getRequestDispatcher("WEB-INF/views/bookOneList.jsp").forward(req, resp);
	}
}
