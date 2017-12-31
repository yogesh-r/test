package com.rjn.service;

import com.rjn.Exception.CustomException;
import com.rjn.model.Account;

public interface AccountService {
	Account findByUserName(String username) throws CustomException; 
	void updatePassword(Account account);
}
  