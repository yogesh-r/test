package com.rjn.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.Exception.CustomException;
import com.rjn.bean.RegistrationBean;
import com.rjn.dao.BusinessEnquiryDao;
import com.rjn.dao.PasswordResetTokenDao;
import com.rjn.dao.ProfileMasterDao;
import com.rjn.dao.core.AccountDao;
import com.rjn.model.Account;
import com.rjn.model.BusinessEnquiry;
import com.rjn.model.PasswordResetToken;
import com.rjn.model.CustomerProfile;
import com.rjn.service.HeaderService;
import com.rjn.utils.Constant;

@Service("headerService")
@Transactional 
public class HeaderServiceImpl implements HeaderService  { 
	
	private final static Logger logger = Logger.getLogger(HeaderServiceImpl.class);

	@Autowired
	private ProfileMasterDao profileMasterdao;
	
	@Autowired
	private AccountDao accountDao;

	@Autowired
	private BusinessEnquiryDao listDao;
	
	@Autowired
	private PasswordResetTokenDao passwordResetTokenDao;

	@Override
	public void saveMemberRegistration(RegistrationBean registrationBean) throws CustomException{
		Account account = null;
		try{
			account = accountDao.findByUserName(registrationBean.getContactEmailId());
			if(account != null){
				throw new CustomException("Email Id is exist");
			} else {
				CustomerProfile profileMaster = new CustomerProfile();
				BeanUtils.copyProperties(registrationBean, profileMaster);
				profileMasterdao.saveMemberRegister(profileMaster);
				account = new Account();
				account.setMy_user_name(registrationBean.getContactEmailId());
				account.setPassword(registrationBean.getPassword()); 
				account.setReg_id(registrationBean.getProfileNumber());
				accountDao.save(account, Constant.ROLE_MEMBER);
			}
		}catch(CustomException lE){
			logger.error("custom exception "+lE);
			throw new CustomException(lE.getMessage());
		}
	}

	@Override
	public void saveListYourOffice(BusinessEnquiry listYourSpace) {
		listDao.saveListYourOffice(listYourSpace);
	}

	@Override
	public BusinessEnquiry getBusinessEnquiryByEnquiryId(String enquiryId) {
		return listDao.getBusinessEnquiryByEnquiryId(enquiryId); 
	}

	@Override
	public CustomerProfile getProfileMasterByEmail(String contactEmailId) {
		return profileMasterdao.getProfileMasterByEmail(contactEmailId);
	}

	@Override
	public void saveToken(CustomerProfile profileMaster, String token) {
		 passwordResetTokenDao.saveToken(profileMaster, token);
	}

	@Override
	public PasswordResetToken getPasswordResetToken(String profileNumber, String token) {
		return passwordResetTokenDao.getPasswordResetToken(profileNumber, token);
	}

	@Override
	public Account findByRegId(String regId) {
		return accountDao.findByRegId(regId);
	}
}
