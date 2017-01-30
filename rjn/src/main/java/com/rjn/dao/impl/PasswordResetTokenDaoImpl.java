package com.rjn.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public PasswordResetToken getPasswordResetToken(String profileNumber, String token) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("profileNumber", profileNumber));
		criteria.add(Restrictions.eq("token", token));
		return (PasswordResetToken) criteria.uniqueResult();
	}
}
