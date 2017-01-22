package com.rjn.dao.core;

import java.util.List;

import com.rjn.model.core.City;

public interface CityDao {
	
	List<City> getAllCity();
	List<City> getCitiesByState(String state);
	City getCityById(int cityId);
	City getCityByName(String name);
}
