package com.rjn.service;

import java.util.List;

import com.rjn.model.Branch.BranchMasterDetails;

public interface BranchService {
	List<BranchMasterDetails> getBranchByPartner(String partnerId);
	
	List<BranchMasterDetails> getLocationByCity(String cityId, String partnerId);

	List<BranchMasterDetails> getBranchByCity(String cityId, String partnerId);
	
	List<BranchMasterDetails> getBranchList(String cityId, String partnerId, String location);
	
	void saveBranch(BranchMasterDetails branchMasterDetails);
	
	BranchMasterDetails getBranchByUniqueId(String uniqueId);
	
	BranchMasterDetails getBranchDetails(String uniqueID);
	
	
	
}