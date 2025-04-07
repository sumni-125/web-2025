package review;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ReviewService {

	 
	ReviewDAO dao = new ReviewDAO();
	
	
	
	public ArrayList<ReviewDTO> getReviewList(){		
		return dao.selectAll();
	}
	
	
	
	
	
	public String getFoodJsonArray2() {
	    ArrayList<ReviewDTO> list = dao.selectAll();
	    JsonArray arr = new JsonArray();

	    for (ReviewDTO review : list) {
	        JsonObject o = new JsonObject();
	        o.addProperty("id", review.getId());
	        o.addProperty("content", review.getContent());
	        arr.add(o);
	    }

	    return new Gson().toJson(arr); // JsonArray → String
	}
	
	

	public    JSONArray  getReviewJsonArray() {	
		
		ArrayList<ReviewDTO> list  = dao.selectAll();		
		JSONArray arr = new JSONArray();
		
		for( int i=0; i<list.size() ;i++) {
			
			ReviewDTO review = list.get(i);
			JSONObject o = new JSONObject();
			o.put("id",  review.getId());
			o.put("content",  review.getContent());				 
			arr.put(o);
		}
		
		
		return arr;	  
	}
	
	
	
	public int registerReview( ReviewDTO review) {
		return dao.insertReview(review);
		
	}
	
	
	public int modifyReview( ReviewDTO review) {
		return dao.updateReview(review);
	}
	
	
	public int cancleDelete(String id) {
		return dao.deleteReview(id);
	}
	
	
	public static void main(String[] args) {
		ReviewService service = new ReviewService();
		 System.out.println( service.getReviewJsonArray());
	}
}
