package com.rjn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.dao.FooterDao;
import com.rjn.model.Suggestions;
import com.rjn.service.FooterService;




@Service("footerService")
@Transactional 

public class FooterServiceImpl implements FooterService{
	
	@Autowired 
	private FooterDao footerDao;
	

	@Override
	public void saveSuggestions(Suggestions suggest) {
		footerDao.saveSuggestions(suggest);
		
	}
}
