package tripMate.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import tripMate.dao.BlogMainDAO;
import tripMate.model.BlogImgDTO;
import tripMate.model.BlogMainDTO;
import tripMate.model.User;
import tripMate.service.BlogMainService;

@WebServlet("/blogreg")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // 1MB
    maxFileSize = 10 * 1024 * 1024,  // 최대 파일 크기 10MB
    maxRequestSize = 50 * 1024 * 1024 // 전체 요청 최대 크기 50MB
)
public class BlogRegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/loadup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String savePath = "/Users/idong-u/Downloads/TripMate/src/main/webapp/upload";

        Part filePart = req.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        if (fileName == null || fileName.isEmpty()) {
            resp.sendRedirect("error.jsp");
            return;
        }

        File uploadDir = new File(savePath);
        if (!uploadDir.exists()) uploadDir.mkdirs();
        filePart.write(savePath + File.separator + fileName);
        String filePath = "upload/" + fileName;

        String blogTitle = req.getParameter("blog_title");
        String blogContent = req.getParameter("blog_content");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("login");
            return;
        }
        String userId = user.getUserCode();

        BlogMainDTO mdto = new BlogMainDTO(blogTitle, blogContent);
        mdto.setUserCode(userId);

        BlogImgDTO idto = new BlogImgDTO(filePath);

        BlogMainService service = new BlogMainService();
        service.register(mdto, idto);

        resp.sendRedirect("/TripMate/mainblog");
    }
}