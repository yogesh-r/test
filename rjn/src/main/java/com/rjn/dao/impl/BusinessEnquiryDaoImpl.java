package com.rjn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.BusinessEnquiryDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.BusinessEnquiry;

@Repository("businessEnquiryDetailsDao")
public class BusinessEnquiryDaoImpl extends AbstractDao<Integer, BusinessEnquiry> implements BusinessEnquiryDao{

	@Override
	public void saveListYourOffice(BusinessEnquiry listSpaceData) {
		if (listSpaceData.getId() <= 0) {
			persist(listSpaceData);	
		}else {
			update(listSpaceData);
		}
	}

	@Override
	public List<BusinessEnquiry> getBusinessEnquiryList() {
		Criteria criteria = createEntityCriteria();
		return (List<BusinessEnquiry>) criteria.list();
	}

	@Override
	public BusinessEnquiry getBusinessEnquiryByEnquiryId(String enquiryId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("enquiryId", enquiryId));
		return (BusinessEnquiry) criteria.uniqueResult();
	}

	@Override
	public long getRowCount() {
		Criteria criteria = createEntityCriteria();
		 return (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
}