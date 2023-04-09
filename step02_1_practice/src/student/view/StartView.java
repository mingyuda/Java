package student.view;

import student.controller.StudentController;

public class StartView {

	public static void main(String[] args) {
//		System.out.println("=== 학생 기록부 열람 ===");
//		StudentController.request(1);
//		System.out.println("=== 특정 학생 열람 ===");
//		StudentController.request(2);
		System.out.println("=== 특정 학생 등록 ===");
		StudentController.request(3);
		StudentController.request(1);
		
	}

}
