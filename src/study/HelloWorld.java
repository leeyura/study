package study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HelloWorld {


    public static void main(String[] args) {
   
        File file = new File("D:\\workspace\\study\\src\\study\\readme.txt");
        
        try {
            InputStream is = new FileInputStream(file);
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));

            String str;

            while((str = bis.readLine()) != null) {
                System.out.println(str);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}