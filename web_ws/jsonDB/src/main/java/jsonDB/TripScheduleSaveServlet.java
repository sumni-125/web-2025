package jsonDB;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/tripScheduleSave")
public class TripScheduleSaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // JSON을 문자열로 받기
    	
    	//1) 한글설정
    	resp.setCharacterEncoding("utf-8");    	 
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/plain");
    	
    	//2)요청바디 읽기
        StringBuilder jsonBuffer = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuffer.append(line);
            }
        }

        //3) 확인
        String jsonData = jsonBuffer.toString();
        System.out.println("받은 JSON 데이터: " + jsonData);

        //4) JSON → 객체 변환  , 라이브러리 사용  (자바객체로 변환)        
        ObjectMapper mapper = new ObjectMapper();
        TripSchedule tripSchedule = mapper.readValue(jsonData, TripSchedule.class);

        //5) 확인
        System.out.println( tripSchedule);
         
        
        //6) 데이터저장
        TripScheduleDAO.save(tripSchedule);

      
        resp.getWriter().write("여행 일정 저장 완료!");
    }
}

