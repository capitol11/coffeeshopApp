package io_stream_package;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// print out the whole text from txt file one by one. 
public class FileRead {
	public static void main(String[] args) throws IOException {
		try {
			FileReader fr = new FileReader("C:/Users/Soohyun/Desktop/text_testfile.txt");
			int ch;
			while((ch=fr.read())!=-1) {   // -1 = the end of text. 
				System.out.println((char)ch);
			}
			
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
