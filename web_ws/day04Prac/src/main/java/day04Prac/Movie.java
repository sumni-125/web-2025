package day04Prac;

//id VARCHAR2(10) PRIMARY KEY,
//title VARCHAR2(100) NOT NULL,
//image_url VARCHAR2(500),
//genre VARCHAR2(50)

public class Movie {
	
	String id;
	String title;
	String image_url;
	String genre;
	
	public Movie(String id, String title, String image_url, String genre) {
		super();
		this.id = id;
		this.title = title;
		this.image_url = image_url;
		this.genre = genre;
	}
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", image_url=" + image_url + ", genre=" + genre + "]";
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImage_url() {
		return image_url;
	}

	public String getGenre() {
		return genre;
	}
	
	
	
}
