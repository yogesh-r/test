package com.rjn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.BranchMasterDetailsDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.Branch.BranchMasterDetails;

@Repository("branchMasterDetailsDao")
public class BranchMasterDetailsDaoImpl extends AbstractDao<Integer, BranchMasterDetails> implements BranchMasterDetailsDao {

	@Override
	public BranchMasterDetails getBranchByUniqueId(String uniqueId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("uniqueId", uniqueId));
		return (BranchMasterDetails) criteria.uniqueResult();
	}

	@Override
	public List<BranchMasterDetails> getBranchByPartner(String partnerId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("branchOwner", partnerId));
		return (List<BranchMasterDetails>) criteria.list();
	}

	@Override
	public List<BranchMasterDetails> getLocationByCity(String cityId, String partnerId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("city", cityId));
		criteria.add(Restrictions.eq("branchOwner", partnerId));
		return (List<BranchMasterDetails>) criteria.list();
	}

	@Override
	public List<BranchMasterDetails> getBranchList(String cityId, String partnerId, String location) {
		Criteria criteria = createEntityCriteria();
		if (location != null) {
			criteria.add(Restrictions.eq("location", location));
		}
		criteria.add(Restrictions.eq("city", cityId));
		criteria.add(Restrictions.eq("branchOwner", partnerId));
		return (List<BranchMasterDetails>) criteria.list();
	}

	@Override
	public void saveBranch(BranchMasterDetails branchMasterDetails) {
		if (branchMasterDetails.getId() <= 0) {
			persist(branchMasterDetails);
		} else {
			update(branchMasterDetails); 
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public BranchMasterDetails getBranchDetails(String uniqueID) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("uniqueId",uniqueID));
		return (BranchMasterDetails) criteria.uniqueResult();
	}
}
