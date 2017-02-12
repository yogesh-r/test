package com.rjn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rjn.dao.BusinessEnquiryDao;
import com.rjn.service.RowCountService;

@Service("rowCountService")
@Transactional 
public class RowCountServiceImpl implements RowCountService{

	@Autowired
	private BusinessEnquiryDao businessEnquiryDao;
	
	
	@Override
	public long getBusinessEnquiryRowCount() {
		return businessEnquiryDao.getRowCount();
	}

}
