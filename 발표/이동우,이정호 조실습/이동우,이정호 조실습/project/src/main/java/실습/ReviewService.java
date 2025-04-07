package 실습;

import java.util.ArrayList;

public class ReviewService {
	ReviewDAO dao = new ReviewDAO();
	
	public ArrayList<Review> getReview(){
		ArrayList<Review> list = dao.selectAll("SELECT * FROM V_REVIEW_LIST ORDER BY REVIEW_ID DESC");
		return list;
	}
	
	public void addReview(Review review) {
		dao.addReview(review);
	}
	
	public void updateReview(String content, String rating, String id) {
		dao.update(content, rating, id);
	}
	
	public Review getOneReview(String id) {
		Review review = dao.selectOne(id);
		return review;
	}
	
	public void deleteReview(String id) {
		dao.delete(id);
	}
	
	public ArrayList<Review> getStarReview(){
		ArrayList<Review> list = dao.selectAll("SELECT * FROM V_REVIEW_LIST ORDER BY RATING DESC");
		return list;
	}
}
