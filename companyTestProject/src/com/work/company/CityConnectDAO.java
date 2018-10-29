package com.work.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class CityConnectDAO implements CityDAO {

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public CityConnectDAO() {
		String driverName = null;
		String url = null;
		String user = null;
		String pass = null;	
		InputStream reader = null;
		Properties property = new Properties();
		Thread currentThread = Thread.currentThread();
		ClassLoader classLoader = currentThread.getContextClassLoader();

		try {

			reader = classLoader.getResourceAsStream("com/work/company/properties.properties");
			System.out.println(reader);
			System.out.println(classLoader.getResource("D:/property/properties.properties"));
			reader = this.getClass().getClassLoader().getResourceAsStream("D:/property/properties.properties");
			System.out.println(reader);
			if (reader == null) {
				System.out.println("Error file reading");
			} 
				property.load(reader);
		

			driverName = property.getProperty("driver");
			url = property.getProperty("url");
			user = property.getProperty("user");
			pass = property.getProperty("pass");
			//System.out.println(url);

		} catch (IOException e) {
			System.out.println(e);
		} 			
		openConnection(driverName, url, user, pass);
	}

	private void openConnection(String driverName, String url, String user, String pass) {
		try {
			Class.forName(driverName).newInstance();  	
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

	private ResultSet getSQLQuery(String sqlQuery) {
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
