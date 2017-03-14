package com.rjn.dao.core;

import java.util.List;

import com.rjn.model.core.VendorLead;

public interface VendorLeadDao {
	public void saveVendorLead(VendorLead vendorLead);
	public List<VendorLead> getLeadsForVendor(String vendorId, String status);
	public VendorLead getLeadsByVendorAndUserId(long userId, String vendorId);
	public List<VendorLead> getLeadsForAdmin(String status);
	void updateLead(VendorLead vendorLead);
	public VendorLead getLeadById(long leadId);
	public List<VendorLead> allLead();
}
