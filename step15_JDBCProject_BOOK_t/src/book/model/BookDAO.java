package book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.dto.BookDTO;
import book.util.DBUtil;

public class BookDAO {
	
	
	// 새로운 책 저장
	public static boolean addBook(BookDTO book) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into book values(?, ?, ?, ?, ?)");
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getPublisher());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getAuthorId());
			pstmt.setString(5, book.getIsbn());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// isbn으로 책 가격 수정
	public static boolean updateBookByIsbn(String isbn, int price) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update book set price = ? where isbn = ?");
			pstmt.setInt(1, price);
			pstmt.setString(2, isbn);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// isbn으로 책 삭제
	public static boolean deleteBookByIsbn(String isbn) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from book where isbn = ?");
			pstmt.setString(1, isbn);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 모든 책 검색
	public static ArrayList<BookDTO> getAllBooks() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookDTO> bookList = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from book");
			rset = pstmt.executeQuery();
			
			bookList = new ArrayList<BookDTO>();
			while(rset.next()) {
				bookList.add(new BookDTO(rset.getString(1),
										rset.getString(2),
										rset.getInt(3),
										rset.getString(4),
										rset.getString(5)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return bookList;
	}
	
	// isbn으로 책 검색
	public static BookDTO getBookByIsbn(String isbn) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BookDTO book = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from book where isbn = ?");
			pstmt.setString(1, isbn);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				book = new BookDTO(rset.getString(1),
									rset.getString(2),
									rset.getInt(3), 
									rset.getString(4),
									rset.getString(5));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return book;
	}

	// 고객 id로 고객이 주문한 책 목록 검색
	public static ArrayList<BookDTO> getBookByCustomerId(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookDTO> bookList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from book where isbn IN(select isbn "
										+ "from order_list where customer_id = ?)");
			pstmt.setString(1, customerId);
			rset = pstmt.executeQuery();
			
			bookList = new ArrayList<BookDTO>();
			while(rset.next()) {
				bookList.add(new BookDTO(rset.getString(1),
											rset.getString(2),
											rset.getInt(3),
											rset.getString(4),
											rset.getString(5)));
			}
				
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return bookList;
	}
}
