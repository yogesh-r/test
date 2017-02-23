package com.rjn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.dao.ProfileMasterDao;
import com.rjn.model.CustomerProfile;
import com.rjn.service.MemberService;

@Service("memberService")
@Transactional 
public class MemberServiceImpl implements MemberService{

	@Autowired
	ProfileMasterDao profileMasterDao;
	
	@Override
	public CustomerProfile getProfileMasterByprofileNumber(String profileNumber) {
		return profileMasterDao.getProfileMasterByprofileNumber(profileNumber);
	}
	
	@Override
	public void saveMemberDetails(CustomerProfile profileMaster ) {
		 profileMasterDao.saveMemberRegister(profileMaster);
	}
	
	@Override
	public void saveOrUpdateMember(CustomerProfile profileMaster) {
		profileMasterDao.saveOrUpdateMember(profileMaster);
		
	}
}
