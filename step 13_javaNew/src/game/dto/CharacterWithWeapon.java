package game.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor

public class CharacterWithWeapon {
	private String job;
	private Character character;
	private Store store;
	private int money;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("당신의 직업은 ");
		builder.append(job);
		builder.append("/ 플레이어 : ");
		builder.append(character);
		builder.append("/ 무기: ");
		builder.append(store);
		builder.append("/ 현재 가진 금액 : ");
		builder.append(money);
		return builder.toString();
	
	}
	
}
