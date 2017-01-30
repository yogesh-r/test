package com.rjn.dao.core.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.rjn.dao.core.AbstractDao;
import com.rjn.dao.core.AccountDao;
import com.rjn.model.Account;

@Repository("accountDao")
public class AccountDaoImpl extends AbstractDao<Integer, Account> implements AccountDao {

	public Account findByUserName(String username) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("my_user_name", username));
		return (Account) criteria.uniqueResult();
	}

	@Override
	public void save(Account account, String role) {
		persist(account); 
		
		String hql = "insert into com.rjn.model.core.AccountRole (accountId, roleId)"
		        + " select a.id, r.id from com.rjn.model.Account a, "+
				" com.rjn.model.Role r where r.code = :roleId " +
		        " and a.my_user_name = :accountId ";
		
		Query query = getSession().createQuery(hql);
		
		query.setParameter("roleId", role);
		query.setParameter("accountId", account.getMy_user_name());
		query.executeUpdate();
	}

	@Override
	public Account getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		org.springframework.security.core.userdetails.User authuser = (authentication != null && authentication
				.getPrincipal() instanceof org.springframework.security.core.userdetails.User) ? (org.springframework.security.core.userdetails.User) authentication
				.getPrincipal() : null;
		return authuser == null ? null : getAccount(authuser.getUsername());
	}
	
	public Account getAccount(String login) {
		List<Account> userList = new ArrayList<Account>();
		Query query = getSession().createQuery("from com.rjn.model.Account u where u.my_user_name = :login");
		query.setParameter("login", login);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;	
	}
	@Override
	public void updateAccount(Account account) {
		update(account);
		
	}

	@Override
	public Account findByRegId(String regId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("reg_id", regId));
		return (Account) criteria.uniqueResult();
	}
}