package game.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor

public class Character {
		String userName;
//		int possessMoney;
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(userName);
//			builder.append("기존에 가진 금액 : ");
//			builder.append(possessMoney);

			return builder.toString();
		}
}
