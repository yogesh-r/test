package com.rjn.service.Core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.dao.core.AccountDao;
import com.rjn.model.Account;
import com.rjn.service.Core.LoginService;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void createLogin(String userName, String password, String role) {
		Account thisAccount = new Account();
		thisAccount.setMy_user_name(userName);
		thisAccount.setPassword(password);
		
		accountDao.save(thisAccount, role);
	}
}
