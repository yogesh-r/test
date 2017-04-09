package com.rjn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rjn.dao.VendorProductDao;
import com.rjn.model.product.VendorProduct;
import com.rjn.service.VendorProductService;

@Service("vendorProductService")
@Transactional
public class VendorProductServiceImpl implements VendorProductService {

	@Autowired 
	private VendorProductDao dao; 
	
	@Override
	public void saveProduct(VendorProduct vendorProduct) {
		dao.saveProduct(vendorProduct);
	}

	@Override
	public List<VendorProduct> getProductByVendor(String vendorId) {
		return dao.getProductByVendor(vendorId);
	}

	@Override
	public VendorProduct getProduct(int productID) {
		return dao.getProduct(productID);
	}

	@Override
	public VendorProduct getProductByUniqueID(String uniqueID) {
		return dao.getProductByUniqueID(uniqueID);
	}

	@Override
	public List<String> getKeyWord() {
		return dao.getKeyWord();
	}

	@Override
	public void deleteProduct(VendorProduct vendorProduct) {
		dao.deleteProduct(vendorProduct);
	}

	@Override
	public List<VendorProduct> getProductByVendorAndBranch(String vendorId,int branch) {
		return dao.getProductByVendorAndBranch(vendorId, branch);
	}
}
