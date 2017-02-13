package com.rjn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.VendorProductDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.product.VendorProduct;

@Repository("vendorProductDao")
public class VendorProductDaoImpl extends AbstractDao<Integer, VendorProduct> implements VendorProductDao { 

	@Override
	public void saveProduct(VendorProduct vendorProduct) {
		if (vendorProduct.getId() <=0  ) {
			persist(vendorProduct);
		} else {
			update(vendorProduct); 
		}
	}

	@Override
	public List<VendorProduct> getProductByVendor(String vendorId) {
		Criteria criteria=createEntityCriteria();
		return (List<VendorProduct>) criteria.list();
	}

	@Override
	public VendorProduct getProduct(int productID) {
		Criteria criteria=createEntityCriteria();
		criteria.add(Restrictions.eq("id",productID));
		return (VendorProduct) criteria.uniqueResult();
	}

	@Override
	public VendorProduct getProductByUniqueID(String uniqueID) {
		Criteria criteria=createEntityCriteria();
		criteria.add(Restrictions.eq("uniqueId",uniqueID));
		return (VendorProduct) criteria.uniqueResult();
	}

	@Override
	public List<String> getKeyWord() {
		Criteria criteria=createEntityCriteria();
		criteria.setProjection(Projections.property("keyWord"));
		criteria.setProjection(Projections.distinct(Projections.property("keyWord")));
		return criteria.list();
	}

	@Override
	public long getRowCount() {
		Criteria criteria = createEntityCriteria();
		 return (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
}