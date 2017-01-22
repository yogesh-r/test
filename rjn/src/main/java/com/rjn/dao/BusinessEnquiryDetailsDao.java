package com.rjn.dao;

import java.util.List;

import com.rjn.model.BusinessEnquiryDetails;

public interface BusinessEnquiryDetailsDao {
	void saveListYourOffice(BusinessEnquiryDetails listSpaceData);
	
	List<BusinessEnquiryDetails> getBusinessEnquiryList();
	
	BusinessEnquiryDetails getBusinessEnquiryByEnquiryId(String enquiryId);
}
