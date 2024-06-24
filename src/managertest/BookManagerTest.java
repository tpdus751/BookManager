package managertest;

import java.util.List;

import book.Book;
import book.BookDAO;
import book.BookService;

public class BookManagerTest {

	public static void main(String[] args) {
		BookService service = new BookService(new BookDAO());
		Book book;
		
		// 책 등록
		book = new Book("세연이의 일기책", "인문학", "박세연", "세연퍼블리싱", 20000);
		if (service.regist(book)) {
			System.out.println("책을 등록하였습니다.");
		} else {
			System.out.println("책 등록에 실패하였습니다.");
		}
		
		// 책 조회
		book = service.read(2);
		if (book != null) {
			System.out.println(book.toString());
		}
		
		// 책 목록 조회
		List<Book> bookList = service.listAll();
		for (Book bk : bookList) {
			System.out.println(bk.toString());
		}
		
		// 책 가격 수정
		book = new Book(1, null, null, null, null, 40000);
		service.edit(book, 25000);

		// 책 1개 삭제
		service.remove(2);
	}

}
