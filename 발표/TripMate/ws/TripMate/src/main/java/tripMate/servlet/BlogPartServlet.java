	package tripMate.servlet;
	
	import java.io.IOException;
	
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import tripMate.dao.BlogMainDAO;
	import tripMate.model.BlogMainDTO;
	
	// 상세 페이지를 보여줄 서블릿
	@WebServlet("/blogpart")
	public class BlogPartServlet extends HttpServlet {
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        // 'id' 파라미터 확인
	        String id = req.getParameter("id");
	        if (id == null || id.trim().isEmpty()) {
	            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or invalid 'id' parameter");
	            return;
	        }
	
	        // 'imgIndex' 파라미터 처리
	        String imgIndexStr = req.getParameter("imgIndex");
	        int imgIndex = 0;
	        try {
	            if (imgIndexStr != null) {
	                imgIndex = Integer.parseInt(imgIndexStr);
	            }
	        } catch (NumberFormatException e) {
	            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid 'imgIndex' parameter");
	            return;
	        }
	
	        // DAO에서 블로그 정보를 조회
	        BlogMainDAO dao = new BlogMainDAO();
	        BlogMainDTO blog = dao.selectByIdWithImage(id);
	        if (blog == null) {
	            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Blog not found for id: " + id);
	            return;
	        }
	
	        // JSP로 데이터 전달
	        req.setAttribute("blog", blog);
	        req.setAttribute("imgIndex", imgIndex);
	
	        // blogpart.jsp로 포워딩
	        req.getRequestDispatcher("WEB-INF/views/blogpart.jsp").forward(req, resp);
	    }
	}