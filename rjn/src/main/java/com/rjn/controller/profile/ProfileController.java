package com.rjn.controller.profile;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.rjn.model.VendorProfile;
import com.rjn.model.Branch.BranchMasterDetails;
import com.rjn.service.BranchService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;

@Controller
@RequestMapping("/vendor-profile")
public class ProfileController {
	
	@Autowired
	ApplicationUtils utils;
	
	@Autowired
	VendorService partnerService; 
	
	@Autowired
	BranchService branch_service;

	@RequestMapping(value = { "/{partId}" }, method = RequestMethod.GET)
	public String paernerHome(ModelMap model, HttpServletRequest request, @PathVariable String partId) {
		VendorProfile thisVendor = partnerService.getPartner(partId);
		model.addAttribute("thisVendor", thisVendor);
		Object object =  request.getSession().getAttribute("authorities");
		List loginUser  = (List)object;
		if (loginUser != null) {
			model.put("headerType", loginUser.get(0));
		}
		System.out.println("partner id controller");
		return "vendor-profile";
	}
	
	@RequestMapping(value = { "/{partId}/branch-list" }, method = RequestMethod.GET)
	public String branchList(HttpServletRequest request,ModelMap model,@PathVariable String partId) {
		Object object =  request.getSession().getAttribute("authorities");
		List loginUser  = (List)object;
		if (loginUser != null) {
			model.put("headerType", loginUser.get(0));
		}
		VendorProfile thisVendor = partnerService.getPartner(partId);
		model.addAttribute("thisVendor", thisVendor);
		List<BranchMasterDetails> branch_details=branch_service.getBranchByPartner(partId);
		System.out.println("branch details?>>> "+branch_details);
		model.addAttribute("branch",branch_details);
		System.out.println("branch list id controller");
		return "vendor-profile";
		
	}
	
	@RequestMapping(value = { "/{partId}/{uniquieId}" }, method = RequestMethod.GET)
	public String branchData(HttpServletRequest request,ModelMap model,@PathVariable String uniquieId){
		System.out.println("branch id controller");
		Object object =  request.getSession().getAttribute("authorities");
		List loginUser  = (List)object;
		if (loginUser != null) {
			model.put("headerType", loginUser.get(0));
		}
		BranchMasterDetails branch_details=branch_service.getBranchDetails(uniquieId);
		System.out.println("branch details>>>> "+branch_details);
		model.addAttribute("branchName",branch_details);
		return "vendor-profile";
		
	}
}
