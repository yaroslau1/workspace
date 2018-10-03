package streamOne;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try{
			File file = new File("D://text8.txt");
			if(!file.exists()){			//проверка файла на существование
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file,true); //с тру будет не перезаписывать, а добавлять новую инфу
			writer.write("Hi");
			writer.close();			
		} catch (IOException e) {			
			e.printStackTrace();
		}	
		

	}

}
