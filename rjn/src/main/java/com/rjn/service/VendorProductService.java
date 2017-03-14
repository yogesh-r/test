package com.rjn.service;

import java.util.List;

import com.rjn.model.product.VendorProduct;

public interface VendorProductService {
	void saveProduct(VendorProduct vendorProduct);
	List<VendorProduct> getProductByVendor(String vendorId);
	VendorProduct getProduct(int productID);
	VendorProduct getProductByUniqueID(String uniqueID);
	List<String> getKeyWord();
	void deleteProduct(VendorProduct vendorProduct);
}
