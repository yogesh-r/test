package com.rjn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.dao.ProfileMasterDao;
import com.rjn.model.ProfileMaster;
import com.rjn.service.MemberService;

@Service("memberService")
@Transactional 
public class MemberServiceImpl implements MemberService{

	@Autowired
	ProfileMasterDao profileMasterDao;
	
	@Override
	public ProfileMaster getProfileMasterByprofileNumber(String profileNumber) {
		return profileMasterDao.getProfileMasterByprofileNumber(profileNumber);
	}
	
	@Override
	public void saveMemberDetails(ProfileMaster profileMaster ) {
		 profileMasterDao.saveMemberRegister(profileMaster);
	}
}
