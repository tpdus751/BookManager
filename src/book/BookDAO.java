package book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	// 책 등록
	public int inserMember(Book book) {
		// DB 연결
		JDBConnection jdbc = new JDBConnection();
		
		// sql문 만들기
		String sql = new StringBuilder()
				.append("insert into book (no, name, genre, author, publisher, price)")
				.append("values (book_seq.nextval, ?, ?, ?, ?, ?)")
				.toString();
		
		int result = 0;
		
		
		
		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			// SQL문 매개변수에 값 추가
			jdbc.pstmt.setString(1, book.getName());
			jdbc.pstmt.setString(2, book.getGenre());
			jdbc.pstmt.setString(3, book.getAuthor());
			jdbc.pstmt.setString(4, book.getPublisher());
			jdbc.pstmt.setInt(5, book.getPrice());
			
			// SQL문 실행
			result = jdbc.pstmt.executeUpdate();
			
			if (result == 1) {
				System.out.println(result + "행이 추가되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 객체 닫기
			jdbc.close();
		}
			
		return result;
	
	}

	// 책 1개 조회
	public Book selectBook(int no) {
		Book book = null;
		
		// DB 연결
		JDBConnection jdbc = new JDBConnection();
		
		// sql문 만들기
		String sql = "select * from book where no = ?";
		
		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1,  no);
			
			// SQL문 실행
			jdbc.rs = jdbc.pstmt.executeQuery();
			
			// ResultSet 객체에서 결과값 가져와서 출력하기
			if (jdbc.rs.next()) {
				book = new Book(
						jdbc.rs.getInt("no"),
						jdbc.rs.getString("name"),
						jdbc.rs.getString("genre"),
						jdbc.rs.getString("author"),
						jdbc.rs.getString("publisher"),
						jdbc.rs.getInt("price")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return book;
	}

	// 책 목록 조회
	public List<Book> selectBookAll() {
		// DB 연결
		JDBConnection jdbc = new JDBConnection();
		
		// sql문 만들기
		String sql = "select * from book";
		
		// 결과를 저장할 List 객체를 생성
		List<Book> bookList = new ArrayList<>();
		
		
		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			// SQL문 실행
			jdbc.rs = jdbc.pstmt.executeQuery();
			
			// ResultSet 객체에서 결과값 가져와서 출력하기
			while (jdbc.rs.next()) {
				Book book = new Book(
						jdbc.rs.getInt("no"),
						jdbc.rs.getString("name"),
						jdbc.rs.getString("genre"),
						jdbc.rs.getString("author"),
						jdbc.rs.getString("publisher"),
						jdbc.rs.getInt("price")
						);
						
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
			
		} 
		return bookList;
	}

	// 책 가격 수정
	public int updateBook(Book book) {
		// DB 연결
		JDBConnection jdbc = new JDBConnection();
		
		// sql문 
		String sql = new StringBuilder()
				.append("update book ")
				.append("set price = ? ")
				.append("where no = ?")
				.toString();
		
		int result = 0;
		

		try {
			// PS 객체, 매개변수 set
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			jdbc.pstmt.setInt(1, book.getPrice());
			jdbc.pstmt.setInt(2, book.getNo());
			
			// sql 실행
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 수정되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return result;
	}
	
	// 책 1개 삭제
	public int deleteBook(int no) {
		int result = 0;
			
		// DB 연결
		JDBConnection jdbc = new JDBConnection();
			
		// sql문 만들기
		String sql = "delete book where no = ?";
			
			
		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
				
			// 파라미터 set
			jdbc.pstmt.setInt(1,  no);
				
			// sql 실행
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 삭제되었습니다.");
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
			
		return result;
	}
	
	
	
}
