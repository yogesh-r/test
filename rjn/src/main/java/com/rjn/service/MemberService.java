package com.rjn.service;

import com.rjn.model.CustomerProfile;

public interface MemberService {

	public CustomerProfile getProfileMasterByprofileNumber(String profileNumber);
	public void saveMemberDetails(CustomerProfile profileMaster);
	public void saveOrUpdateMember(CustomerProfile profileMaster);
}
