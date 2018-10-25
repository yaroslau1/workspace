package com.work.company;

import java.util.List;

public interface CityDAO {
	public List<City> getAll();
	public List<City> findByName(String name);
}
