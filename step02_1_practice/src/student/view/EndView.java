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

}
