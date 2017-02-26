package com.rjn.service;

import java.util.List;

import com.rjn.model.Branch.BranchProfile;

public interface BranchService {
	List<BranchProfile> getBranchByVendor(String vendorId);
	
	List<BranchProfile> getLocationByCity(String cityId, String vendorId);

	List<BranchProfile> getBranchByCity(String cityId, String vendorId);
	
	List<BranchProfile> getBranchList(String cityId, String vendorId, String location);
	
	void updateBranch(BranchProfile branchMasterDetails);
	
	BranchProfile getBranchByUniqueId(String uniqueId);
	
	
	BranchProfile getBranchData(int branchId);
	List<BranchProfile> getBranchDetails();
	BranchProfile getBranchDetails(String uniqueID);
	void saveBranch(BranchProfile branchMasterDetails);
	
	
	
	
}