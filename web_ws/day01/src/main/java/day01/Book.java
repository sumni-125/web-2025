package day01;

public class Book{
	 String title;
	 String author;
	 int price;
	 
	 
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	  

}
