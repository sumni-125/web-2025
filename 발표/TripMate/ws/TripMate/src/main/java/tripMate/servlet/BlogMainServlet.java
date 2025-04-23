package tripMate.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tripMate.dao.BlogMainDAO;
import tripMate.model.BlogMainDTO;
import tripMate.model.BlogPost;
import tripMate.model.User;

@WebServlet("/mainblog")
public class BlogMainServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // 세션에서 로그인된 사용자 정보 가져오기
	        HttpSession session = request.getSession();
	        User user = (User) session.getAttribute("user");  // user 객체 세션에서 가져오기

	        if (user != null) {  // 로그인된 사용자만 블로그 페이지에 접근 가능
	            String userCode = user.getUserCode();  // User 객체에서 userCode 추출
	            BlogMainDAO dao = new BlogMainDAO();
	            ArrayList<BlogMainDTO> userBlogs = dao.getUserBlogs(userCode);  // 로그인된 사용자에 해당하는 블로그 글 목록 조회
	            request.setAttribute("userBlogs", userBlogs);
	            request.getRequestDispatcher("WEB-INF/views/blogmain.jsp").forward(request, response);  // 블로그 페이지로 포워딩
	        } else {
	            // 로그인되지 않은 사용자는 로그인 페이지로 리디렉션
	            response.sendRedirect("login");  // 로그인 페이지로 리디렉션
	        }
	    }
    }

