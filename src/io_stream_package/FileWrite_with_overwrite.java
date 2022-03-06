package io_stream_package;

import java.io.FileWriter;
import java.io.IOException;

// write a char in the txt file with "overwrite".  
public class FileWrite_with_overwrite {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("C:/Users/Soohyun/Desktop/text_testfile.txt", true);
			
			for (int i = 0; i < 10; i++) {
				String text = i+"st Element";
				fw.write(text);
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("IO Error.");
			e.printStackTrace();
		}
	
	}
}
