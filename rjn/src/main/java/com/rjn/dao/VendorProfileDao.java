package com.rjn.dao;

import java.util.List;

import com.rjn.model.VendorProfile;

public interface VendorProfileDao {
	void saveVendorDetails(VendorProfile vendorDetails);
	List<VendorProfile> getAllVendors();
	VendorProfile getVendor(String vendorID);
	void updateVendorDetails(VendorProfile vendorDetails);
	void updateVerify(String vendorId, boolean isVerified);	
}
