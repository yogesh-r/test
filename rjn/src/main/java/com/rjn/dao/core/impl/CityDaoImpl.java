package com.rjn.dao.core.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.rjn.dao.core.AbstractDao;
import com.rjn.dao.core.CityDao;
import com.rjn.model.core.City;

@Repository("cityDao")
public class CityDaoImpl extends AbstractDao<Integer, City> implements CityDao {

	@Override
	public List<City> getAllCity() {
		Criteria criteria = createEntityCriteria();
		return (List<City>) criteria.list();
	}

	@Override
	public City getCityById(int cityId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", cityId));
		return (City) criteria.uniqueResult();
	}

	@Override
	public City getCityByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("city", name));
		return (City) criteria.uniqueResult();
	}

	@Override
	public List<City> getCitiesByState(String state) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("state", state));
		return (List<City>) criteria.list();
	}
}
