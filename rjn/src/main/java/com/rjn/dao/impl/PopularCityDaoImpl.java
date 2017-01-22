package com.rjn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.rjn.dao.PopularCityDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.PopularCity;

@Repository("popularCityDao")
public class PopularCityDaoImpl extends AbstractDao<Integer, PopularCity> implements PopularCityDao {

	@Override
	public List<PopularCity> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<PopularCity>) criteria.list();
	}
}
