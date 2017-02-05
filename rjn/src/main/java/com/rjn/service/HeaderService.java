package com.rjn.service;

import com.rjn.model.Account;
import com.rjn.model.BusinessEnquiry;
import com.rjn.model.PasswordResetToken;
import com.rjn.model.CustomerProfile;

public interface HeaderService { 

	void saveMemberRegistration(CustomerProfile profileMaster);
	void saveListYourOffice(BusinessEnquiry listYourSpace);
	BusinessEnquiry getBusinessEnquiryByEnquiryId(String enquiryId);
	public CustomerProfile getProfileMasterByEmail(String contactEmailId);
	void saveToken(CustomerProfile profileMaster, String token);
	PasswordResetToken getPasswordResetToken(String profileNumber, String token);
	Account findByRegId(String regId);
}