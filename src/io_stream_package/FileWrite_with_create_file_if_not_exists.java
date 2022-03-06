package io_stream_package;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// write a char in the txt file without "Overwrite"
public class FileWrite_with_create_file_if_not_exists {
	public static void main(String[] args) {
		FileWriter fw = null;

		try {
			File file = new File("C:/Users/Soohyun/Desktop/text_testfile.txt");
			if(file.exists())
				fw = new FileWriter(file);
			else
				file.createNewFile();
			fw.write("Test..");
			fw.close();
		} catch (IOException e) {
			System.out.println("IO Error.");
			e.printStackTrace();
		}
	
	}
}
