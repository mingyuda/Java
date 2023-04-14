package book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.dto.OrderListDTO;
import book.util.DBUtil;

public class OrderListDAO {
	public static boolean addOrderList(OrderListDTO orderList) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into order_list values(?, ?)");
			pstmt.setString(1, orderList.getCustomerId());
			pstmt.setString(2, orderList.getIsbn());
			pstmt.setInt(3, orderList.getOrderNum());

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
	public static boolean updateOrderListByOrderNum(String isbn, int orderNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update order_list set isbn = ? where order_num = ?");
			pstmt.setString(1, isbn);
			pstmt.setInt(2, orderNum);
			
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
	public static boolean deleteOrderListByOrderNum(int orderNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from order_list where order_num = ?");
			pstmt.setInt(1, orderNum);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 고객 id로 주문목록 검색
	public static ArrayList<OrderListDTO> getOrderListByCustomerId(String customerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<OrderListDTO> orderList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from order_list where customer_id = ?");
			pstmt.setString(1, customerId);
			rset = pstmt.executeQuery();
			
			orderList = new ArrayList<>();
			while(rset.next()) {
				orderList.add(new OrderListDTO(rset.getString(1), rset.getString(2), rset.getInt(3)));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return orderList;
	}
	
	public static OrderListDTO getOrderListByOrderNum(int orderNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		OrderListDTO orderList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from order_list where order_num = ? order by order_num");
			pstmt.setInt(1, orderNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				orderList = new OrderListDTO(rset.getString(1), rset.getString(2), rset.getInt(3));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return orderList;
	}
	
	public static ArrayList<OrderListDTO> getAllOrderList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<OrderListDTO> orderList= null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from order_list order by order_num");
			rset = pstmt.executeQuery();
		
		orderList = new ArrayList<OrderListDTO>();
		while(rset.next()) {
			orderList.add(new OrderListDTO(rset.getString(1),
											rset.getString(2),
											rset.getInt(3)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return orderList;
	}
	
	public static boolean Over2Delete(OrderListDTO orderList) throws SQLException {
		// 파라미터로 들어온 orderList의 customerId로 주문 내역 출력
		ArrayList<OrderListDTO> list = getOrderListByCustomerId(orderList.getCustomerId());
		// 주문 내역이 2개  초과이면
		if(list.size() >= 2) {
			// 1. 가장 오래된 주문 삭제
			deleteOrderListByOrderNum(list.get(0).getOrderNum());
			// 2. 주문 추가
			addOrderList(orderList);
		}
		return false;
	}
}
