package java_collection;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Ʃ���� ���� ������ ������ ������ ����. Map.Entry�� Ű�� ��, �� ���� ��Ҹ� �����ϴ� Ʃ��. 
 * Map.Entry�� �������̽��̸� ���� Ŭ������ �ʿ��ѵ�, AbstractMap.SimpleEntry�� ���캻��. 
 * **/

public class Map_Tuple_List_Ex {
	// static Map.Entry<String, Book> tuple;

	public static void main(String[] args) {
		// tuple = new AbstractMap.SimpleEntry<>("32443252", new Book("Effective Java 3d
		// Edition", "Joshua Bloch"));

		// ���� �� Ʃ�� List
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
