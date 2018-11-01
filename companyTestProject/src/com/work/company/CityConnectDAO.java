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

public class CityConnectDAO implements CityDAO, AutoCloseable {

	private Connection connection;

	public CityConnectDAO() throws DAOException {
		Properties property = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream reader = classLoader.getResourceAsStream("com/work/company/properties.properties");
		try {
			property.load(reader);
			String driverName = property.getProperty("driver");
			String url = property.getProperty("url");
			String user = property.getProperty("user");
			String pass = property.getProperty("pass");
			reader.close();
			Class.forName(driverName).newInstance();
			connection = DriverManager.getConnection(url, user, pass);
		} catch (IOException e) {
			throw new DAOException("Error in constructor with file opening", e);
		} catch (InstantiationException e) {
			throw new DAOException("Error in constructor: object Class not found", e);
		} catch (IllegalAccessException e) {
			throw new DAOException("Error in constructor with access to DB", e);
		} catch (ClassNotFoundException e) {
			throw new DAOException("Error in constructor with ClassPath", e);
		} catch (SQLException e) {
			throw new DAOException("Error in constructor with SQLQuery", e);
		}
	}

	public void close() throws DAOException {	
		try {
			connection.close();
		} catch (SQLException e) {
			throw new DAOException("Error in close method", e);
		}	
	}

	@Override
	public List<City> getAll() throws DAOException {		
		List<City> listCity  = new LinkedList<>();	
		try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT ID, Name, Population FROM city") ){			
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
			throw new DAOException("Error in getAll method", e);
		} 
		return listCity;
	}

	@Override
	public List<City> findByName(String name) throws DAOException {
		List<City> listCity  = new LinkedList<>();
		try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT ID, Name, Population FROM city") ){
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
			throw new DAOException("Error in findByName method", e);
		} 			
		return listCity;
	}



}
