package com.rjn.dao.core;

import java.util.List;

import com.rjn.model.core.VendorLead;

public interface VendorLeadDao {
	public void saveVendorLead(VendorLead vendorLead);
	public List<VendorLead> getLeadsForVendor(String vendorId);
	public VendorLead getLeadsByVendorAndUserId(long userId, String vendorId);
}
