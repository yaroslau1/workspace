package com.work.company;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class CityConnectDAO implements CityDAO {

	private Connection connection;

	public CityConnectDAO() {
		String driverName = null;
		String url = null;
		String user = null;
		String pass = null;	
		InputStream reader = null;
		Properties property = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

		try {

			reader = classLoader.getResourceAsStream("com/work/company/properties.properties");
			property.load(reader);
			driverName = property.getProperty("driver");
			url = property.getProperty("url");
			user = property.getProperty("user");
			pass = property.getProperty("pass");

		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		open(driverName, url, user, pass);
	}

	private void open(String driverName, String url, String user, String pass) {
		try {
			Class.forName(driverName).newInstance();  	
			connection = DriverManager.getConnection(url, user, pass);
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

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {				
			e.printStackTrace();
		}
	}

	@Override
	public List<City> getAll() {		
		List<City> listCity  = new LinkedList<>();
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT ID, Name, Population FROM city");			
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
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			try {
				resultSet.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}			
		}
		return listCity;
	}

	@Override
	public List<City> findByName(String name) {
		List<City> listCity  = new LinkedList<>();
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT ID, Name, Population FROM city");
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
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			try {
				resultSet.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}			
		}
		return listCity;
	}



}
