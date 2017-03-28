package com.rjn.controller.profile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rjn.model.Account;
import com.rjn.model.VendorProfile;
import com.rjn.model.Branch.BranchProfile;
import com.rjn.model.core.ProductCategory;
import com.rjn.service.BranchService;
import com.rjn.service.ProductDetailsService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.utils.Constant;

@Controller
@RequestMapping("/vendor-profile")
public class ProfileController {
	
	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private VendorService vendorService; 
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private ProductDetailsService productService;

	
	@RequestMapping(value = { "/{vendorId}" }, method = RequestMethod.GET)
	public String paernerHome(ModelMap model, HttpServletRequest request, @PathVariable String vendorId) {
		VendorProfile thisVendor = vendorService.getVendor(vendorId);
		model.addAttribute("thisVendor", thisVendor);
		Object object =  request.getSession().getAttribute("authorities");
		List loginUser  = (List)object;
		if (loginUser != null) {
			if (Constant.ROLE_VENDOR.equals((String)loginUser.get(0).toString())) {
				return "redirect:/vendor/"+thisVendor.getId(); 
			} else if (Constant.ROLE_MEMBER.equals((String)loginUser.get(0).toString())) {
				return "redirect:/member/"+thisVendor.getId();
			}  else if (Constant.ROLE_ADMIN.equals((String)loginUser.get(0).toString())) {
				return "redirect:/admin/"+thisVendor.getId();
			}
		} 
		return "vendor-profile/vendor-profile";
	}
	
	@RequestMapping(value = { "/{vendorId}/{uniquieId}" }, method = RequestMethod.GET)
	public String branchData(HttpServletRequest request,ModelMap model,@PathVariable String uniquieId){
		Object object =  request.getSession().getAttribute("authorities");
		List loginUser  = (List)object;
		if (loginUser != null) {
			model.put("headerType", loginUser.get(0));
		}
		BranchProfile branch_details=branchService.getBranchDetails(uniquieId);
		model.addAttribute("branchName",branch_details);
		return "vendor-profile/vendor-profile";
	}
	
	@RequestMapping(value = { "/{vendorId}/branch-list" }, method = RequestMethod.GET)
	public String branchList(HttpServletRequest request,ModelMap model,@PathVariable String vendorId) {
		Object object =  request.getSession().getAttribute("authorities");
		List loginUser  = (List)object;
		if (loginUser != null) {
			model.put("headerType", loginUser.get(0));
		}
		VendorProfile thisVendor = vendorService.getVendor(vendorId);
		model.addAttribute("thisVendor", thisVendor);
		List<BranchProfile> branch_details=branchService.getBranchByVendor(vendorId);
		model.addAttribute("branch",branch_details);
		return "vendor-profile/vendor-profile-branches";
	}
	
	@RequestMapping(value = { "/{vendorId}/product-list" }, method = RequestMethod.GET)
	public String productData(HttpServletRequest request,ModelMap model, @PathVariable String vendorId){
		Object object =  request.getSession().getAttribute("authorities");
		List loginUser  = (List)object;
		if (loginUser != null) {
			model.put("headerType", loginUser.get(0));
		}
		VendorProfile thisVendor = vendorService.getVendor(vendorId);
		model.addAttribute("thisVendor", thisVendor);
		List<BranchProfile> branch_details=branchService.getBranchByVendor(vendorId);
		
		List<ProductCategory> product=productService.getProductDetails();
		model.addAttribute("product", product);
		return "vendor-profile/vendor-profile-products";
	}
	
	@RequestMapping(value = { "/{vendorId}/map" }, method = RequestMethod.GET)
	public String mapData(HttpServletRequest request,ModelMap model, @PathVariable String vendorId){
		Object object =  request.getSession().getAttribute("authorities");
		List loginUser  = (List)object;
		if (loginUser != null) {
			model.put("headerType", loginUser.get(0));
		}
		VendorProfile thisVendor = vendorService.getVendor(vendorId);
		model.addAttribute("thisVendor", thisVendor);
		List<BranchProfile> branch_details=branchService.getBranchByVendor(vendorId);
		return "vendor-profile-map";
	}
	
	
	@RequestMapping(value = { "/{vendorId}/overview" }, method = RequestMethod.GET)
	public String overview(HttpServletRequest request,ModelMap model, @PathVariable String vendorId){
		
		VendorProfile thisVendor = vendorService.getVendor(vendorId);
		model.addAttribute("thisVendor", thisVendor);
		Object object =  request.getSession().getAttribute("authorities");
		List loginUser  = (List)object;
		if (loginUser != null) {
			model.put("headerType", loginUser.get(0));
		}
		VendorProfile loginvendor = vendorService.getVendor(vendorId);
		if (loginUser!=null) {
				if(loginvendor.isVerified()==1){
					model.addAttribute("showVerifyButton", false);
				}else{
					model.addAttribute("showVerifyButton", true);
				}
		}
		
		return "vendor/overview";
		
	}
	
	private VendorProfile getLoginVendorDetails() {
		Account loginUser = utils.getLoggedInUser();
		VendorProfile loginvendor = vendorService.getVendor(loginUser.getReg_id());
		System.out.println("login data"+loginvendor);
		return loginvendor;
	}
}
