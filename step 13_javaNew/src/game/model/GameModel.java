package game.model;

import java.util.ArrayList;
import game.dto.Character;
import game.dto.CharacterWithWeapon;
import game.dto.Store;


public class GameModel {
	private static GameModel instance = new GameModel();
	private ArrayList<Character> character = new ArrayList<>();
	private ArrayList<CharacterWithWeapon> mainCharacter = new ArrayList<>(); //여기 static이면 작동이 안되네
	
	
	public static GameModel getInstance() {
		return instance;
	}
	
	
	
	private GameModel() {
		mainCharacter.add(new CharacterWithWeapon("마법사", new Character("입력하세요"), new Store("입력하세요", 0), 0));
		mainCharacter.add(new CharacterWithWeapon("전사", new Character("입력하세요"), new Store("입력하세요", 0), 0));
		mainCharacter.add(new CharacterWithWeapon("도적", new Character("입력하세요"), new Store("입력하세요", 0), 0));
	}
	

	// 캐릭터 반환
	public ArrayList<CharacterWithWeapon> getCharacters() {
		return mainCharacter;
	}



	// 캐릭터 생성
	public void makingCharacter(CharacterWithWeapon newCharacterWithWeapon) {
		System.out.println(newCharacterWithWeapon);
		
	}
	


}
