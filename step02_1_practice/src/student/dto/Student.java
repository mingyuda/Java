package student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Student {
	private String name;
	private int grade;
	private String major;
	
	public void setAge(int Age) {
		if(grade > 0 && grade <4) {
			this.grade = grade;
		}else {
			System.out.println("1학년 부터 3학년까지 있습니다.");
		}
	}
	public String toString() {
		return name + " " + grade + " " + major;
	}
}
