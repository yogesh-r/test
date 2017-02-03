package com.rjn.dao;

import java.util.List;

import com.rjn.model.ProfileMaster;

public interface ProfileMasterDao {
	void saveMemberRegister(ProfileMaster profileMaster ); 
	List<ProfileMaster> getAllCustomerCompany();
	public ProfileMaster getProfileMasterByprofileNumber(String profileNumber);
	public ProfileMaster getProfileMasterByEmail(String contactEmailId);
}