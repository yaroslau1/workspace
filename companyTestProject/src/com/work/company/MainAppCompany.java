package com.work.company;

import javax.activation.MimeTypeParameterList;

public class MainAppCompany {

	public static void main(String[] args) {
		long start;
		long end;
		start = System.currentTimeMillis();
		CityConnectDAO cityConnectDAO = new CityConnectDAO();
		System.out.println(cityConnectDAO.getAll());
		System.out.println(cityConnectDAO.findByName("Minsk"));
		System.out.println(cityConnectDAO.findByName("Brest"));
		System.out.println(cityConnectDAO.findByName("Grodno"));
		cityConnectDAO.closeConnection();
		end = System.currentTimeMillis();
		System.out.println(end - start + "Congratulation!!!!");
	}
}