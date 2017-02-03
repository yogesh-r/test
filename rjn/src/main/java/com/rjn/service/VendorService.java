package com.rjn.service;
 
import java.util.List;

import com.rjn.model.BusinessEnquiryDetails;
import com.rjn.model.ProfileMaster;
import com.rjn.model.VendorProfile;

public interface VendorService {
    void savePartnerDetails(VendorProfile partnerDetails);
    List<VendorProfile> getAllPartners();
    VendorProfile getPartner(String PartnerID);
    List<ProfileMaster> getCustomerCompany();
    List<ProfileMaster> getAssignedTo(String assignedTo,String partnerID);
    List<BusinessEnquiryDetails> getBusinessEnquiryList();
    
    void updateVerify(String partId, boolean isVerified);	
}
 