package io_stream_package;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * BufferedReader uses buffers (default 8KB) to read text from a file than FileReader.
 * It's generally more efficient than FileReader. 
 * */
public class FileRead_with_BufferedReader {
	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/Soohyun/Desktop/text_testfile.txt"));
			
			String str;
			while((str = br.readLine())!=null) {
				System.out.println(str); 
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
