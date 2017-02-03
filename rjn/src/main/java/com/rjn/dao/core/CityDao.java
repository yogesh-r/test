package com.rjn.dao.core;

import java.util.List;

import com.rjn.model.core.City;

public interface CityDao {
	public List<City> getAllCity();
	public List<City> getCitiesByState(String state);
	public City getCityById(int cityId);
	public City getCityByName(String name);
}
