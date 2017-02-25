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
	
	List<City> getAllCity();
	
	public List<ProductCategory> getAllCategory();
	
	void saveCategory(ProductCategory productCategory);
	
	ProductCategory getCategory(int productCategoryId);
	
	void saveVendorLead(VendorLead vendorLead);
	
	List<VendorLead> getLeadForVendor(String vendorId, String status);
	
	VendorLead getLeadsByVendorAndUserId(long userId, String vendorId);
	
	public boolean matchPassword(String password,String encriptedPassword);
	
	void bulkCategoryInsert(List<ProductCategory> productCategoryList);
	
	public List<VendorLead> getLeadsForAdmin(String status);
	
	void updateLead(VendorLead vendorLead);
	
	public VendorLead getLeadById(long leadId);
}
