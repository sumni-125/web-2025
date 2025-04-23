package tripMate.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import tripMate.model.BlogMainDTO;
import tripMate.service.BlogMainService;

@WebServlet("/update")
public class BlogUpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 String id = req.getParameter("id");
		    
		    if (id == null || id.trim().isEmpty()) {
		        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing blog ID");
		        return;
		    }

		    BlogMainService service = new BlogMainService();
		    BlogMainDTO blog = service.getBlogById(id);  // 이 메서드가 DAO 통해 blog + imageList 가져옴

		    req.setAttribute("blog", blog);
		    req.getRequestDispatcher("WEB-INF/views/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

	    String saveDir = req.getServletContext().getRealPath("upload");
	    int maxSize = 10 * 1024 * 1024;  // 최대 10MB

	    MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize, "UTF-8", new DefaultFileRenamePolicy());

	    String id = multi.getParameter("id");
	    String title = multi.getParameter("title");
	    String content = multi.getParameter("content");

	    BlogMainService service = new BlogMainService();

	    // 1. 제목, 내용 수정
	    List<String> newImages = new ArrayList<>();
	    List<String> imagesToDelete = new ArrayList<>();

	    // 2. 삭제할 이미지 처리
	    String[] deleteImages = multi.getParameterValues("deleteImage");
	    if (deleteImages != null) {
	        imagesToDelete.addAll(Arrays.asList(deleteImages));
	    }

	    // 3. 새 이미지 업로드
	    Enumeration files = multi.getFileNames();
	    while (files.hasMoreElements()) {
	        String name = (String) files.nextElement();
	        String fileName = multi.getFilesystemName(name);
	        if (fileName != null) {
	            newImages.add(fileName);  // 새 이미지 목록에 추가
	        }
	    }

	    // 4. 수정된 정보 처리
	    service.modifyMember(id, title, content, newImages, imagesToDelete);

	    // 수정 완료 후 상세 페이지로 리다이렉트
	    resp.sendRedirect(req.getContextPath() + "/blogpart?id=" + id);
	}

}
