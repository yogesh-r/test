package com.rjn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.AssignedToDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.ProfileMaster;

@Repository("AssignedToDao")
public class AssignedToDaoImpl extends AbstractDao<Integer,ProfileMaster> implements AssignedToDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfileMaster> getAssignedTo(String assignedTo,String partnerID) {
		Criteria criteria=createEntityCriteria();
			if(assignedTo!=null){
			criteria.add(Restrictions.eq("profileCategory", assignedTo));
			criteria.add(Restrictions.eq("partnerId", partnerID));
			}
		return (List<ProfileMaster>) criteria.list();
	}
}
