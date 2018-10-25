package com.work.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CityConnectDAO implements CityDAO {
		
	private MyConnection myConnection = new MyConnection();

	@Override
	public List<City> getAll() {		
		List<City> listCity  = new LinkedList<>();
		//Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			/*Class.forName("com.mysql.cj.jdbc.Driver").newInstance();  	
			connection = DriverManager.getConnection(url, user, pass);
			statement = connection.createStatement();*/
			myConnection.openConnection();
			resultSet = myConnection.getSQLQuery("SELECT ID, Name, Population FROM city");
			//resultSet = statement.executeQuery("SELECT ID, Name, Population FROM city");
			while(resultSet.next()){
				City city = new City();
				String id = resultSet.getString("ID");
				String name = resultSet.getString("Name");
				String population = resultSet.getString("Population");
				city.setName(name);
				city.setId(Integer.parseInt(id));
				city.setPopularion(Integer.parseInt(population));
				listCity.add(city);
			} 
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return listCity;
	}

	@Override
	public List<City> findByName(String name) {
		List<City> listCity  = new LinkedList<>();
		/*
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();  	
			connection = DriverManager.getConnection(url, user, pass);
			Statement statement = connection.createStatement(); 

			ResultSet resultSet = statement.executeQuery("SELECT * FROM city");
			while(resultSet.next()){
				City city = new City();;
				String nameForSearch = resultSet.getString("Name");
				if (nameForSearch.equals(name)) {					
					String id = resultSet.getString("ID");
					String population = resultSet.getString("Population");
					city.setName(name);
					city.setId(Integer.parseInt(id));
					city.setPopularion(Integer.parseInt(population));
					listCity.add(city); 
				}
			}
			connection.close(); 
		} catch (ClassNotFoundException e) {			
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return listCity;
	}



}
