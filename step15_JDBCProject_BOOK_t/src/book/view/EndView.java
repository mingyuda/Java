package book.view;

import java.util.ArrayList;

public class EndView {
	// 리스트 출력
	public static void allListView(ArrayList arrayList){
		int length = arrayList.size();
		if( length != 0 ){
			for(int index = 0; index < length; index++){			
				System.out.println("검색정보 " + (index+1) + " - " + arrayList.get(index));
			}
		}
	}
	
	// 특정 객체 출력 
	public static void allView(Object object){
		System.out.println(object);
	}
	
	//예외 상황 출력
	public static void showError(String message){
		System.out.println(message);		
	}
	
}