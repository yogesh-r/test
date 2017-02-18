package com.rjn.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rjn.model.VendorProfile;
import com.rjn.service.BranchService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.utils.Constant;

@Controller
@RequestMapping("/admin/rest")
public class AdminDataController {
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private ApplicationUtils utils;

	@RequestMapping(value = { "/branch-list" }, method = RequestMethod.GET)
	public @ResponseBody ModelMap branchList(ModelMap model) {
		model.addAttribute("allVendors", "Yes");
		return model;
	}
	
	@RequestMapping(value = { "/enquiry-list" }, method = RequestMethod.GET)
	public @ResponseBody Object enquiryList(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		int limit = Constant.PAGINATION_LIMIT;
		int startingPage = Integer.parseInt(request.getParameter("pageNo"));
		model.put("vendorEnquirys", vendorService.getBusinessEnquiryList(limit,startingPage));
		return model;
	}
	
	@RequestMapping(value = { "/vendor-list" }, method = RequestMethod.GET)
	public @ResponseBody Object vendorList(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		int limit = Constant.PAGINATION_LIMIT;
		int startingPage = Integer.parseInt(request.getParameter("pageNo"));
		model.put("vendorList", vendorService.getAllVendors( limit, startingPage));
		return model;
	}
	
	
	@RequestMapping(value = { "/product-category-list" }, method = RequestMethod.GET)
	public  @ResponseBody Object productCategoryList(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("categoryList", utils.getAllCategory());
		return model;
	}
	
	@RequestMapping(value = { "/register-category/{categoryId}" }, method = RequestMethod.GET)
	public @ResponseBody Object editCategory(@PathVariable int categoryId, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("thisCategory", utils.getCategory(categoryId));
		return model;
	}
	
	
	
	
	
	@RequestMapping(value = { "/register-vendor/{vendorId}" }, method = RequestMethod.GET)
	public @ResponseBody Object vendorProfile(HttpServletRequest request, @PathVariable String vendorId) {
		Map<String, Object> model = new HashMap<String, Object>();
		VendorProfile thisVendor = vendorService.getVendor(vendorId);
		model.put("thisVendor", thisVendor);
		return model;
	}

}
