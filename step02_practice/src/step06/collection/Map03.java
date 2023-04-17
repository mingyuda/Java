package step06.collection;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Map03 {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("KIM", 1);
		hm.put("Lee", 2);
		hm.put("Jang", 3);
		
		System.out.println(hm);
		
		System.out.println(hm.get("KIM"));
		hm.remove("Lee");
		System.out.println(hm);
		
		System.out.println(hm.values());
		
		System.out.println(hm.keySet().getClass());
		
		System.out.println(hm.entrySet());
		System.out.println(hm.values());
		
		for(Entry<String, Integer> entry : hm.entrySet()) {
			System.out.println(entry.getValue());
		}
		
		
		
		// ArrayList와 Hashmap 
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("kim");
		arr.add("lee");
		arr.add("park");
		arr.add("kwon");
		
		HashMap<String, ArrayList<String>> hm1 = new HashMap<String, ArrayList<String>>();
		hm1.put("arr", arr);
		
		System.out.println(hm1);
		System.out.println(hm1.get("arr").get(1));
		
		//hm1을 또다시 해시맵에 넣기
		
		HashMap<String, HashMap<String, ArrayList<String>>> hm2 = new HashMap<String, HashMap<String,ArrayList<String>>>();
		hm2.put("hm1", hm1);
		System.out.println(hm2);
		System.out.println(hm2.get("hm1").get("arr").get(1).charAt(1));
		
		
		
		
		
	}

}
