package com.work.company;

import java.util.List;

public interface CityDAO {
	public List<City> getAll() throws DAOException;
	public List<City> findByName(String name) throws DAOException;
}
