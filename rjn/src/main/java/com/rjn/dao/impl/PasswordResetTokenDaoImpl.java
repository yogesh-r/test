package com.rjn.dao.impl;

import org.springframework.stereotype.Repository;

import com.rjn.dao.PasswordResetTokenDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.PasswordResetToken;
import com.rjn.model.ProfileMaster;

@Repository("passwordResetTokenDao")
public class PasswordResetTokenDaoImpl extends AbstractDao<Integer, PasswordResetToken> implements PasswordResetTokenDao {

	@Override
	public void saveToken(ProfileMaster profileMaster, String token) {
		PasswordResetToken passwordResetToken = new PasswordResetToken();
		passwordResetToken.setToken(token);
		passwordResetToken.setProfileNumber(profileMaster.getProfileNumber());
		
		persist(passwordResetToken);
	}
}
