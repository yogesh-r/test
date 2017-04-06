package com.rjn.service.Core;

import java.util.List;

import com.rjn.model.Account;
import com.rjn.model.VendorProfile;
import com.rjn.model.core.City;
import com.rjn.model.core.Menu;
import com.rjn.model.core.ProductCategory;
import com.rjn.model.core.VendorLead;

public interface ApplicationUtils {
	public String encryptPassword(String password);
	
	public List<Menu> getMenu(String role);
	
	public String getUniqueIdForBranch(String branchName, String vendorName);
	
	public Account getLoggedInUser();
	
	void saveVendorRegistration(VendorProfile vendorDetails);
	
	public boolean matchPassword(String password,String encriptedPassword);
	
	void bulkCategoryInsert(List<ProductCategory> productCategoryList);
	
	//category
	void saveCategory(ProductCategory productCategory);
	
	void deleteCategory(ProductCategory productCategory);
	
	public List<ProductCategory> getAllCategory();
	
	ProductCategory getCategory(int productCategoryId);
	
	
	
	// Leads
	public List<VendorLead> getLeadsForAdmin(String status);
	
	void updateLead(VendorLead vendorLead);
	
	public VendorLead getLeadById(long leadId);
	
	public List<VendorLead> allLead();
	
	public List<VendorLead> allLead(String vendor_id);
	
	List<VendorLead> getLeadForVendor(String vendorId, String status);
	
	VendorLead getLeadsByVendorAndUserId(long userId, String vendorId);
	
	void saveVendorLead(VendorLead vendorLead);
	
	// city
	List<City> getAllCity();
	
	public List<City> getCitiesByState(String state);
}
