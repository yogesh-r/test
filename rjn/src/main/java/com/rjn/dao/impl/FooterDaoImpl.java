package com.rjn.dao.impl;

import org.springframework.stereotype.Repository;

import com.rjn.dao.FooterDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.GeneralContactUs;
import com.rjn.model.Suggestions;


@Repository("footerDao")
public  class FooterDaoImpl extends AbstractDao<Integer, Suggestions> implements FooterDao{

	

	@Override
	public void saveSuggestions(Suggestions suggest) {
		persist(suggest);
		
	}
}
