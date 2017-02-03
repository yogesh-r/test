package com.rjn.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rjn.model.Account;
import com.rjn.model.Role;
import com.rjn.service.AccountService;

@Service("customUserDetailsService") 
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountService accountService;
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException { 
		// TODO Auto-generated method stub
		Account acocunt = accountService.findByUserName(username);
		if (acocunt == null) {
			return null;
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (Role role : acocunt.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		
		User user = new User(acocunt.getMy_user_name(), acocunt.getPassword(), acocunt.isEnabled(), 
				!acocunt.isExpired(), !acocunt.isCredentialsexpired(),
				!acocunt.isLocked(), authorities);
		
		return user;
	}

}
