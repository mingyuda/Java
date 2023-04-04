package game.view;

import game.dto.CharacterWithWeapon;

public class EndView {

	public static void View(CharacterWithWeapon creation) {
		if(creation != null) {
			System.out.println(creation);
		}
		
	}

	public static void messageView(String message) {
		System.out.println(message);
		
	}

}
