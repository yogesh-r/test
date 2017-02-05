package com.rjn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.BranchMasterDetailsDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.Branch.BranchProfile;

@Repository("branchMasterDetailsDao")
public class BranchMasterDetailsDaoImpl extends AbstractDao<Integer, BranchProfile> implements BranchMasterDetailsDao {

	@Override
	public BranchProfile getBranchByUniqueId(String uniqueId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("uniqueId", uniqueId));
		return (BranchProfile) criteria.uniqueResult();
	}

	@Override
	public List<BranchProfile> getBranchByVendor(String vendorId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("branchOwner", vendorId));
		return (List<BranchProfile>) criteria.list();
	}

	@Override
	public List<BranchProfile> getLocationByCity(String cityId, String vendorId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("city", cityId));
		criteria.add(Restrictions.eq("branchOwner", vendorId));
		return (List<BranchProfile>) criteria.list();
	}

	@Override
	public List<BranchProfile> getBranchList(String cityId, String vendorId, String location) {
		Criteria criteria = createEntityCriteria();
		if (location != null) {
			criteria.add(Restrictions.eq("location", location));
		}
		criteria.add(Restrictions.eq("city", cityId));
		criteria.add(Restrictions.eq("branchOwner", vendorId));
		return (List<BranchProfile>) criteria.list();
	}

	@Override
	public void saveBranch(BranchProfile branchMasterDetails) {
		if (branchMasterDetails.getId() <= 0) {
			persist(branchMasterDetails);
		} else {
			update(branchMasterDetails); 
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public BranchProfile getBranchDetails(String uniqueID) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("uniqueId",uniqueID));
		return (BranchProfile) criteria.uniqueResult();
	}
}
