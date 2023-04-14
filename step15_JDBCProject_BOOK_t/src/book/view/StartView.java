package book.view;

import book.controller.BookController;

public class StartView {
	
	public static void main(String[] args) {
		BookController controller = BookController.getInstance();
		
	//	System.out.println("=====모든 고객 검색=====");
		controller.allCustomers();
		
	//	System.out.println("=====고객id로 고객 검색=====");
		controller.getCustomerByCustomerId("hongdong1");		
	//	
	//	System.out.println("=====새로운 고객 정보 저장=====");
	//	controller.addCustomer(new CustomerDTO("whoareu", 112345586));
	//	
	//	System.out.println("=====고객 정보 수정=====");
	//	controller.updateCustomerByCustomerId("hongdong1", 1921234556);
	//	controller.allCustomers();
	//	
	//	System.out.println("=====고객 id로 고객 삭제=====");
	//	controller.deleteCustomerByCustomerId("whoareu");
	//	controller.allCustomers();
		
	//	System.out.println("=====모든 책 목록 검색=====");
	//	controller.allBooks();
		
	//	System.out.println("=====isbn으로 특정 책 검색=====");
	//	controller.getBookByIsbn("9788970128856");
		
	//	System.out.println("=====고객 id로 주문 책 목록 검색=====");
	//	controller.getBookByCustomerId("hongdong1");
		
	//	System.out.println("=====새로운 책 저장=====");
	//	controller.addBook(new BookDTO("아몬드", "창비", 15800, "odrk", "12947471901"));
	//	controller.allBooks();
		
	//	System.out.println("=====특정 책 가격 수정=====");
	//	controller.updateBookByIsbn("9788970128856", 50000);
	//	controller.getBookByIsbn("9788970128856");
		
	//	System.out.println("=====isbn으로 특정 책 삭제=====");
	//	controller.deleteBookByIsbn("12947471901");
	//	controller.allBooks();
	//	controller.getBTProject("bt1");
		
		// 모든 주문서 출력
	//	System.out.println("===== 전체 출력(관리자용) =====");
	//	controller.allOrderList();
		
		// 고객 id를 통한 주문 확인
	//	System.out.println("===== 고객 id를 통한 주문확인 =====");
	//	controller.getOrderList("hongdong1");
	//	
	//	//새로운 주문
	//	OrderListDTO newOrder = new OrderListDTO("hongdong1", "9791185014852", 7);
	//	// 주문 추가
	//	// isbn은 13자리
	//	System.out.println("===== 고객 주문 추가 =====");
	//	controller.Over2Delete(newOrder);
	//	
	//	System.out.println("-------");
	//	controller.getOrderList("hongdong1");
	
		// 주문번호를 통한 isbn 변경
	//	System.out.println("===== 주문번호를 통한 isbn 변경(관리자용) =====");
	//	controller.updateOrderList(4, "9791185014852");
		
		// 주문번호를 통한 주문 삭제
	//	System.out.println("===== 주문번호를 통한 isbn 변경(관리자용) =====");
	//	controller.deleteOrderList(3);
	//	controller.getOrderList("cheolk23");
		
	//	controller.allAuthor();
	
	//	controller.getAuthorByAuthorId("odrk");
		
	//	controller.updateAuthorByAuthorId("harari12", "하라리");
		
	//	controller.addAuthor(new AuthorDTO("이름", "한국", "korea12", 2023));
	//	controller.allAuthor();
	}
}
