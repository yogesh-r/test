package com.rjn.dao.core;

import com.rjn.model.Account;

public interface AccountDao {
	
	Account findByUserName(String username);
	void save(Account account, String role);
	
	public Account getLoggedInUser();
	void updateAccount(Account account);

}
