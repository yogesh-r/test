package com.rjn.dao;

import com.rjn.model.PasswordResetToken;
import com.rjn.model.CustomerProfile;

public interface PasswordResetTokenDao {
	void saveToken(CustomerProfile profileMaster, String token); 
	PasswordResetToken getPasswordResetToken(String profileNumber, String token);
}
