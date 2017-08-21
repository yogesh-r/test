package com.rjn.dao.core;

import com.rjn.Exception.CustomException;
import com.rjn.model.Account;

public interface AccountDao {
	public Account findByUserName(String username) throws CustomException;
	public void save(Account account, String role);
	public Account getLoggedInUser();
	void updateAccount(Account account);
	public Account findByRegId(String regId);
}
