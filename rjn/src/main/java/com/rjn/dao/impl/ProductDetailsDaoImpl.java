package com.rjn.dao.impl;


import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import com.rjn.dao.ProductDetailsDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.core.ProductCategory;

@Repository("productDetails")
public class ProductDetailsDaoImpl extends AbstractDao<Integer, ProductCategory> implements ProductDetailsDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCategory> getProductDetails() {
		Criteria criteria=createEntityCriteria();
		return (List<ProductCategory>) criteria.list();
	}
}
