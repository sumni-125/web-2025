package tripMate.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import tripMate.dao.BlogImgDAO;
import tripMate.dao.BlogMainDAO;
import tripMate.model.BlogImgDTO;
import tripMate.model.BlogMainDTO;
@WebServlet("/insert")
public class BlogInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String saveDir = req.getServletContext().getRealPath("/upload");
        int maxSize = 10 * 1024 * 1024;

        java.io.File uploadDir = new java.io.File(saveDir);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        MultipartRequest multi = new MultipartRequest(
            req,
            saveDir,
            maxSize,
            "UTF-8",
            new DefaultFileRenamePolicy()
        );

        // 1. 텍스트 데이터 먼저 받기
        String title = multi.getParameter("title");
        String content = multi.getParameter("content");
        String userCode = multi.getParameter("userCode");

        BlogMainDTO blogDto = new BlogMainDTO();
        blogDto.setTitle(title);
        blogDto.setContent(content);
        blogDto.setUserCode(userCode);

        BlogMainDAO dao = new BlogMainDAO();
        String blogId = dao.insertAndReturnId(blogDto);  // 블로그 글 먼저 등록하고 blogId 받기

        // 2. 이미지 업로드 처리 (이제 blogId 있음!)
        if (blogId != null) {
            BlogImgDAO imgDao = new BlogImgDAO();
            Enumeration<?> fileNames = multi.getFileNames();

            while (fileNames.hasMoreElements()) {
                String name = (String) fileNames.nextElement();
                String fileName = multi.getFilesystemName(name);

                if (fileName != null) {
                    BlogImgDTO imgDTO = new BlogImgDTO();
                    imgDTO.setBlogId(blogId);
                    imgDTO.setImageUrl("/upload/" + fileName);

                    imgDao.insert(imgDTO); // ← 이걸 사용해야 맞음! (BlogImgDAO에 정의된 insert)
                }
            }

            resp.sendRedirect("mainblog");
        } else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "글 등록 실패");
        }
    }
}