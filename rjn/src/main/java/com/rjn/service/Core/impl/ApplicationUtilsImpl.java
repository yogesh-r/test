package com.rjn.service.Core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.dao.BranchProfileDao;
import com.rjn.dao.core.AccountDao;
import com.rjn.dao.core.CityDao;
import com.rjn.dao.core.MenuDao;
import com.rjn.dao.core.ProductCategoryDao;
import com.rjn.dao.core.VendorLeadDao;
import com.rjn.model.Account;
import com.rjn.model.VendorProfile;
import com.rjn.model.Branch.BranchProfile;
import com.rjn.model.core.City;
import com.rjn.model.core.Menu;
import com.rjn.model.core.ProductCategory;
import com.rjn.model.core.VendorLead;
import com.rjn.service.Core.ApplicationUtils;

@Service
@Transactional
public class ApplicationUtilsImpl implements ApplicationUtils {

	@Autowired
	private MenuDao dao;
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private BranchProfileDao branchMasterDetailsDao;
	
	@Autowired
	private CityDao cityDao;
	
	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Autowired
	private VendorLeadDao vendorLeadDao;
	
	@Override
	public String encryptPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		return passwordEncoder.encode(password);
	}
	
	@Override
	public List<Menu> getMenu(String role) {
		return dao.getMenu(role);
	}

	@Override
	public String getUniqueIdForBranch(String branchName, String vendorName) {
		String uniqueId = vendorName.replaceAll(" ", "-").toLowerCase() + "-" + branchName.replaceAll(" ", "-").toLowerCase();
		
		boolean canWeUse = checkUniqueIdIsAvailableOrNot(uniqueId);
		
		String finalUniqueId = "";
		
		if (!canWeUse) {
			for (int i = 0; i < 100; i++) {
				finalUniqueId = vendorName.replaceAll(" ", "-").toLowerCase() + "-" + branchName.replaceAll(" ", "-").toLowerCase() + i;
				if (checkUniqueIdIsAvailableOrNot(finalUniqueId)) {
					return finalUniqueId;
				}
			}
		}
		return uniqueId;
	}
	
	private boolean checkUniqueIdIsAvailableOrNot(String uniqueId) {
		 BranchProfile branchMasterDetails =  branchMasterDetailsDao.getBranchByUniqueId(uniqueId);
		 if (branchMasterDetails == null) {
			 // not available
			 return false;
		 } else {
			 //available
			 return true;
		 }
	}

	@Override
	public Account getLoggedInUser() {
		return accountDao.getLoggedInUser();
	}

	@Override
	public void saveVendorRegistration(VendorProfile vendorDetails) {
		
	}

	@Override
	public List<City> getAllCity() {
		return cityDao.getAllCity();
	}

	@Override
	public List<ProductCategory> getAllCategory() {
		return productCategoryDao.getAllCategory();
	}

	@Override
	public void saveCategory(ProductCategory productCategory) {
		productCategoryDao.save(productCategory); 
	}

	@Override
	public ProductCategory getCategory(int productCategoryId) {
		return productCategoryDao.getCategory(productCategoryId);
	}

	@Override
	public void saveVendorLead(VendorLead vendorLead) {
		vendorLeadDao.saveVendorLead(vendorLead);
	}

	@Override
	public List<VendorLead> getLeadForVendor(String vendorId) {
		return vendorLeadDao.getLeadsForVendor(vendorId);
	}

	@Override
	public VendorLead getLeadsByVendorAndUserId(long userId, String vendorId) {
		return vendorLeadDao.getLeadsByVendorAndUserId(userId, vendorId);
	}

	@Override
	public boolean matchPassword(String password, String encriptedPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(password, encriptedPassword);
	}

	@Override
	public void bulkCategoryInsert(List<ProductCategory> productCategoryList) {
		productCategoryDao.saveInBulk(productCategoryList);
		
	}

	@Override
	public List<VendorLead> getLeadsForAdmin(String status) {
		return vendorLeadDao.getLeadsForAdmin(status);
	}

	@Override
	public void updateLead(VendorLead vendorLead) {
		vendorLeadDao.updateLead(vendorLead);
	}

	@Override
	public VendorLead getLeadById(long leadId) {
		return vendorLeadDao.getLeadById(leadId);
	}
}

