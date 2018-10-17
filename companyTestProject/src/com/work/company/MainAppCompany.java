package com.work.company;

public class MainAppCompany {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/company";
		String user = "root";
		String password = "1234";
		
		DBEntity dbEntity = new DBEntity(url, user, password);
		
		dbEntity.openConnection();
		dbEntity.getAllInformationFromBD();
		dbEntity.closeConnection();

	}

}
