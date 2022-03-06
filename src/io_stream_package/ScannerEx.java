package io_stream_package;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Scanner is an alternative to print out from a text file instead of FileReader. 
public class ScannerEx {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("C:/Users/Soohyun/Desktop/text_testfile.txt"));
			
			while(scanner.hasNext()) {
				String str = scanner.next();
				System.out.println(str); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
