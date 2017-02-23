package com.rjn.dao;

import java.util.List;

import com.rjn.model.CustomerProfile;

public interface ProfileMasterDao {
	void saveMemberRegister(CustomerProfile profileMaster ); 
	List<CustomerProfile> getAllCustomerCompany();
	public CustomerProfile getProfileMasterByprofileNumber(String profileNumber);
	public CustomerProfile getProfileMasterByEmail(String contactEmailId);
	public void saveOrUpdateMember(CustomerProfile profileMaster);
	
}