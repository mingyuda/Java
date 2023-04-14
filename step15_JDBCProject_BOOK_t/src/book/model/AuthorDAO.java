package book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.dto.AuthorDTO;
import book.util.DBUtil;

public class AuthorDAO {
		// 작가 저장
		public static boolean addAuthor(AuthorDTO author) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("insert into author values(?, ?, ?, ?)");
				pstmt.setString(1, author.getName());
				pstmt.setString(2, author.getNationality());
				pstmt.setString(3, author.getAuthorId());
				pstmt.setInt(4, author.getBirth());

				int result = pstmt.executeUpdate();

				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}
		
		// 작가 정보 수정
		public static boolean updateAuthorByAuthorId(String authorId, String name) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();
				
				pstmt = con.prepareStatement("update author set name = ? where author_Id = ?");
				pstmt.setString(1, name);
				pstmt.setString(2, authorId);
				
				int result = pstmt.executeUpdate();
				if(result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}
		
		// 작가 id로 작가 삭제
		public static boolean deleteAuthorByAuthorId(String authorId) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("delete from author where author_id = ?");
				pstmt.setString(1, authorId);
				int result = pstmt.executeUpdate();
				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}
		
		// 작가 id로 작가 검색
		public static AuthorDTO getAuthorByAuthorId(String authorId) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			AuthorDTO author = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from author where author_id = ?");
				pstmt.setString(1, authorId);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					author = new AuthorDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return author;
		}
		
		public static  ArrayList<AuthorDTO> getAllAuthor() throws SQLException {
			Connection con= null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<AuthorDTO> list = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from author");
				rset = pstmt.executeQuery();
				
				list = new ArrayList<AuthorDTO>();
				while(rset.next()) {
					list.add(new AuthorDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4)));
				}
			}finally {
				DBUtil.close(con, pstmt, rset);
			}
			return list;
		}
		
		
}
