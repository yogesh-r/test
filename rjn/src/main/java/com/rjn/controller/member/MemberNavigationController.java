package com.rjn.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rjn.bean.ChangePasswordBean;
import com.rjn.bean.SearchBean;
import com.rjn.model.Account;
import com.rjn.model.CustomerProfile;
import com.rjn.model.VendorProfile;
import com.rjn.model.Branch.BranchProfile;
import com.rjn.model.core.ProductCategory;
import com.rjn.model.core.VendorLead;
import com.rjn.service.AccountService;
import com.rjn.service.BranchService;
import com.rjn.service.MemberService;
import com.rjn.service.ProductDetailsService;
import com.rjn.service.SearchService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.utils.Constant;

@Controller
@RequestMapping("/member")
public class MemberNavigationController {
	
	@Autowired
	private ApplicationUtils applicationUtils;
	
	@Autowired
	private VendorService vendorService; 
	
	@Autowired
	private MemberService memberService;
	
	@Autowired  
	private SearchService searchService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private ProductDetailsService productService;
	
	// ****************** home and search *******************
	@RequestMapping(value = { "/home"}, method = RequestMethod.GET)
	public String paernerHome(ModelMap model, HttpServletRequest request) {
		return "member/member_home";
	}
	
	@RequestMapping(value = { "/search"}, method = RequestMethod.GET)
	public String memberSearch(ModelMap model, HttpServletRequest request) {
		Object object =  request.getSession().getAttribute("authorities");
		List loginUser  = (List)object;
		if (loginUser != null) {
			model.put("headerType", loginUser.get(0));
		}
		
		String productKeyword = (String) request.getParameter("thisProduct");
		int cityId = Integer.valueOf(request.getParameter("cityId"));

		model.put("productKeyword", productKeyword);
		model.put("cityId", cityId);
		model.put("cityList", applicationUtils.getCitiesByState(Constant.STATE_CHHATTISGARH));

		SearchBean sb = new SearchBean();
		sb.setSearchProductKeyword(productKeyword);
		sb.setCityId(cityId);
		model.put("results", searchService.findVendors(sb));
		model.put("cityList", applicationUtils.getCitiesByState(Constant.STATE_CHHATTISGARH));
		model.put("cityId", cityId);

		return "/search/search_branch";
	}
	
	// ****************** vendor profile ************************
	@RequestMapping(value = { "/{vendorId}" }, method = RequestMethod.GET)
	public String paernerHome(ModelMap model, HttpServletRequest request, @PathVariable String vendorId) {
		VendorProfile thisVendor = vendorService.getVendor(vendorId);
		model.addAttribute("thisVendor", thisVendor);
		Account loginUser = applicationUtils.getLoggedInUser();
		CustomerProfile profileMaster = getMemberDetails(loginUser.getReg_id());
		
		VendorLead vendorLead = applicationUtils.getLeadsByVendorAndUserId(loginUser.getId(), thisVendor.getId());
		if (vendorLead == null) {
			vendorLead = new VendorLead();
		}
		vendorLead.setVendorId(thisVendor.getId());
		vendorLead.setVendorName(thisVendor.getVendorFirstName());
		vendorLead.setUserId(loginUser.getId());
		vendorLead.setName(loginUser.getMy_user_name());
		
		vendorLead.setMobileNo(profileMaster.getContactMobileNo());
		vendorLead.setAddress(profileMaster.getAddress());
		vendorLead.setEmail(profileMaster.getContactEmailId());
		
		int count = 0;
		if (vendorLead.getId() != null) {
			count = vendorLead.getVisitCount() + 1;
			vendorLead.setVisitCount(count);
		}
		applicationUtils.saveVendorLead(vendorLead);
		model.put("headerType", Constant.ROLE_MEMBER);
		model.put("url", "member");
		return "vendor-profile/vendor-profile";
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
		model.put("url", "member");
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
		model.put("url", "member");
		return "vendor-profile-map";
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
		model.put("url", "member");
		return "vendor-profile/vendor-profile-branches";
	}

	// ************** Edit profile ******************************
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.GET)
	public String memberEditProfile(ModelMap model) {
		Account loginUser = applicationUtils.getLoggedInUser();
		CustomerProfile profileMaster = getMemberDetails(loginUser.getReg_id());
		model.addAttribute("memberDetails", profileMaster);
		return "member/member-edit-profile"; 
	}
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.POST)
	public String memberUpdateProfile( @Valid CustomerProfile profileMaster, BindingResult result , ModelMap model) {
		memberService.saveMemberDetails(profileMaster); 
		return "member/member-edit-profile";
	}
	
	// ***************** change password ******************** 
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.GET)
	public String memberChangePassword(ModelMap model) {
		return "member/member_change_password"; 
	}
	
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.POST)
	public @ResponseBody Object updateMemberPassword(@RequestBody ChangePasswordBean forgetPasswordBean) {
		Map<String, Object> model1 = new HashMap<String, Object>();
		Account loginUser = applicationUtils.getLoggedInUser();
		String dbPassword = loginUser.getPassword();
		String uiOldpassword =forgetPasswordBean.getOldPassword();
		String newpassword=forgetPasswordBean.getNewPassword();
		
		if (applicationUtils.matchPassword(uiOldpassword, dbPassword)) {
			loginUser.setPassword(applicationUtils.encryptPassword(newpassword));
			accountService.updatePassword(loginUser);
			model1.put("result", "Success");
			return model1;
		} else {
			model1.put("result", "Failure");
			return model1;
		}
		//return null;
	}
	// *************************** private methods ***************************
	private CustomerProfile getMemberDetails(String regId){
		return memberService.getProfileMasterByprofileNumber(regId);
	}
}