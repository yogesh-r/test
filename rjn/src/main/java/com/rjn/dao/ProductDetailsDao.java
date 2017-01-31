package com.rjn.dao;

import java.util.List;

import com.rjn.model.core.ProductCategory;

public interface ProductDetailsDao {
	List<ProductCategory> getProductDetails();
}