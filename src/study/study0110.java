package study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class study0110 {
	
	public static void main(String[]args) throws IOException{
	
		args[0] = "123";
		args[0] = "456";
		try {
			FileInputStream  fis = new FileInputStream(args[0]);
			FileOutputStream fos= new FileOutputStream(args[1]);
			
			int data = 0;
			
			while ((data=fis.read()) != 1 ) {
				fos.write(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
