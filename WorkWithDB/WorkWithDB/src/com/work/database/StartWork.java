package com.work.database;

import java.util.Scanner;

public class StartWork {
	
	Scanner scanner = new Scanner(System.in);
	
	public StartWork() {
	}
	
	public void startWork() {
		do {
			showMenu();
		}while(chose());
	}
	
	public void showMenu() {
		System.out.println("Press 1 to show data from DB");
		System.out.println("Press 2 to add items to DB");
		System.out.println("Press 3 to delete item from DB");
		System.out.println("Press 0 to EXIT");
	}
	
	public boolean chose() {
		boolean out = true;
		switch(scanner.nextInt()) {
		case 1:
		case 2:
		case 3:
		case 0:
			out = false;
			break;
		}
		
		return out;
		
	}

}
