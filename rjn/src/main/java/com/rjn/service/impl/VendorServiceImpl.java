package com.rjn.service.impl; 

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

import com.rjn.dao.AssignedToDao;
import com.rjn.dao.BusinessEnquiryDao;
import com.rjn.dao.ProfileMasterDao;
import com.rjn.dao.VendorProfileDao;
import com.rjn.dao.core.AccountDao;
import com.rjn.model.Account;
import com.rjn.model.BusinessEnquiry;
import com.rjn.model.CustomerProfile;
import com.rjn.model.VendorProfile;
import com.rjn.service.VendorService;
import com.rjn.utils.Constant;

@Service("partnerService") 
@Transactional 
public class VendorServiceImpl implements VendorService { 

	@Autowired 
	private AccountDao accountDao; 
	
	@Autowired 
	private VendorProfileDao vendorDetailsDao;
	
	@Autowired
	private ProfileMasterDao companydao;
	
	@Autowired
	private AssignedToDao assignedToDao;
	
	@Autowired
	private BusinessEnquiryDao vendorEnquiry;
	
	@Override 
	public void saveVendorDetails(VendorProfile vendorDetails) { 
		vendorDetailsDao.saveVendorDetails(vendorDetails); 
		Account account = new Account(); 
		account.setMy_user_name(vendorDetails.getEmail()); 
		account.setPassword(vendorDetails.getPassword()); 
		account.setReg_id(vendorDetails.getId()); 
		accountDao.save(account, Constant.ROLE_VENDOR); 
	} 
	
	@Override 
	public List<VendorProfile> getAllVendors(int limit, int startingPage) { 
		return vendorDetailsDao.getAllVendors(limit, startingPage); 
	} 
	
	@Override 
	public VendorProfile getVendor(String vendorID) { 
		return vendorDetailsDao.getVendor(vendorID); 
	}

	@Override
	public List<CustomerProfile> getCustomerCompany() {
		return companydao.getAllCustomerCompany();
	}

	@Override
	public List<CustomerProfile> getAssignedTo(String assignedTo,String vendor) {
		return assignedToDao.getAssignedTo(assignedTo, vendor);
	}

	@Override
	public List<BusinessEnquiry> getBusinessEnquiryList(int limit, int startingPage) {
		return vendorEnquiry.getBusinessEnquiryList(limit, startingPage); 
	}

	@Override
	public void updateVerify(String vendorId, boolean isVerified) {
		vendorDetailsDao.updateVerify(vendorId, isVerified);
	}
	
	@Override
	public void updateVendorDetails(VendorProfile vendorDetails) {
		vendorDetailsDao.updateVendorDetails(vendorDetails);
	}
} 