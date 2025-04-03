package day04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/video")
public class VideoServlet extends HttpServlet {
    private static final int BUFFER_SIZE = 1024;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 동영상 파일의 실제 파일 시스템 경로 가져오기
        String videoPath = getServletContext().getRealPath("/WEB-INF/sample.mp4");
        File videoFile = new File(videoPath);

        if (!videoFile.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Video not found");
            return;
        }

        // 동영상 파일의 MIME 타입 설정
        response.setContentType("video/mp4");

        // 파일 스트림을 클라이언트에 전송
        try (FileInputStream fileInputStream = new FileInputStream(videoFile);
        		
        	//동영상을 제공하기 위해서는 바이트기반 스트림을 이용한다	
             OutputStream outputStream = response.getOutputStream()) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
