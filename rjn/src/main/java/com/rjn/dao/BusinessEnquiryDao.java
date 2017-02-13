package com.rjn.dao;

import java.util.List;

import com.rjn.model.BusinessEnquiry;

public interface BusinessEnquiryDao {
	void saveListYourOffice(BusinessEnquiry listSpaceData);
	List<BusinessEnquiry> getBusinessEnquiryList(int limit, int startingPage);
	BusinessEnquiry getBusinessEnquiryByEnquiryId(String enquiryId);
	
	long getRowCount();
}
