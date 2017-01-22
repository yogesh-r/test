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
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;

@Controller
@RequestMapping("/vendor-profile")
public class ProfileController {
	
	@Autowired
	ApplicationUtils utils;
	
	@Autowired
	VendorService partnerService; 

	@RequestMapping(value = { "/{partId}" }, method = RequestMethod.GET)
	public String paernerHome(ModelMap model, HttpServletRequest request, @PathVariable String partId) {
		VendorProfile thisVendor = partnerService.getPartner(partId);
		model.addAttribute("thisVendor", thisVendor);
		Object object =  request.getSession().getAttribute("authorities");
		List loginUser  = (List)object;
		if (loginUser != null) {
			model.put("headerType", loginUser.get(0));
		}
		return "vendor-profile";
	}
}
