package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/regReview")
public class ReviewRegServlet  extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out  = response.getWriter(); 
	 
			//클라이언트가 body로 보낸 데이터 읽어오는 방법
		  	BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        }
	        	         
	        
	        
	        System.out.println( sb.toString());
	        reader.close();

	        // 읽은 본문을 JSON으로 파싱
	        JSONObject jsonBody = new JSONObject(sb.toString());
	        
	        // id와 content 키에 대한 값 추출
	        String id = jsonBody.getString("id");
	        String content = jsonBody.getString("content");
	        
	        
	        System.out.println("Received id: " + id);
	        System.out.println("Received content: " + content); 
		
		
			ReviewDTO review = new ReviewDTO( id, content);			
			System.out.println(  review);
			
			 ReviewService service= new ReviewService();
			 int cnt= service.registerReview(review);
			 //0 실패 , 1:성공
			 	
			out.print(cnt);
		
	}
}
