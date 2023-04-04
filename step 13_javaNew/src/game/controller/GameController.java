package game.controller;


import game.dto.Character;
import game.dto.CharacterWithWeapon;
import game.exception.NotExistException;
import game.service.GameService;
import game.view.EndView;

public class GameController {
	private static GameController instance = new GameController();
	private GameService service = new GameService();
	
	public static GameController getInstance() {
		return instance;
	}
	
	
	// 특정 캐릭터 검색
		public void View(String createtName) {
			CharacterWithWeapon creation = null;
			try {
				creation = service.getChar(createtName);
				EndView.View(creation); 
			} catch (NotExistException e) {
				EndView.messageView(e.getMessage());
			}
		}

		
		// 
		public void createChar(CharacterWithWeapon newCharacterWithWeapon) {
			service.CreateChar(newCharacterWithWeapon);
		}

}
