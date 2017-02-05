package com.rjn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.AssignedToDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.CustomerProfile;

@Repository("AssignedToDao")
public class AssignedToDaoImpl extends AbstractDao<Integer,CustomerProfile> implements AssignedToDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerProfile> getAssignedTo(String assignedTo,String vendorID) {
		Criteria criteria=createEntityCriteria();
			if(assignedTo!=null){
			criteria.add(Restrictions.eq("profileCategory", assignedTo));
			criteria.add(Restrictions.eq("vendorId", vendorID));
			}
		return (List<CustomerProfile>) criteria.list();
	}
}
