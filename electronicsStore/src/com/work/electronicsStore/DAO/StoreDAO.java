package com.work.electronicsStore.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.work.electronicsStore.electronics.Electronics;

public class StoreDAO implements IElectroDAO{
	
	//private Electronics electronics[] = new Electronics[2];
	List<Electronics> electronics = new ArrayList<>();
	
	public StoreDAO() {
		electronics.add(new Electronics("Smartphone", 1000, 210, 2017)) ;
		electronics.add(new Electronics("Notebook", 1500, 2100, 2017)) ;
	}
	
	public List<Electronics> showAll() {
		return electronics;
		
	}
	
	public void add(Electronics item) {
		electronics.add(item);
		/*Electronics temp[] = new Electronics[electronics.length + 1];
		for(int i = 0; i < temp.length - 1; i++) {
			temp[i] = electronics[i];
		}
		temp[temp.length - 1] = item;
		electronics = temp;*/
		System.out.println("***Added***");
		
	}
	
	public void search (String type) {
		boolean searchIsEmpty = true;
		for (int i = 0; i < electronics.size(); i++) {
			if(electronics.get(i).getType().equalsIgnoreCase(type)) {
				System.out.println(electronics.get(i));
				searchIsEmpty = false;
			} 
		}
		if (searchIsEmpty) {
			System.out.println("Matches not found");
		}
	}

}
