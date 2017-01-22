package com.rjn.dao.core;

import java.util.List;

import com.rjn.model.core.ProductCategory;

public interface ProductCategoryDao {
	
	void save(ProductCategory productCategory);
	
	List<ProductCategory> getAllCategory();

	ProductCategory getCategory(int productCategoryId);
}
