package book.service;

import java.sql.SQLException;
import java.util.ArrayList;

import book.dto.AuthorDTO;
import book.dto.BookDTO;
import book.dto.CustomerDTO;
import book.dto.OrderListDTO;
import book.exception.NotExistException;
import book.model.AuthorDAO;
import book.model.BookDAO;
import book.model.CustomerDAO;
import book.model.OrderListDAO;

public class BookService {
	private static BookService instance = new BookService();
	
	public static BookService getInstance() {
		return instance;
	}
	
	// Customer - CRUD
	public void notExistCustomer(String customerId) throws NotExistException, SQLException{
		CustomerDTO customer = CustomerDAO.getCustomerByCustomerId(customerId);
		if(customer == null){
			throw new NotExistException("존재하지 않는 ID입니다.");
		}
	}
	
	// 모든 고객 검색
	public ArrayList<CustomerDTO> getAllCustomers() throws SQLException {
		return CustomerDAO.getAllCustomers();
	}

	// 고객 id로 고객 검색
	public CustomerDTO getCustomerByCustomerId(String customerId) throws SQLException, NotExistException {
		notExistCustomer(customerId);
		return CustomerDAO.getCustomerByCustomerId(customerId);
	}
	
	// 새로운 고객 저장 
	public boolean addCustomer(CustomerDTO customer) throws NotExistException, SQLException {
		// 만약 같은 아이디의 고객이 존재한다면
//			if(!notExistCustomer(customer.getCustomerId())) {
//				throw new NotExistException("이미 존재하는 ID입니다.");
//			}
		return CustomerDAO.addCustomer(customer);
	}
	
	// 고객 정보 수정
	public boolean updateCustomerBycustomerId(String customerId, int phoneNum) throws NotExistException, SQLException {
		notExistCustomer(customerId);
		return CustomerDAO.updateCustomerByCustomerId(customerId, phoneNum);
	}
	
	// 고객id로 고객 삭제
	public boolean deleteCustomerByCustomerId(String customerId) throws NotExistException, SQLException {
		notExistCustomer(customerId);
		return CustomerDAO.deleteCustomerByCustomerId(customerId);
	}
	
	// Book - CRUD
	public void notExistBook(String isbn) throws NotExistException, SQLException{
		BookDTO book = BookDAO.getBookByIsbn(isbn);
		if(book == null){
			throw new NotExistException("검색하신 책이 존재하지 않습니다.");
		}
	}
	
	// 모든 Book 정보 반환
	public ArrayList<BookDTO> getAllBooks() throws SQLException {
		return BookDAO.getAllBooks();
	}	
	
	// Book isbn으로 검색
	public BookDTO getBookByIsbn(String isbn) throws SQLException, NotExistException {
		notExistBook(isbn);
		return BookDAO.getBookByIsbn(isbn);
	}
	
	// 고객 id로 주문 책 목록 검색 
	public ArrayList<BookDTO> getBookByCustomerId(String customerId) throws SQLException {
//		notExistOrder(customerId);
		
		
		return BookDAO.getBookByCustomerId(customerId);
	}
	
	// 새로운 책 저장
	public boolean addBook(BookDTO book) throws SQLException{
		return BookDAO.addBook(book);
	}
	
	// isbn으로 책 가격 수정
	public boolean updateBookByIsbn(String isbn, int price) throws NotExistException, SQLException {
		notExistBook(isbn);
		return BookDAO.updateBookByIsbn(isbn, price);
	}
	
	// isbn으로 책 삭제
	public boolean deleteBookbyIsbn(String isbn) throws SQLException, NotExistException {
		notExistBook(isbn);
		return BookDAO.deleteBookByIsbn(isbn);
	}
	
	// Exception - customerId로 주문 내역 검색 
	public void notExistException(String customerId) throws NotExistException, SQLException{
		ArrayList<OrderListDTO> orderList = OrderListDAO.getOrderListByCustomerId(customerId);
		if(orderList == null){
			throw new NotExistException("주문 내역이 없습니다.");
		}
	}
	
	// Exception - orderNum은로 주문 내역 검색
	public void notExistException(int orderNum) throws NotExistException, SQLException{
		OrderListDTO orderList = OrderListDAO.getOrderListByOrderNum(orderNum);
		if(orderList == null){
			throw new NotExistException("주문 내역이 없습니다.");
		}
	}

	// 고객 id로 주문 내역 검색
	public ArrayList<OrderListDTO> getOrderList(String customerId) throws SQLException, NotExistException {
		notExistException(customerId);
		return OrderListDAO.getOrderListByCustomerId(customerId);
	}
	
	// 새로운 주문 저장
	public boolean addOrder(OrderListDTO newOrder) throws SQLException {
		return OrderListDAO.addOrderList(newOrder);
	}
	
	// 주문 내역 수정
	public boolean updateOrderList(int orderNum, String isbn) throws SQLException, NotExistException {
		notExistException(orderNum);
		return OrderListDAO.updateOrderListByOrderNum(isbn, orderNum);
	}
	
	// 주문 삭제
	public boolean deleteOrderList(int orderNum) throws SQLException {
		return OrderListDAO.deleteOrderListByOrderNum(orderNum);
		
	}
	
	// 모든 주문 내역 출력
	public ArrayList<OrderListDTO> getAllOrderList() throws SQLException {
		return OrderListDAO.getAllOrderList();
	}

	// Author - CRUD
	public void notExistAuthor(String AuthorId) throws SQLException, NotExistException {
		AuthorDTO author = AuthorDAO.getAuthorByAuthorId(AuthorId);
		if(author == null){
			throw new NotExistException("검색하신 작가 정보가 없습니다.");
		}
	}
		
	// 기존 작가 수정
	public boolean updateAuthor(String AuthorId, String name) throws SQLException, NotExistException{
		notExistAuthor(AuthorId);
		return AuthorDAO.updateAuthorByAuthorId(AuthorId, name);
	}
	
	// 작가 삭제
	public boolean deleteAuthor(String AuthorId) throws SQLException, NotExistException{
		notExistAuthor(AuthorId);
		return AuthorDAO.deleteAuthorByAuthorId(AuthorId);
	}

	// 작가 id로 검색
	public AuthorDTO getAuthorByAuthorId(String AuthorId) throws SQLException, NotExistException{
		return AuthorDAO.getAuthorByAuthorId(AuthorId);
	}
	
	// 새로운 작가 저장
	public boolean addAuthor(AuthorDTO author) throws SQLException {
		return AuthorDAO.addAuthor(author);
	}
	
	// 모든 작가 검색
	public static ArrayList<AuthorDTO> getAllAuthor() throws SQLException{
		return AuthorDAO.getAllAuthor();
	}
	
	// 주문 내역이 2개 이상이면 제일 오래된 주문 내역 삭제하고 추가하는 메서드
	public boolean Over2Delete(OrderListDTO orderList) throws SQLException {
		return OrderListDAO.Over2Delete(orderList);
	}

}
