package com.rjn.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rjn.bean.ForgetPasswordBean;
import com.rjn.bean.SearchBean;
import com.rjn.model.Account;
import com.rjn.model.ProfileMaster;
import com.rjn.model.VendorProfile;
import com.rjn.model.core.VendorLead;
import com.rjn.service.MemberService;
import com.rjn.service.SearchService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.utils.Constant;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	ApplicationUtils utils;
	
	@Autowired
	VendorService partnerService; 
	
	@Autowired
	MemberService memberService;
	
	@Autowired  
	SearchService searchService;
	
	@RequestMapping(value = { "/home"}, method = RequestMethod.GET)
	public String paernerHome(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("thisUserMenu", utils.getMenu(Constant.MEMBER));
		Account loginUser = utils.getLoggedInUser();
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
		
		SearchBean sb = new SearchBean();
		sb.setSearchProductKeyword(productKeyword);
		
		model.put("results", searchService.findVendors(sb));
		return "/search/search_branch";
	}
	
	@RequestMapping(value = { "/{partId}" }, method = RequestMethod.GET)
	public String paernerHome(ModelMap model, HttpServletRequest request, @PathVariable String partId) {
		
		VendorProfile thisVendor = partnerService.getPartner(partId);
		model.addAttribute("thisVendor", thisVendor);
		Account loginUser = utils.getLoggedInUser();
		ProfileMaster profileMaster = getMemberDetails(loginUser.getReg_id());
		VendorLead vendorLead = utils.getLeadsByVendorAndUserId(loginUser.getId(), thisVendor.getId());
		if (vendorLead == null) {
			vendorLead = new VendorLead();
		}
		vendorLead.setVendorId(thisVendor.getId());
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
		utils.saveVendorLead(vendorLead);
		return "vendor-profile";
	}
	
	private ProfileMaster getMemberDetails(String regId){
		return memberService.getProfileMasterByprofileNumber(regId);
	}
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.GET)
	public String memberEditProfile(ModelMap model) {
		Account loginUser = utils.getLoggedInUser();
		ProfileMaster profileMaster = getMemberDetails(loginUser.getReg_id());

		model.addAttribute("memberDetails", profileMaster);
		return "member/member-edit-profile"; 
	}
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.POST)
	public String memberUpdateProfile( @Valid ProfileMaster profileMaster, BindingResult result , ModelMap model) {
		System.out.println("edit profile member controller"+profileMaster);
		memberService.saveMemberDetails(profileMaster); 
		
		return "member/member-edit-profile"; 
	}
	
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.GET)
	public String memberChangePassword(ModelMap model) {
		return "member/member_change_password"; 
	}
	
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.POST)
	public String updateMemberPassword(@Valid ForgetPasswordBean forgetPasswordBean,BindingResult result, ModelMap model) {
		System.out.println("cntroller"+forgetPasswordBean.getOldPassword());
		return null; 
	}
}