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
		System.out.println("partnerDetails.getId() >>>>>>>>>>>>>>>>>."+partnerDetails.getId()+"=================");
		if (partnerDetails.getId() == null || "".equals(partnerDetails.getId())) {
			persist(partnerDetails);
		} else {
			System.out.println("Update >>>>>>>>>>>>>> ");
			update(partnerDetails); 
		}
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


}
