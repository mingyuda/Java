package step06.collection;


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
		
		
	}

}
