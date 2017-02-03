package com.rjn.dao.core.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.core.AbstractDao;
import com.rjn.dao.core.LookUpDao;
import com.rjn.model.core.LookupMaster;

@Repository("lookUpDao")
public class LookUpDaoImpl extends AbstractDao<Integer, LookupMaster> implements LookUpDao {

	@Override
	public List<LookupMaster> getLookUpValuesData(String lookUpValue) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("lookupType", lookUpValue));
		return (List<LookupMaster>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LookupMaster> getLookupData(String lookupType) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("lookupType", lookupType));
		return (List<LookupMaster>) criteria.list();
	}
}
