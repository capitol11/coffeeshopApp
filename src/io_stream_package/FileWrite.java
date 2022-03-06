package io_stream_package;

import java.io.FileWriter;
import java.io.IOException;

// write a char in the txt file without "Overwrite"
public class FileWrite {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("C:/Users/Soohyun/Desktop/text_testfile.txt");
			
			fw.write("1");
			fw.close();
		} catch (IOException e) {
			System.out.println("IO Error.");
			e.printStackTrace();
		}
	
	}
}
