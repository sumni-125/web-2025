package review;

public class ReviewDTO {
	
	String id;
	String content;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	 public ReviewDTO() {
		// TODO Auto-generated constructor stub
	}
	public ReviewDTO(String id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", content=" + content + "]";
	}

}
