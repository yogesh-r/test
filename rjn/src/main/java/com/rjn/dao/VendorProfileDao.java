package com.rjn.dao;

import java.util.List;

import com.rjn.model.VendorProfile;

public interface VendorProfileDao {
	
	void savePartnerDetails(VendorProfile partnerDetails);
	List<VendorProfile> getAllPartners();
	VendorProfile getPartner(String PartnerID);
	
	void updateVerify(String partId, boolean isVerified);	
}
