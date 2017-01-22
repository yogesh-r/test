package com.rjn.dao;

import java.util.List;

import com.rjn.model.product.VendorProduct;

public interface VendorProductDao {
	void saveProduct(VendorProduct vendorProduct);
	List<VendorProduct> getProductByVendor(String vendorId);
	VendorProduct getProduct(int productID);
	
	VendorProduct getProductByUniqueID(String uniqueID);
	
	List<String> getKeyWord();
}
