package com.work.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.work.entity.City;
import com.work.entity.Country;
import com.work.exeption.DAOException;

public class CountryConnectDAO implements CountryDAO, AutoCloseable{
	
	private Connection connection;
	private PreparedStatement getAll = null;
	private PreparedStatement addValues = null;
	private PreparedStatement deleteByID = null;
	private PreparedStatement updateByID = null;

	@Override
	public void close() throws Exception {
	}

	@Override
	public List<Country> getAll() throws DAOException {
		List<Country> listCity = new LinkedList<>();
		try (ResultSet resultSet = getAll.executeQuery()){
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
	public List<Country> findByName(String name) throws DAOException {
		return null;
	}

	@Override
	public void insert(Country country) throws DAOException {
	}

	@Override
	public void deleteByCode(int id) throws DAOException {
	}

	@Override
	public void updateByCode(Country country) throws DAOException {
	}

}
