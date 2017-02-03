package com.rjn.service;

import com.rjn.model.Account;

public interface AccountService {
	Account findByUserName(String username);
	void updatePassword(Account account);
}
  