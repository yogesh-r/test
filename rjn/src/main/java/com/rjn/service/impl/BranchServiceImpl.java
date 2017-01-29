package com.rjn.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rjn.dao.BranchMasterDetailsDao;
import com.rjn.model.Branch.BranchMasterDetails;
import com.rjn.service.BranchService;

@Service("branchService")
@Transactional
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchMasterDetailsDao dao;
	
	@Override
	public List<BranchMasterDetails> getBranchByPartner(String partnerId) {
		return dao.getBranchByPartner(partnerId);
	}

	@Override
	public List<BranchMasterDetails> getLocationByCity(String cityId, String partnerId) {
		return dao.getLocationByCity(cityId, partnerId);
	}

	@Override
	public List<BranchMasterDetails> getBranchByCity(String cityId, String partnerId) {
		return null;
	}

	@Override
	public List<BranchMasterDetails> getBranchList(String cityId, String partnerId, String location) {
		return dao.getLocationByCity(cityId, partnerId);
	}

	@Override
	public void saveBranch(BranchMasterDetails branchMasterDetails) {
		dao.saveBranch(branchMasterDetails);
		//branchFeatureMasterDao.saveBranchFeatureList(branchMasterDetails.getAminitiesList(), branchMasterDetails.getId(),branchMasterDetails.getBranchName());
	}

	@Override
	public BranchMasterDetails getBranchByUniqueId(String uniqueId) {
		return dao.getBranchByUniqueId(uniqueId);
	}

	

}