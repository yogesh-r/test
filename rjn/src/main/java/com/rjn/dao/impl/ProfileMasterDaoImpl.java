package com.rjn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.rjn.dao.ProfileMasterDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.ProfileMaster;

@Repository("profileMasterDao")
public class ProfileMasterDaoImpl extends AbstractDao<Integer, ProfileMaster> implements ProfileMasterDao {

	@Override
	public void saveMemberRegister(ProfileMaster profileMaster) {
		persist(profileMaster);
	}

	@Override
	public List<ProfileMaster> getAllCustomerCompany() {
		Criteria criteria = createEntityCriteria();
		String nullcheck = "null";
		Conjunction objConjunction = Restrictions.conjunction();
		objConjunction.add(Restrictions.isNotNull("custCompanyName"));
		criteria.add(Restrictions.ne("custCompanyName", nullcheck));
		objConjunction.add(Restrictions.isNotNull("companyName"));
		criteria.add(Restrictions.ne("companyName", nullcheck));
		criteria.add(objConjunction);
		return (List<ProfileMaster>) criteria.list();
	}
/*
	@Override
	public ProfileMaster getProfileMasterById() {
		Criteria criteria=createEntityCriteria();
		criteria.add(Restrictions.eq("id",PartnerID));
		return (ProfileMaster) criteria.uniqueResult();
	}*/

	@Override
	public ProfileMaster getProfileMasterByprofileNumber(String profileNumber) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("profileNumber", profileNumber));
		return (ProfileMaster) criteria.uniqueResult();
	}
}