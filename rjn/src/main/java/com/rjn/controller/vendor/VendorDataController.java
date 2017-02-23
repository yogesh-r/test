package com.rjn.controller.vendor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rjn.model.Account;
import com.rjn.model.VendorProfile;
import com.rjn.model.Branch.BranchProfile;
import com.rjn.service.BranchService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;

@Controller
@RequestMapping("/vendor/rest")
public class VendorDataController {
	
	@Autowired
	private ApplicationUtils utils;

	@Autowired
	private BranchService branchService;
	
	@Autowired
	private VendorService vendorservice;
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.GET)
	public @ResponseBody Object paernerEditProfile(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("vendorDetails", getLoginVendorDetails());
		return model;
	}
	
	@RequestMapping(value = { "/branch-list" }, method = RequestMethod.GET)
	public @ResponseBody Object paernerBranchList(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		Account loginUser = utils.getLoggedInUser();
		model.put("vendorDetails", getLoginVendorDetails());
		List<BranchProfile> branchList =  branchService.getBranchByVendor(loginUser.getReg_id());
		model.put("branchList", branchList);
		return model;
	}
	private VendorProfile getLoginVendorDetails() {
		Account loginUser = utils.getLoggedInUser();
		VendorProfile loginvendor = vendorservice.getVendor(loginUser.getReg_id());
		return loginvendor;
	}
}