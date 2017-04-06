package com.rjn.controller.vendor;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rjn.model.Account;
import com.rjn.model.VendorProfile;
import com.rjn.service.VendorProductService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;

@Controller
@RequestMapping("/vendor/product/rest")
public class VendorProductDataController {

	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private ApplicationUtils applicationUtils;
	
	@Autowired
	private VendorProductService productService;
	
	@RequestMapping(value = { "/product-list" }, method = RequestMethod.GET)
	public @ResponseBody Object productList(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		VendorProfile loginVendor = getLoginVendorDetails();
		model.put("productList", productService.getProductByVendor(loginVendor.getId()));
		
		return model; 
	}
	
	private VendorProfile getLoginVendorDetails() {
		Account loginUser = applicationUtils.getLoggedInUser();
		VendorProfile loginVendor = vendorService.getVendor(loginUser.getReg_id());
		return loginVendor;
	}
}
