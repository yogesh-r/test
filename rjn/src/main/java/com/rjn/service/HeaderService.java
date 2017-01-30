package com.rjn.service;

import com.rjn.model.Account;
import com.rjn.model.BusinessEnquiryDetails;
import com.rjn.model.GeneralContactUs;
import com.rjn.model.PasswordResetToken;
import com.rjn.model.ProfileMaster;

public interface HeaderService { 

	void saveContactUs(GeneralContactUs contactUs);
	void saveMemberRegistration(ProfileMaster profileMaster);
	void saveListYourOffice(BusinessEnquiryDetails listYourSpace);
	BusinessEnquiryDetails getBusinessEnquiryByEnquiryId(String enquiryId);
	
	public ProfileMaster getProfileMasterByEmail(String contactEmailId);
	
	void saveToken(ProfileMaster profileMaster, String token);
	
	PasswordResetToken getPasswordResetToken(String profileNumber, String token);
	
	Account findByRegId(String regId);
}