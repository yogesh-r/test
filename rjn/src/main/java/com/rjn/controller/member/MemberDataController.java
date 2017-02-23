package com.rjn.controller.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rjn.model.Account;
import com.rjn.model.CustomerProfile;
import com.rjn.model.VendorProfile;
import com.rjn.service.MemberService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;

@Controller
@RequestMapping("/member/rest")
public class MemberDataController {
	
	@Autowired
	private ApplicationUtils utils;

	
	@Autowired
	private MemberService memberService;
	
	
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.GET)
	public @ResponseBody Object memberEditProfile(HttpServletRequest request) {
		Account loginUser = utils.getLoggedInUser();
		CustomerProfile profileMaster = getMemberDetails(loginUser.getReg_id());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("profileMaster", profileMaster);
		return model; 
	}
	
	private CustomerProfile getMemberDetails(String regId){
		return memberService.getProfileMasterByprofileNumber(regId);
	}
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.POST)
	public @ResponseBody Object memberUpdateProfile(@RequestBody CustomerProfile profileMaster) {
		memberService.saveOrUpdateMember(profileMaster);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("result", "success");
		return model;
	}

}
