package com.rjn.service;
 
import java.util.List;

import com.rjn.model.BusinessEnquiryDetails;
import com.rjn.model.ProfileMaster;
import com.rjn.model.VendorProfile;

public interface VendorService {
    void saveVendorDetails(VendorProfile vendorDetails);
    List<VendorProfile> getAllVendors();
    VendorProfile getVendor(String vendorID);
    List<ProfileMaster> getCustomerCompany();
    List<ProfileMaster> getAssignedTo(String assignedTo,String vendorID);
    List<BusinessEnquiryDetails> getBusinessEnquiryList();
    void updateVendorDetails(VendorProfile vendorDetails);
    void updateVerify(String partId, boolean isVerified);	
}
 