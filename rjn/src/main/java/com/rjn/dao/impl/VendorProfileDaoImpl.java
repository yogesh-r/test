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
	public void savePartnerDetails(VendorProfile partnerDetails) {
		persist(partnerDetails);
	}

	@Override
	public void updatePartnerDetails(VendorProfile partnerDetails) {
		update(partnerDetails);
	}
	
	@Override
	public List<VendorProfile> getAllPartners() {
		Criteria criteria=createEntityCriteria();
		return (List<VendorProfile>) criteria.list();
	}

	@Override
	public VendorProfile getPartner(String PartnerID) {
		Criteria criteria=createEntityCriteria();
		criteria.add(Restrictions.eq("id",PartnerID));
		return (VendorProfile) criteria.uniqueResult();
	}

	@Override
	public void updateVerify(String partId, boolean isVerified) {
		String hqlUpdate = "update VendorProfile c set c.verified = :verified where c.id = :id";
		int updatedEntities = getSession().createQuery( hqlUpdate )
		        .setBoolean("verified", isVerified)
		        .setString("id", partId)
		        .executeUpdate();
		System.out.println("updatedEntities >> "+updatedEntities);
	}

}
