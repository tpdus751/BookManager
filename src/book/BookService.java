package book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
	private BookDAO bookDao;
	
	public BookService(BookDAO bookDao) {
		this.bookDao = bookDao;
	}
	
	// 책 등록
	public boolean regist(Book book) {
		int result = bookDao.inserMember(book);
		
		return (result == 1) ? true : false;
	}
	
	// 책 조회
	public Book read(int no) {
		Book book = bookDao.selectBook(no);
		return book;
	}
	
	// 책 목록 조회
	public List<Book> listAll() {
		List<Book> bookList = bookDao.selectBookAll();
		return bookList;
	}
	
	// 책 가격 수정
	public boolean edit(Book book, int oldPrice) {
		if (book == null) return false;
		if (oldPrice == 0) return false;
		
		int result = 0;
		
		Book bookInfo = bookDao.selectBook(book.getNo());
		if (oldPrice == bookInfo.getPrice()) {
			result = bookDao.updateBook(book);
		}
		
		return (result == 1) ? true : false;
	}
	
	// 책 1개 삭제
	public boolean remove(int no) {
		if (bookDao.selectBook(no) == null) return false;
		
		int result = bookDao.deleteBook(no);
		
		return (result == 1) ? true : false;
	}
	
}
