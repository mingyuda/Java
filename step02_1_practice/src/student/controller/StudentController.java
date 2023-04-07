package student.controller;

import student.dto.Student;
import student.model.StudentModel;
import student.view.EndView;


public class StudentController {

	public static void request(int reNum) {
		if(reNum == 1) {
			EndView.printAll((Student[]) StudentModel.getAll());
		}else if(reNum == 2) {
			EndView.printOne(StudentModel.getOne("KIM"));
		}
		
		
	}

}
