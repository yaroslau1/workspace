package com.work.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CityConnectDAO implements CityDAO {

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public void openConnection() {
		String url = "jdbc:mysql://localhost:3306/world"+
				"?verifyServerCertificate=false"+
				"&useSSL=false"+
				"&requireSSL=false"+
				"&serverTimezone=UTC"+
				"&useLegacyDatetimeCode=false"+
				"&serverTimezone=UTC";
		String user = "root";
		String pass = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();  	
			connection = DriverManager.getConnection(url, user, pass);
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		} catch (InstantiationException e) {			
			System.out.println(e);
		} catch (IllegalAccessException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	public void openConnection(String url, String user, String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();  	
			connection = DriverManager.getConnection(url, user, pass);
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		} catch (InstantiationException e) {			
			System.out.println(e);
		} catch (IllegalAccessException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	public ResultSet getSQLQuery(String sqlQuery) {
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.resultSet; 
	}
	
	public void closeConnection() {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.close();
		} catch (SQLException e) {				
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {				
			e.printStackTrace();
		}
	}

	@Override
	public List<City> getAll() {		
		List<City> listCity  = new LinkedList<>();

		try {
			openConnection();
			getSQLQuery("SELECT ID, Name, Population FROM city");
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

		try {
			openConnection();
			getSQLQuery("SELECT ID, Name, Population FROM city");
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
		} catch (SQLException e) {
			System.out.println(e);
		} 
		return listCity;
	}



}
