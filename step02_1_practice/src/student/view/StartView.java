package student.view;

import student.controller.StudentController;

public class StartView {

	public static void main(String[] args) {
		System.out.println("=== 학생 기록부 열람 ===");
		StudentController.request(1);
		

	}

}
