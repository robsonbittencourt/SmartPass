package helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteFile {
	
	public File writeInFile(String text) {
	    try {
	      File file = new File("credentials.txt");
	      BufferedWriter output = new BufferedWriter(new FileWriter(file));
	      output.write(text);
	      output.close();
	      return file;
	    } catch (IOException e) {
	       e.printStackTrace();
	    }
		return null;
	}
}
