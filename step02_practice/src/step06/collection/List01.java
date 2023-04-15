package step06.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class List01 {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		
		arr.add("KIM");
		arr.add("kkkk");
		
		System.out.println(arr);
		
		System.out.println(arr.get(0));
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(i + "번째 값은 : " + arr.get(i));
		}
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).charAt(0)); 
		}
//		arr.remove(arr.get(1));
		System.out.println(arr);
		arr.remove(arr); // 정해주지 않으면 삭제 안하는 듯
		System.out.println(arr);
		
		// LinkedList
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("Kim");
		list.add("Lee");
		list.add("Kwon");
		System.out.println();
		System.out.println(list);
		list.set(1, "KIM");
		System.out.println(list);
		System.out.println(list.get(1));
		
		
		
	}

}
