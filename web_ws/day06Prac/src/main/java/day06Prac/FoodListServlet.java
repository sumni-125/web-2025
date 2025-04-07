package day06Prac;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

//음식정보 여러개를 json으로 응답하기
//클라이언트가 ajax를 통해서 화면전환 없이 데이터만 가져온다
@WebServlet("/foodDataList")
public class FoodListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		
		//요청이 오면
		
		//모델(음식정보 여러개 : ArrayList<Food>
		
		ArrayList<Food> list = new ArrayList<>();
		list.add(new Food("김밥","5500"));
		list.add(new Food("라면","5000"));
		list.add(new Food("라볶이","6000"));
		
		//json 변환
		
		JSONArray aaa = new JSONArray();
		
		for(int i = 0;i<list.size();i++) {
			
			Food food = list.get(i);
			JSONObject foodO = new JSONObject();
			
			foodO.put("name", food.getName());
			foodO.put("price", food.getPrice());
			
			aaa.put(foodO);
		}
		
		//응답하기
		
		//resp.getWriter().println(list);
		resp.getWriter().println(aaa);
		
	}
	
	
}
