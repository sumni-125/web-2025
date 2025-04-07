package day06Prac;

public class ReviewService {

	ReviewDAO dao = new ReviewDAO();

	// 리뷰등록하기
	public int registerReview(Review review) {

		int cnt = dao.insertReview(review);

		return cnt;
	}

}
