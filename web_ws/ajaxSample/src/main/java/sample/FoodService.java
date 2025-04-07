package sample;

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
	
	
	public JSONArray  getFoodList() {		
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
		return arr;		
	}
	
	
  public JSONArray  getFoodRealList() {
		/*
	   ArrayList<Food> list = new ArrayList<>();
		list.add( new Food("볶음밥","6000"));
		list.add( new Food("김밥","4000"));
		list.add( new Food("쫄면","6000"));	  
		*/ 
		
	    ArrayList<Food>  list =dao.getFoodList();	
	    
	    //json 변환하기 
	    
		JSONArray arr  = new JSONArray();		
		for( int i=0 ; i< list.size();i++) {
			Food food= list.get(i);
			JSONObject  foodJson = new JSONObject();
			foodJson.put("name", food.getName());
			foodJson.put("price", food.getPrice());			
			arr.put(foodJson);
		}		
		return arr;		
	}

}
