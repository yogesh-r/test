package com.rjn.dao.core;

import java.util.List;

import com.rjn.model.core.VendorLead;

public interface VendorLeadDao {
	
	void saveVendorLead(VendorLead vendorLead);
	List<VendorLead> getLeadsForVendor(String vendorId);
	
	VendorLead getLeadsByVendorAndUserId(long userId, String vendorId);
	
 
}
