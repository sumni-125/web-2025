package 실습;

public class Book {
	String id;
	String title;
	String author;
	String category;
	
	public Book(String id, String title, String author, String category) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category + "]";
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getCategory() {
		return category;
	}
	
}
