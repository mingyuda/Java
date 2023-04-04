package game.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor

public class Store {
	String equipment;
	int ePrice;
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(equipment);
		builder.append("/ 무기 가격 : ");
		builder.append(ePrice);

		return builder.toString();
	}
	
}
