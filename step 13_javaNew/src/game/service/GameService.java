package game.service;

import java.util.ArrayList;

import game.dto.CharacterWithWeapon;
import game.exception.NotExistException;
import game.model.GameModel;

public class GameService {
	private static GameService instance = new GameService();
	private GameModel GameModelData = GameModel.getInstance();
	
	public GameService getInstance () {
		return instance;
	}
	
	//  검색_
		public CharacterWithWeapon getChar(String createName) throws NotExistException{
			CharacterWithWeapon creation = null;
			
			ArrayList<CharacterWithWeapon> characterList = GameModelData.getCharacters();
			for(int i = 0; i < characterList.size(); i++) {
				if(characterList.get(i).getJob().equals(createName)) {
					System.out.println("캐릭터 생성 중 입니다.");
					creation = characterList.get(i);
				}
			}
			
			if(creation == null) {
				throw new NotExistException("마법사, 도적, 전사 중에서 입력해주세요 \n오류내어 다시 시작하는 건 구현이 안되어 있으니 다시 실행시켜주세요ㅠ");
			}
			return creation;
		}

		public void CreateChar(CharacterWithWeapon newCharacterWithWeapon) {
			GameModelData.makingCharacter(newCharacterWithWeapon);
			
		}

		public void charInsert(Object createChar) {
			GameModelData.insertCharacter(createChar);
			
		}

//		public void viewOnly(CharacterWithWeapon searchName) {
//			
//		}
	
	
	
	
}
