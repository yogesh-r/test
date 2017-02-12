package com.rjn.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rjn.dao.BranchProfileDao;
import com.rjn.model.Branch.BranchProfile;
import com.rjn.service.BranchService;

@Service("branchService")
@Transactional
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchProfileDao dao;
	
	@Override
	public List<BranchProfile> getBranchByVendor(String vendorId) {
		return dao.getBranchByVendor(vendorId);
	}

	@Override
	public List<BranchProfile> getLocationByCity(String cityId, String vendorId) {
		return dao.getLocationByCity(cityId, vendorId);
	}

	@Override
	public List<BranchProfile> getBranchByCity(String cityId, String vendorId) {
		return null;
	}

	@Override
	public List<BranchProfile> getBranchList(String cityId, String vendorId, String location) {
		return dao.getLocationByCity(cityId, vendorId);
	}

	@Override
	public void saveBranch(BranchProfile branchMasterDetails) {
		dao.saveBranch(branchMasterDetails);
	}

	@Override
	public BranchProfile getBranchByUniqueId(String uniqueId) {
		return dao.getBranchByUniqueId(uniqueId);
	}

	@Override
	public BranchProfile getBranchDetails(String uniqueID) {
		return dao.getBranchDetails(uniqueID);
	}
}