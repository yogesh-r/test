package com.rjn.service.Core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.dao.core.LookUpDao;
import com.rjn.model.core.LookupMaster;
import com.rjn.service.Core.LookUpService;

@Service("lookUpService")
@Transactional
public class LookUpServiceImpl implements LookUpService {

	@Autowired
	private LookUpDao dao;
	
	@Override
	public List<LookupMaster> getLookUpValuesData(String lookUpValue) {
		return dao.getLookUpValuesData(lookUpValue);
	}

}
