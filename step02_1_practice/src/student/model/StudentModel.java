package student.model;

import student.dto.Student;

public class StudentModel {

	//DB역할 
	// private을 해서 다른 곳에서 이것을 건들지 못하게 함.
	// singleton?
	private static Student[] allData = new Student[7];
	private static int index;
	
	
	static {
		allData[0] = new Student("KIM", 2, "MBE");
		allData[1] = new Student("LEE", 1, "ComputerScience");
		allData[2] = new Student("KIM", 2, "Architect");
		index = 3;
	}
	
	
	public static Object getAll() {
		return allData;
	}

}
