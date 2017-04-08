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
import com.rjn.utils.Constant;

@Controller
@RequestMapping("/vendor-profile")
public class VendorProfileController {

	@Autowired
	private VendorService vendorService; 
	
	@RequestMapping(value = { "/{vendorId}", "/{vendorId}/{uniquieId}" , "/{vendorId}/branch-list",  "/{vendorId}/product-list", "/{vendorId}/map", "/{vendorId}/overview" }, method = RequestMethod.GET)
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
		return "redirect:/login/";
	}
}
