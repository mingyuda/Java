package student.view;

import student.dto.Student;

public class EndView {

	public static void printAll(Student [] all) {
		for(int i = 0; i < all.length; i++) {
			if(all[i] != null) {
				System.out.println(all[i]);
			}
		}
		
	}

	public static void printOne(Student student) {
		if(student != null) {
			System.out.println(student);
		}else {
			System.out.println("검색한 학생 없음");
		}
		
	}

}
