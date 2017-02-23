package com.rjn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.ProfileMasterDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.CustomerProfile;

@Repository("profileMasterDao")
public class ProfileMasterDaoImpl extends AbstractDao<Integer, CustomerProfile> implements ProfileMasterDao {

	@Override
	public void saveMemberRegister(CustomerProfile profileMaster) {
		persist(profileMaster);
	}

	@Override
	public List<CustomerProfile> getAllCustomerCompany() {
		Criteria criteria = createEntityCriteria();
		String nullcheck = "null";
		Conjunction objConjunction = Restrictions.conjunction();
		objConjunction.add(Restrictions.isNotNull("custCompanyName"));
		criteria.add(Restrictions.ne("custCompanyName", nullcheck));
		objConjunction.add(Restrictions.isNotNull("companyName"));
		criteria.add(Restrictions.ne("companyName", nullcheck));
		criteria.add(objConjunction);
		return (List<CustomerProfile>) criteria.list();
	}

	@Override
	public CustomerProfile getProfileMasterByprofileNumber(String profileNumber) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("profileNumber", profileNumber));
		return (CustomerProfile) criteria.uniqueResult();
	}

	@Override
	public CustomerProfile getProfileMasterByEmail(String contactEmailId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("contactEmailId", contactEmailId));
		return (CustomerProfile) criteria.uniqueResult();
	}

	@Override
	public void saveOrUpdateMember(CustomerProfile profileMaster) {
			update(profileMaster);
		
	}
}