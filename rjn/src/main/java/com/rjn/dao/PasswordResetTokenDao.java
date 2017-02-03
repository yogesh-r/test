package com.rjn.dao;

import com.rjn.model.PasswordResetToken;
import com.rjn.model.ProfileMaster;

public interface PasswordResetTokenDao {
	void saveToken(ProfileMaster profileMaster, String token); 
	PasswordResetToken getPasswordResetToken(String profileNumber, String token);
}
