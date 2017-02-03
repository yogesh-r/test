package com.rjn.dao.core;

import java.util.List;

import com.rjn.model.core.ProductCategory;

public interface ProductCategoryDao {
	public void save(ProductCategory productCategory);
	public List<ProductCategory> getAllCategory();
	public ProductCategory getCategory(int productCategoryId);
	public void saveInBulk(List<ProductCategory> productCategoryList);
}
