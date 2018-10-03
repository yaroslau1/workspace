package com.work.electronicsStore.controller;

import java.util.List;

import com.work.electronicsStore.DAO.StoreDAO;
import com.work.electronicsStore.electronics.Electronics;

public class Controller {
	
	private StoreDAO dao = new StoreDAO();
	
	public Controller() {
		
	}
	
	public List<Electronics> showAll() {
		return dao.showAll();
		
	}
	
	public void add(Electronics electronics) {
		dao.add(electronics);
	}
	
	public void search(String type) {
		dao.search(type);
	}



}
