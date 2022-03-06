package java_collection;

import java.util.HashMap;
import java.util.Map;


/*
 * 맵을 이용해 데이터를 저장하고 불러오는 두 가지 방법을 소개. 
 * 
 * **/

public class Map_repeat_opt {

	public static void main(String[] args) {		
		
		Map<String, String> map = new HashMap<>();
		map.put("Robert Martin", "Clean Code");
		map.put("Joshua bloch", "Effective Java");
		
		// 1. Map.keySet 사용
//		for(String key : map.keySet()) {
//			System.out.println("key: " + key + " value: " + map.get(key)); 
//		}
		 
		/*
		 * 맵에 키만 가져오는 경우 1번이 빠르다. 그러나 키와 값을 얻을 때는 2번이 더 좋다.
		 * 1번의 경우 keySet을 반복하게 되고, 각 키를 가져오고 난 후에 키를 통해 값을 조회한다.  
		 * **/
		
		// 2. Map.entrySet 사용 
		for(Map.Entry<String, String> book: map.entrySet()) {
			System.out.println("key: " + book.getKey() + " value: " + book.getValue());
		}
		
		/*
		 * 2번의 경우 map.Entry가 객체 컬렉션에 존재하는데, map.Entry를 통해 키와 값 모두 한 번의 조작으로 얻는다. 
		 * **/
	}

}
