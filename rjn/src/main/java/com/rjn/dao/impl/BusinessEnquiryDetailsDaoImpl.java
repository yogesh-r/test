package com.rjn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.BusinessEnquiryDetailsDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.BusinessEnquiryDetails;

@Repository("businessEnquiryDetailsDao")
public class BusinessEnquiryDetailsDaoImpl extends AbstractDao<Integer, BusinessEnquiryDetails> implements BusinessEnquiryDetailsDao{

	@Override
	public void saveListYourOffice(BusinessEnquiryDetails listSpaceData) {
		if (listSpaceData.getId() <= 0) {
			persist(listSpaceData);	
		}else {
			update(listSpaceData);
		}
	}

	@Override
	public List<BusinessEnquiryDetails> getBusinessEnquiryList() {
		Criteria criteria = createEntityCriteria();
		return (List<BusinessEnquiryDetails>) criteria.list();
	}

	@Override
	public BusinessEnquiryDetails getBusinessEnquiryByEnquiryId(String enquiryId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("enquiryId", enquiryId));
		return (BusinessEnquiryDetails) criteria.uniqueResult();
	}
}
