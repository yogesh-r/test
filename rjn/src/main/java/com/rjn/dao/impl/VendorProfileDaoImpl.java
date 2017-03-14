package com.rjn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.VendorProfileDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.VendorProfile;
import com.rjn.utils.Constant;

@Repository("vendorDetailsDao")
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
	public List<VendorProfile> getAllVendors(int limit, int startingPage) {
		Criteria criteria=createEntityCriteria();
		if (limit != Constant.NOT_APPLICABLE && startingPage != Constant.NOT_APPLICABLE) {
			criteria.addOrder(Order.asc("id"));
			int offset = startingPage * limit;
			criteria.setFirstResult(offset);// offset
			criteria.setMaxResults(limit); //limit
		}
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
	}

	@Override
	public long getRowCount() {
		Criteria criteria = createEntityCriteria();
		 return (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
}
