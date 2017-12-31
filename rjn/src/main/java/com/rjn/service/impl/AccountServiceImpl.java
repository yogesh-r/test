package com.rjn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.Exception.CustomException;
import com.rjn.dao.core.AccountDao;
import com.rjn.model.Account;
import com.rjn.service.AccountService;

@Service("accounteService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao dao;
	
	public Account findByUserName(String username) throws CustomException {
		return dao.findByUserName(username);
	}
	
	@Override
	public void updatePassword(Account account) {
		dao.updateAccount(account);
	}
} 