package com.rjn.dao.core.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.core.AbstractDao;
import com.rjn.dao.core.VendorLeadDao;
import com.rjn.model.core.VendorLead;

@Repository("vendorLeadDao")
public class VendorLeadDaoImpl extends AbstractDao<Integer, VendorLead> implements VendorLeadDao {

	@Override
	public void saveVendorLead(VendorLead vendorLead) {
		if (vendorLead.getId() == null) {
			persist(vendorLead);
		} else {
			update(vendorLead); 
		}
	}

	@Override
	public List<VendorLead> getLeadsForVendor(String vendorId) {
		Criteria criteria=createEntityCriteria();
		criteria.add(Restrictions.eq("vendorId",vendorId));
		return (List<VendorLead>) criteria.list();
	}

	@Override
	public VendorLead getLeadsByVendorAndUserId(long userId, String vendorId) {
		Criteria criteria=createEntityCriteria();
		criteria.add(Restrictions.eq("vendorId",vendorId));
		criteria.add(Restrictions.eq("userId",userId));
		return (VendorLead) criteria.uniqueResult();
	}

	@Override
	public List<VendorLead> getLeadsForAdmin(String status) {
		
		Criteria criteria=createEntityCriteria();
		criteria.add(Restrictions.eq("adminStatus",status));
		return (List<VendorLead>) criteria.list();
	}

	@Override
	public void updateLead(VendorLead vendorLead) {
		update(vendorLead);
	}

	@Override
	public VendorLead getLeadById(long leadId) {
		Criteria criteria=createEntityCriteria();
		criteria.add(Restrictions.eq("id",leadId));
		return (VendorLead) criteria.uniqueResult();
	}
}