package com.rjn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.dao.PopularCityDao;
import com.rjn.dao.TestQueryDao;
import com.rjn.model.PopularCity;
import com.rjn.service.PopularCityService;

@Service("popularCityService")
@Transactional
public class PopularCityServiceImpl implements PopularCityService {

	@Autowired
	private PopularCityDao dao;
	
	@Autowired
	private TestQueryDao dao1; 

	@Override
	public List<PopularCity> findAll() {
		
		dao1.findAll();
		
		return dao.findAll();
	}
}
