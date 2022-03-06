package java_collection;

import java.util.HashMap;
import java.util.Map;


/*
 * ���� �̿��� �����͸� �����ϰ� �ҷ����� �� ���� ����� �Ұ�. 
 * 
 * **/

public class Map_repeat_opt {

	public static void main(String[] args) {		
		
		Map<String, String> map = new HashMap<>();
		map.put("Robert Martin", "Clean Code");
		map.put("Joshua bloch", "Effective Java");
		
		// 1. Map.keySet ���
//		for(String key : map.keySet()) {
//			System.out.println("key: " + key + " value: " + map.get(key)); 
//		}
		 
		/*
		 * �ʿ� Ű�� �������� ��� 1���� ������. �׷��� Ű�� ���� ���� ���� 2���� �� ����.
		 * 1���� ��� keySet�� �ݺ��ϰ� �ǰ�, �� Ű�� �������� �� �Ŀ� Ű�� ���� ���� ��ȸ�Ѵ�.  
		 * **/
		
		// 2. Map.entrySet ��� 
		for(Map.Entry<String, String> book: map.entrySet()) {
			System.out.println("key: " + book.getKey() + " value: " + book.getValue());
		}
		
		/*
		 * 2���� ��� map.Entry�� ��ü �÷��ǿ� �����ϴµ�, map.Entry�� ���� Ű�� �� ��� �� ���� �������� ��´�. 
		 * **/
	}

}
