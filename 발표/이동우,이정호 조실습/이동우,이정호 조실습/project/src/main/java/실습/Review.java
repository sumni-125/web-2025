package 실습;

public class Review {
	String id;
	String user;
	String title;
	String content;
	String rating;
	String date;
	
	public Review(String id, String user, String title, String content, String rating, String date) {
		this.id = id;
		this.user = user;
		this.title = title;
		this.content = content;
		this.rating = rating;
		this.date = date;
	}
	public Review(String content, String rating, String user, String title) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.rating = rating;
	}
	public Review() {
		
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", user=" + user + ", title=" + title + ", content=" + content + ", rating="
				+ rating + ", date=" + date + "]";
	}
	public String getId() {
		return id;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getRating() {
		return rating;
	}
	public String getDate() {
		return date;
	}

}
