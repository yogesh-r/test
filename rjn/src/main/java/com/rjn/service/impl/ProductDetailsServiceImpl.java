package com.rjn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.dao.ProductDetailsDao;
import com.rjn.model.core.ProductCategory;
import com.rjn.service.ProductDetailsService;

@Service("productService")
@Transactional
public class ProductDetailsServiceImpl implements ProductDetailsService {
	
	@Autowired
	private ProductDetailsDao productDetailsDao;

	@Override
	public List<ProductCategory> getProductDetails() {
		return productDetailsDao.getProductDetails();
	}
}
