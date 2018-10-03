package com.work.electronicsStore.application;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.work.electronicsStore.controller.Controller;
import com.work.electronicsStore.electronics.Electronics;

public class Application {
	private Controller controller = new Controller();
	Scanner userActions = new Scanner(System.in);
	
	public Application() {
	}
	
	public void start() {
		System.out.println("Welcome to the Electronic Store!");
		do {
			showMenu();
		} while(choise());
		
	}
	
	public void showMenu() {
		System.out.println("Enter 1 to show all store");
		System.out.println("Enter 2 to add position");
		System.out.println("Enter 3 for search by type");
		System.out.println("Enter 0 to EXIt");
	}
	
	public boolean choise() {
	
		int userAction = userActions.nextInt();
		
		switch(userAction){
			case 1:
				showAll();
				break;
			case 2:
				add();
				break;
			case 3:
				search();
				break;
			case 0:
				return exit();
		default:
				break;
		}
		return true;
		
	}

	public boolean exit() {
		System.out.println("Good bye!");
		return false;
	}
	
	public void showAll() {
		System.out.println("***Shows ALL items***");
		List<Electronics> items = controller.showAll();
		System.out.println(items);		
	}
	
	public void add() {
		System.out.println("***Add items***");
		System.out.println("Enter type :");
		String type = userActions.next();
		System.out.println("Enter price :");
		double price = userActions.nextDouble();
		System.out.println("Enter weight :");
		double weight = userActions.nextDouble();
		System.out.println("Enter year :");
		int year = userActions.nextInt();
		Electronics electronics = new Electronics(type, price, weight, year);
		controller.add(electronics);
		
	}
	
	private void search() {
		System.out.println("***Search by type***");
		System.out.println("Enter type for search :");
		String type = userActions.next();
		controller.search(type);
	}

}
