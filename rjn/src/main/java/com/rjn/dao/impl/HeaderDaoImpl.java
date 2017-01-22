package com.rjn.dao.impl;

import org.springframework.stereotype.Repository;

import com.rjn.dao.HeaderDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.GeneralContactUs;

@Repository("headerDao")
public class HeaderDaoImpl extends  AbstractDao<Integer, GeneralContactUs> implements HeaderDao {

	@Override
	public void saveContactUs(GeneralContactUs generalContactUs) {
		persist(generalContactUs);
	}
}
