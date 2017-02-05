package com.rjn.dao;

import java.util.List;

import com.rjn.model.BusinessEnquiry;

public interface BusinessEnquiryDetailsDao {
	void saveListYourOffice(BusinessEnquiry listSpaceData);
	List<BusinessEnquiry> getBusinessEnquiryList();
	BusinessEnquiry getBusinessEnquiryByEnquiryId(String enquiryId);
}
