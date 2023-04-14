package book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.dto.BookDTO;
import book.dto.CustomerDTO;
import book.util.DBUtil;


public class CustomerDAO {
	
	
	// 고객 저장
	public static boolean addCustomer(CustomerDTO customer) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into customer values(?, ?)");
			pstmt.setString(1, customer.getCustomerId());
			pstmt.setInt(2, customer.getPhoneNum());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 고객 정보 수정
	public static boolean updateCustomerByCustomerId(String customerId, int phoneNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update customer set phone_num = ? where customer_id = ?");
			pstmt.setInt(1, phoneNum);
			pstmt.setString(2, customerId);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 고객 id로 고객 삭제
	public static boolean deleteCustomerByCustomerId(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from customer where customer_id = ?");
			pstmt.setString(1, customerId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 모든 고객 검색
	public static ArrayList<CustomerDTO> getAllCustomers() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CustomerDTO> customerList = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from customer");
			rset = pstmt.executeQuery();
			
			customerList = new ArrayList<CustomerDTO>();
			while(rset.next()) {
				customerList.add(new CustomerDTO(rset.getString(1), rset.getInt(2)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return customerList;
	}
	
	// 고객 id로 고객 검색
	public static CustomerDTO getCustomerByCustomerId(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CustomerDTO customer = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from customer where customer_id = ?");
			pstmt.setString(1, customerId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				customer = new CustomerDTO(rset.getString(1), rset.getInt(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return customer;
	}
}