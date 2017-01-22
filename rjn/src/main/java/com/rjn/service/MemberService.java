package com.rjn.service;

import com.rjn.model.ProfileMaster;

public interface MemberService {

	public ProfileMaster getProfileMasterByprofileNumber(String profileNumber);
	
	public void saveMemberDetails(ProfileMaster profileMaster);
	
}
