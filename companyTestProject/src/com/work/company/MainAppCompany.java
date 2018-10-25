package com.work.company;

public class MainAppCompany {

	public static void main(String[] args) {
		CityConnectDAO cityConnectDAO = new CityConnectDAO();
		System.out.println(cityConnectDAO.getAll());
		System.out.println(cityConnectDAO.findByName("Minsk"));
		System.out.println("Congratulation!!!!");
	}
}