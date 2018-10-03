package stream_three;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileConnect {
	
	private String filePath;
	
	public FileConnect() {
	}
	
	public FileConnect(String filePath) {
		this.filePath = filePath;
	}

	List<Integer> getDataFromFile() {
		List<Integer> intFromFile = new ArrayList<>();

		try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))){
			File file = new File(filePath);
			
			if(!file.exists()){		
				file.createNewFile();
			}

			String line = null;
			int parseInt = 0;
			while ( (line = reader.readLine()) != null ){
				parseInt = Integer.parseInt(line, 16);
				intFromFile.add(parseInt);
			}		

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 

		return intFromFile;
	}

}
