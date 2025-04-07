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
@WebServlet("/personInfo")
public class PersonInfo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("홍길동", 23));
		list.add(new Person("홍길순", 25));
		list.add(new Person("홍순길", 28));
		
		JSONArray per = new JSONArray();
		
		for(int i=0;i<list.size();i++) {
			Person p = list.get(i);
			JSONObject personO = new JSONObject();
			
			personO.put("name", p.getName());
			personO.put("age", p.getAge());
			
			per.put(personO);
		}
		resp.getWriter().println(per);
	}
}
