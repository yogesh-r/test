package com.rjn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.dao.BusinessEnquiryDetailsDao;
import com.rjn.dao.HeaderDao;
import com.rjn.dao.PasswordResetTokenDao;
import com.rjn.dao.ProfileMasterDao;
import com.rjn.dao.core.AccountDao;
import com.rjn.model.Account;
import com.rjn.model.BusinessEnquiryDetails;
import com.rjn.model.GeneralContactUs;
import com.rjn.model.ProfileMaster;
import com.rjn.service.HeaderService;
import com.rjn.utils.Constant;

@Service("headerService")
@Transactional 
public class HeaderServiceImpl implements HeaderService  { 

	@Autowired
	private HeaderDao dao;
	
	@Autowired
	private ProfileMasterDao profileMasterdao;
	
	@Autowired
	private AccountDao accountDao;

	@Autowired
	private BusinessEnquiryDetailsDao listDao;
	
	@Autowired
	private PasswordResetTokenDao passwordResetTokenDao;
	
	
	@Override
	public void saveContactUs(GeneralContactUs contactUs) {
		dao.saveContactUs(contactUs); 
	}

	@Override
	public void saveMemberRegistration(ProfileMaster profileMaster) {
		profileMasterdao.saveMemberRegister(profileMaster);
		
		Account account = new Account();
		account.setMy_user_name(profileMaster.getContactEmailId());
		account.setPassword(profileMaster.getPassword()); 
		account.setReg_id(profileMaster.getProfileNumber());
		accountDao.save(account, Constant.ROLE_MEMBER);
	}

	@Override
	public void saveListYourOffice(BusinessEnquiryDetails listYourSpace) {
		listDao.saveListYourOffice(listYourSpace);
	}

	@Override
	public BusinessEnquiryDetails getBusinessEnquiryByEnquiryId(String enquiryId) {
		return listDao.getBusinessEnquiryByEnquiryId(enquiryId); 
	}

	@Override
	public ProfileMaster getProfileMasterByEmail(String contactEmailId) {
		return profileMasterdao.getProfileMasterByEmail(contactEmailId);
	}

	@Override
	public void saveToken(ProfileMaster profileMaster, String token) {
		 passwordResetTokenDao.saveToken(profileMaster, token);
	}
}
