package com.rjn.dao;

import java.util.List;

import com.rjn.model.Branch.BranchMasterDetails;

public interface BranchMasterDetailsDao {
	
	BranchMasterDetails getBranchByUniqueId(String uniqueId);
	List<BranchMasterDetails> getBranchByPartner(String partnerId);
	List<BranchMasterDetails> getLocationByCity(String cityId, String partnerId);
	List<BranchMasterDetails> getBranchList(String cityId, String partnerId, String location);
	void saveBranch(BranchMasterDetails branchMasterDetails);
	BranchMasterDetails getBranchDetails(String uniqueID);
}


