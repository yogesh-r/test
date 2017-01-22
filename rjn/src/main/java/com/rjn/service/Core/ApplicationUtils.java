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
	
	public String getUniqueIdForBranch(String branchName, String partnerName);
	
	public Account getLoggedInUser();
	
	void savePartnerRegistration(VendorProfile partnerDetails);
	
	List<City> getAllCity();
	
	public List<ProductCategory> getAllCategory();
	
	void saveCategory(ProductCategory productCategory);
	
	ProductCategory getCategory(int productCategoryId);
	
	void saveVendorLead(VendorLead vendorLead);
	
	List<VendorLead> getLeadForVendor(String vendorId);
	
	VendorLead getLeadsByVendorAndUserId(long userId, String vendorId);
	
	public boolean matchPassword(String password,String encriptedPassword);
}
