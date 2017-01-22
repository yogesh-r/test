package com.rjn.service;

import com.rjn.model.BusinessEnquiryDetails;
import com.rjn.model.GeneralContactUs;
import com.rjn.model.ProfileMaster;

public interface HeaderService { 

	void saveContactUs(GeneralContactUs contactUs);
	void saveMemberRegistration(ProfileMaster profileMaster);
	void saveListYourOffice(BusinessEnquiryDetails listYourSpace);
	BusinessEnquiryDetails getBusinessEnquiryByEnquiryId(String enquiryId);
}