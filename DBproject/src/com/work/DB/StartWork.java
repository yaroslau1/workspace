package com.work.DB;

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
		System.out.println("\nPress 1 to show data from DB");
		System.out.println("Press 2 to add items to DB");
		System.out.println("Press 3 to delete item from DB");
		System.out.println("Press 0 to EXIT");
	}

	public boolean chose() {
		boolean out = true;
		switch(scanner.nextInt()) {
		case 1:
			showDB();
			break;
		case 2:
			addItems();
			break;
		case 3:
			break;
		case 0:
			out = false;
			System.out.println("Bye !");
			break;
		}

		return out;

	}
	
	private void addItems() {
		System.out.println("***Add items to DB***");
		System.out.println("Enter name : ");
		String name = scanner.next();
		System.out.println("Enter age : ");
		int age = scanner.nextInt();
		ShowAll.addValues(name, age);
	}

	public void showDB() {
		System.out.println("\n***Show data from DB***");
		ShowAll.showFromDB();
		System.out.println("***********************");
	}

}
