package com.rjn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.VendorProfileDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.VendorProfile;

@Repository("partnerDetailsDao")
public class VendorProfileDaoImpl  extends AbstractDao<Integer, VendorProfile> implements VendorProfileDao {

	@Override
	public void saveVendorDetails(VendorProfile vendorDetails) {
		persist(vendorDetails);
	}

	@Override
	public void updateVendorDetails(VendorProfile vendorDetails) {
		update(vendorDetails);
	}
	
	@Override
	public List<VendorProfile> getAllVendors() {
		Criteria criteria=createEntityCriteria();
		return (List<VendorProfile>) criteria.list();
	}

	@Override
	public VendorProfile getVendor(String vendorID) {
		Criteria criteria=createEntityCriteria();
		criteria.add(Restrictions.eq("id",vendorID));
		return (VendorProfile) criteria.uniqueResult();
	}

	@Override
	public void updateVerify(String vendorId, boolean isVerified) {
		String hqlUpdate = "update VendorProfile c set c.verified = :verified where c.id = :id";
		int updatedEntities = getSession().createQuery( hqlUpdate )
		        .setBoolean("verified", isVerified)
		        .setString("id", vendorId)
		        .executeUpdate();
		System.out.println("updatedEntities >> "+updatedEntities);
	}
}
