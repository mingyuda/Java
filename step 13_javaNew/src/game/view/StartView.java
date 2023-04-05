package game.view;

import java.util.Scanner;

import game.controller.GameController;
import game.dto.Character;
import game.dto.CharacterWithWeapon;
import game.dto.Store;

public class StartView {
	
	
	public static void main(String[] args) {
		
		GameController controller = GameController.getInstance();
				
		System.out.println("====== 직업으로 캐릭터 검색기능 ======");
		Scanner sc = new Scanner(System.in);
		String searchName = sc.next();
		controller.View(searchName);
		
		System.out.println("====== 닉네임 선택 ======");
		String newPlayerName = sc.next();
		controller.createChar(new CharacterWithWeapon(searchName, new Character(newPlayerName), new Store("입력하세요", 0), 0));
		
		// 무기 선택과 동시에 데이터 저장 시도
		System.out.println("====== 무기 선택 ======");
		String newEquip = sc.next();
		controller.createChar(new CharacterWithWeapon(searchName, new Character(newPlayerName), new Store(newEquip, 3500), 0));
		controller.insertChar(new CharacterWithWeapon(searchName, new Character(newPlayerName), new Store(newEquip, 3500), 0));
		
		// 캐릭터 출력
		System.out.println("====== 내 캐릭터 ======");
		controller.createChar(new CharacterWithWeapon(searchName, new Character(newPlayerName), new Store(newEquip, 3500), 0));
		
	}

}
