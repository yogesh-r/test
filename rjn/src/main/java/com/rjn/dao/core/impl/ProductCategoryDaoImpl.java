package com.rjn.dao.core.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.core.AbstractDao;
import com.rjn.dao.core.ProductCategoryDao;
import com.rjn.model.core.ProductCategory;

@Repository("productCategoryDao")
public class ProductCategoryDaoImpl extends AbstractDao<Integer, ProductCategory> implements ProductCategoryDao {

	@Override
	public void save(ProductCategory productCategory) {
		if (productCategory.getId() <=0 ) {
			persist(productCategory);
		} else {
			update(productCategory);
		}
	}

	@Override
	public List<ProductCategory> getAllCategory() {
		Criteria criteria=createEntityCriteria();
		return (List<ProductCategory>) criteria.list();
	}

	@Override
	public ProductCategory getCategory(int productCategoryId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", productCategoryId));
		return (ProductCategory) criteria.uniqueResult();
	}

}
