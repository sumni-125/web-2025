package food;


import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class FoodService {
	
	FoodDAO dao = new FoodDAO();
	
	
	public JSONObject getFoodInfo() {		
		Food food = new Food("볶음밥","6000"); 
		JSONObject  o= new JSONObject();
		o.put("name", food.getName());
		o.put("price", food.getPrice());		
		return o;
	}
	
	
	
	public JSONObject  getFoodListPaging(int page) {		
		
		ArrayList<Food> list = new ArrayList<>();
		list.add( new Food("볶음밥","6000"));
		list.add( new Food("김밥","4000"));
		list.add( new Food("쫄면","6000"));		
		JSONArray arr  = new JSONArray();		
		for( int i=0 ; i< list.size();i++) {
			Food f= list.get(i);
			JSONObject  o = new JSONObject();
			o.put("name", f.getName());
			o.put("price", f.getPrice());			
			arr.put(o);
		}
		
		
		JSONObject  result  = new JSONObject();
		result.put("list", arr);
		result.put("page", page);
		
		
		return result;		
	}	
	
	
  /*
   * 
   * 페이지에 대한 목록가져오기 
   * 페이지 정보 담기
   */
  public JSONObject  getFoodRealListPaging(int page) {		 
		
	    ArrayList<Food>  list =dao.getFoodListPaging(page);	    
		JSONArray arr  = new JSONArray();		
		for( int i=0 ; i< list.size();i++) {
			Food f= list.get(i);
			JSONObject  o = new JSONObject();
			o.put("name", f.getName());
			o.put("price", f.getPrice());			
			arr.put(o);
		}	
		
		
		//메뉴목록 list와 page 정보를 하나의  jsonObject로 만든다. 
		JSONObject  result  = new JSONObject();
		result.put("list", arr);
		result.put("page", page);
		
		
		return result;		
	}

}
