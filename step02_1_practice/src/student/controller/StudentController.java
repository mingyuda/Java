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
		}else if(reNum == 3) {
			boolean b = StudentModel.insert(new Student("Ji", 3, "economics"));
			if(b) {
				EndView.printSuccess("등록 완료");
			} else {
				EndView.printFail("등록 실패");}
		} else if(reNum == 4){
			boolean b = StudentModel.delete("Ji"); 
			if(b) {
				EndView.printSuccess("삭제 완료");
			}else {
				EndView.printFail("삭제 실패");
			}
				
		}
	}

}
