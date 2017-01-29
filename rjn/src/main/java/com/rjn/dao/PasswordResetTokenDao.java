package com.rjn.dao;

import com.rjn.model.ProfileMaster;

public interface PasswordResetTokenDao {
	void saveToken(ProfileMaster profileMaster, String token); 
}
