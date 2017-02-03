package com.rjn.service.impl; 

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

import com.rjn.dao.AssignedToDao;
import com.rjn.dao.BusinessEnquiryDetailsDao;
import com.rjn.dao.ProfileMasterDao;
import com.rjn.dao.VendorProfileDao;
import com.rjn.dao.core.AccountDao;
import com.rjn.dao.core.LookUpDao;
import com.rjn.model.Account;
import com.rjn.model.BusinessEnquiryDetails;
import com.rjn.model.ProfileMaster;
import com.rjn.model.VendorProfile;
import com.rjn.service.VendorService;
import com.rjn.utils.Constant;

@Service("partnerService") 
@Transactional 
public class PartnerServiceImpl implements VendorService { 

	@Autowired 
	private AccountDao accountDao; 
	
	@Autowired 
	private VendorProfileDao partnerDetailsDao;
	
	@Autowired
	private ProfileMasterDao companydao;
	
	@Autowired
	private LookUpDao lookupdao;
	
	@Autowired
	private AssignedToDao assignedToDao;
	
	@Autowired
	private BusinessEnquiryDetailsDao vendorEnquiry;
	
	@Override 
	public void savePartnerDetails(VendorProfile partnerDetails) { 
		partnerDetailsDao.savePartnerDetails(partnerDetails); 
		if (partnerDetails.getId() == null || "".equals(partnerDetails.getId())) {
			Account account = new Account(); 
			account.setMy_user_name(partnerDetails.getEmail()); 
			account.setPassword(partnerDetails.getPassword()); 
			account.setReg_id(partnerDetails.getId()); 
			accountDao.save(account, Constant.ROLE_PARTNER); 
		}
	} 
	
	@Override 
	public List<VendorProfile> getAllPartners() { 
		return partnerDetailsDao.getAllPartners(); 
	} 
	
	@Override 
	public VendorProfile getPartner(String PartnerID) { 
		return partnerDetailsDao.getPartner(PartnerID); 
	}

	@Override
	public List<ProfileMaster> getCustomerCompany() {
		return companydao.getAllCustomerCompany();
	}

	@Override
	public List<ProfileMaster> getAssignedTo(String assignedTo,String partnerID) {
		return assignedToDao.getAssignedTo(assignedTo, partnerID);
	}

	@Override
	public List<BusinessEnquiryDetails> getBusinessEnquiryList() {
		return vendorEnquiry.getBusinessEnquiryList(); 
	}

	@Override
	public void updateVerify(String partId, boolean isVerified) {
		partnerDetailsDao.updateVerify(partId, isVerified);
	}
} 