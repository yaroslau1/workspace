package stream_three;

import java.util.ArrayList;
import java.util.List;

public class CheckData {

	private String filePath;
	private List<Integer> dataToCheck = new ArrayList<>();

	public CheckData() {
	}

	public CheckData(String filePath) {
		this.filePath = filePath;
		FileConnect fileConnect = new FileConnect(filePath);
		dataToCheck = fileConnect.getDataFromFile();
	}

	void checkDataToError(int min, int max) {
		int j = 0;
		boolean isOk = true;
		for (int i = 0; i < dataToCheck.size()-1; i++) {
			if(dataToCheck.get(i+1) - dataToCheck.get(i) == 1) {

			}
			else if (dataToCheck.get(i+1) == min && dataToCheck.get(i) == max) {

			} else if(dataToCheck.get(i+1) == 111 && dataToCheck.get(i) == 67) {
				i+=29;
			}
			else {
				MainFrame.textArea.append("\n*****Error in string - " + i+1);
				MainFrame.textArea.append("\nVallue of previous string is - " + dataToCheck.get(i-1));
				MainFrame.textArea.append("\nVallue of this string is - " + dataToCheck.get(i));
				MainFrame.textArea.append("\nVallue of next string is - " + dataToCheck.get(i+1));
				j++;
				isOk = false;
			}
		}
		
		if(isOk) {
			MainFrame.textArea.append("\nErrors not found!");
		}
		else {
			MainFrame.textArea.append("\n**********************");
			MainFrame.textArea.append("\nTotal " + j + " errors! \n");
		}
	}	
}
