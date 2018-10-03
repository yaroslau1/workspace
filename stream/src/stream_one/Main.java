package stream_one;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		try{
			String str = "D:\\text2.txt";
			File file = new File(str);
			if(!file.exists()){			//проверка файла на существование
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file,true); //с тру будет не перезаписывать, а добавлять новую инфу
			writer.write("Hi \n");
			writer.close();	
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
	        String line = null;
	            while ( (line = reader.readLine()) != null ){
	                System.out.println(line);
	            }
		} catch (IOException e) {			
			e.printStackTrace();
		}		

	}

}