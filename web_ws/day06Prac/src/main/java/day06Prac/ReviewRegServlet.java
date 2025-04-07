package day06Prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/regReview")
public class ReviewRegServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 사용자 데이터 가져오기
		BufferedReader reader = new BufferedReader( new InputStreamReader(req.getInputStream())) ;
		
		//
		StringBuilder sb = new StringBuilder();
		String line;
		
		while( (line=reader.readLine()) != null ) {
			sb.append(line);
		}
		
		
		System.out.println("클라이언트가 보낸 json데이터");
		System.out.println(sb.toString());
		
		String jsonData = sb.toString();
		// {id:4,content:"사은품주세요"}
		
		JSONObject reviewJson = new JSONObject(jsonData);
		
		String id = reviewJson.getString("id");
		String content = reviewJson.getString("content");
		
		// =>자바 Review 객체로 만들기
		Review review = new Review(id,content);
		
		System.out.println(review.getId());
		System.out.println(review.getContent());
		
		// 서비스를 통해서 등록하기
		
		ReviewService service = new ReviewService();
		int cnt = service.registerReview(review);
		
		
		// 응답 1,0
		resp.getWriter().print(cnt);
		
	}
}
