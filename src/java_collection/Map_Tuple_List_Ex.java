package java_collection;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * 튜플은 수와 순서가 고정된 데이터 구조. Map.Entry는 키와 값, 두 가지 요소를 저장하는 튜플. 
 * Map.Entry는 인터페이스이며 구현 클래스가 필요한데, AbstractMap.SimpleEntry를 살펴본다. 
 * **/

public class Map_Tuple_List_Ex {
	// static Map.Entry<String, Book> tuple;

	public static void main(String[] args) {
		// tuple = new AbstractMap.SimpleEntry<>("32443252", new Book("Effective Java 3d
		// Edition", "Joshua Bloch"));

		// 정렬 된 튜플 List
		List<Map.Entry<String, Book>> orderedTuples = new ArrayList<>();
		orderedTuples.add(
				new AbstractMap.SimpleEntry<>("9780134685991", new Book("Effective Java 3d Edition", "Joshua Bloch")));
		orderedTuples.add(new AbstractMap.SimpleEntry<>("9780132350884", new Book("Clean Code", "Robert C Martin")));
		orderedTuples.add(new AbstractMap.SimpleEntry<>("9780132350884", new Book("Clean Code", "Robert C Martin")));

		for (Map.Entry<String, Book> tuple : orderedTuples) {
			System.out.println("key: " + tuple.getKey() + " value: " + tuple.getValue().toString());
		}
	}
}

class Book {
	private String title;
	private String author;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + "]";
	}
	
	

}
