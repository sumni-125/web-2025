package 실습;

import java.util.ArrayList;

public class BookService {
	BookDAO dao = new BookDAO();
	
	public ArrayList<Book> getBookList(){
		ArrayList<Book> list = dao.selectAll();
		return list;
	}
	
	public ArrayList<Book> getBookCategoryList(String category){
		ArrayList<Book> list = dao.selectCategory(category);
		return list;
	}
	
	public Book getBookOne(String title) {
		Book book = dao.selectOne(title);
		return book;
	}
}
