package com.work.company;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class CityConnectDAO implements CityDAO, AutoCloseable {

	private Connection connection;
	private List<PreparedStatement> statements = new ArrayList<>();

	public CityConnectDAO() throws DAOException {
		Properties property = new Properties();
		ClassLoader classLoader = this.getClass().getClassLoader();
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
			statements.add(connection.prepareStatement("SELECT ID, Name, CountryCode, Population FROM city"));
			statements.add(connection.prepareStatement("INSERT INTO world.city (Name, CountryCode, Population) VALUES (?, ?, ?)"));
			statements.add(connection.prepareStatement("DELETE FROM city WHERE id = ?"));
			statements.add(connection.prepareStatement("UPDATE city SET Name = ?, Population = ? WHERE Id = ?"));
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
		SQLException exception = new SQLException("Some errors with closing \n");
		if(statements != null){
			for(PreparedStatement statement : statements){
				if(statement != null){
					try {
						statement.close();
					} catch (SQLException e) {
						exception.addSuppressed(e);
					} 
				}
			}
		}
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				exception.addSuppressed(e);
			} 
		}
		if (exception.getSuppressed().length > 0) {
			throw new DAOException("errors list \n", exception);
		}
	}

	@Override
	public List<City> getAll() throws DAOException {		
		List<City> listCity  = new LinkedList<>();			
		try (ResultSet resultSet = statements.get(0).executeQuery()){
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
			return listCity;
		} catch (SQLException e) {
			throw new DAOException("Error in getAll method", e);
		}		
	} 

	@Override
	public List<City> findByName(String name) throws DAOException {
		List<City> listCity  = new LinkedList<>();
		try (ResultSet resultSet = statements.get(0).executeQuery()){
			while(resultSet.next()){
				City city = new City();;
				String nameForSearch = resultSet.getString("Name");
				if (nameForSearch.equals(name)) {
					String id = resultSet.getString("ID");
					String countryCode = resultSet.getString("CountryCode");
					String population = resultSet.getString("Population");
					city.setName(name);
					city.setId(Integer.parseInt(id));
					city.setCountryCode(countryCode);
					city.setPopularion(Integer.parseInt(population));
					listCity.add(city);
				}
			}
			return listCity;
		} catch (SQLException e) {
			throw new DAOException("Error in findByName method", e);
		}		
	}

	public void addValues(String name, String countryCode, int population) throws DAOException {
		try {
			statements.get(1).setString(1, name);
			statements.get(1).setString(2, countryCode);
			statements.get(1).setInt(3, population);			
			statements.get(1).execute();

		} catch (SQLException e) {
			throw new DAOException("error in add city \n", e);			
		}
	}
	
	public void deleteByID(int id) throws DAOException {
		try {	
			statements.get(2).setInt(1, id);
			statements.get(2).execute();
		} catch (SQLException e) {
			throw new DAOException("error in delete city \n", e);			
		}
	}
	
	public void updateById(int id) throws DAOException {
		try {	
			statements.get(3).setString(1, "Stryi");
			statements.get(3).setInt(2, 12);
			statements.get(3).setInt(3, id);
			statements.get(3).execute();
		} catch (SQLException e) {
			throw new DAOException("error in update city \n", e);			
		}
	}


}
