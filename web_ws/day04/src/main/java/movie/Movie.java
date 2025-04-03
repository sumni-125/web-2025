package movie;

public class Movie {
	
	String code;
	String title;
	String imgUrl;
	String genre;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Movie(String code, String title, String imgUrl, String genre) {
		super();
		this.code = code;
		this.title = title;
		this.imgUrl = imgUrl;
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Movie [code=" + code + ", title=" + title + ", imgUrl=" + imgUrl + ", genre=" + genre + "]";
	}
	 
	
	
	
	

}
