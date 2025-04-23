package imageUpload;

 import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	
	
	
	//업로드 페이지 응답 (get)	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 		
		
		req.getRequestDispatcher("WEB-INF/views/upload.jsp").forward(req, resp);
		}
	
	
    
     
      //이미지 업로드 
      //
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	   String SAVE_PATH = "C:/Users/user/Documents/javafullstack2025/05_웹/WEB_CLOUD2/webws/imageUpload/src/main/webapp/uploads/";
    		

    	    
       // 업로드 경로 파일 확인하기 !! 
       //  String SAVE_PATH = request.getServletContext().getRealPath("/uploads");    	 
       //  String SAVE_PATH = new File(".").getCanonicalPath() + "/uploads";

        request.setCharacterEncoding("UTF-8"); //   한글 파일명 처리
        response.setContentType("text/html;charset=UTF-8");

        Part filePart = request.getPart("file");

        String fileName = getFileName(filePart);

        File saveDir = new File(SAVE_PATH);
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }

        File file = new File(saveDir, fileName);
        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, file.toPath());
        }

        response.getWriter().println("  파일 업로드 완료!<br>");
        response.getWriter().println("  저장 경로: " + file.getAbsolutePath());
    }

    
    
    
    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
