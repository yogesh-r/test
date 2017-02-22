package com.rjn.controller.vendor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.rjn.bean.ChangePassworddBean;
import com.rjn.model.Account;
import com.rjn.model.SeqId;
import com.rjn.model.VendorProfile;
import com.rjn.model.Branch.BranchProfile;
import com.rjn.service.AccountService;
import com.rjn.service.BranchService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.service.Core.SequenceGeneratorService;
import com.rjn.utils.Constant;
import com.rjn.utils.SeqConstant;

@Controller
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private ApplicationUtils utils;

	@Autowired
	private VendorService vendorservice;

	@Autowired
	private BranchService branchService;

	@Autowired
	private SequenceGeneratorService seqGenerator;

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = { "/{vendorId}" }, method = RequestMethod.GET)
	public String vendorProfile(ModelMap model, HttpServletRequest request, @PathVariable String vendorId) {
		VendorProfile thisVendor = vendorservice.getVendor(vendorId);
		model.addAttribute("thisVendor", thisVendor);
		VendorProfile vendorProfile = getLoginVendorDetails();
		model.addAttribute("vendorDetails", vendorProfile);
		if (thisVendor.getId().equals(vendorProfile.getId())) {
			model.addAttribute("showVerifyButton", true);
		}
		model.put("headerType", Constant.ROLE_VENDOR);
		return "vendor-profile";
	}
	
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String paernerHome(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("vendorDetails", getLoginVendorDetails());
		return "vendor/vendor_home";
	}

	// Master
	@RequestMapping(value = { "/register-branch" }, method = RequestMethod.GET)
	public String paernerRegisterBranch(ModelMap model) {
		model.addAttribute("vendorDetails", getLoginVendorDetails());
		return "vendor/vendor_register-branch"; 
	}

	@RequestMapping(value = { "/register-branch/{uniqueId}" }, method = RequestMethod.GET)
	public @ResponseBody Object vendorEditBranch(@PathVariable String uniqueId) {
		Map<String, Object> model = new HashMap<String, Object>();
		VendorProfile loginVendor = getLoginVendorDetails();
		model.put("vendorDetails", loginVendor);
		
		BranchProfile thisBranch = branchService.getBranchByUniqueId(uniqueId);
		if (loginVendor.getId().equals(thisBranch.getBranchOwner()) ){
			model.put("vendorDetails", loginVendor);
			model.put("thisBranch", branchService.getBranchByUniqueId(uniqueId) );	
		} else {
			model.put("errorMessage", "Sorry this branch dosent exist please register your own branch" );
		}
		return model;
	}

	@RequestMapping(value = { "/register-branch" }, method = RequestMethod.POST)
	public @ResponseBody Object paernerSaveRegister(@RequestBody BranchProfile branchMasterDetails) {
		Map<String, Object> model = new HashMap<String, Object>();
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    String currentDate = sdf.format(cal.getTime());
		SeqId seqId = seqGenerator.getSeqId(SeqConstant.BRANCH_UNIQUE_SEQ);
		String bracnhUniqueId = seqId.getSeqName() + "-" + currentDate + "-"+ seqId.getSeqNum();
		branchMasterDetails.setUniqueId(bracnhUniqueId);
		branchService.saveBranch(branchMasterDetails);
		model.put("message", "success");
		return model;
	}

	@RequestMapping(value = { "/branch-list" }, method = RequestMethod.GET)
	public String paernerBranchList(ModelMap model) {
		Account loginUser = utils.getLoggedInUser();
		model.addAttribute("vendorDetails", getLoginVendorDetails());
		List<BranchProfile> branchList =  branchService.getBranchByVendor(loginUser.getReg_id());
		model.addAttribute("branchList", branchList);
		return "vendor/vendor-branch-list";
	}

	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.GET)
	public String paernerEditProfile(ModelMap model) {
		//model.addAttribute("vendorDetails", getLoginVendorDetails());
		return "vendor/vendor-edit-profile";
	}
	
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.GET)
	public String vendorChangePassword(ModelMap model) {
		model.addAttribute("vendorDetails", getLoginVendorDetails());
		return "vendor/vendor-change-password"; 
	}
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.POST)
	public @ResponseBody Object vendorUpdateProfile(@RequestBody VendorProfile vendorDetails) {
		Map<String, Object> model = new HashMap<String, Object>();
		vendorservice.updateVendorDetails(vendorDetails);
		model.put("success", "success");
		return model;
	}

	@RequestMapping(value = { "/change-password" }, method = RequestMethod.POST)
	public @ResponseBody Object updateVendorPassword(@RequestBody ChangePassworddBean forgetPasswordBean) {
		Map<String, Object> model = new HashMap<String, Object>();
		Account loginUser = utils.getLoggedInUser();
		String dbPassword = loginUser.getPassword();
		String uiOldpassword =forgetPasswordBean.getOldPassword();
		String newpassword=forgetPasswordBean.getNewPassword();
		
		System.out.println("uiOldpassword >> "+uiOldpassword);
		System.out.println("dbPassword ?? "+dbPassword);
		if (utils.matchPassword(uiOldpassword, dbPassword)) {
			loginUser.setPassword(utils.encryptPassword(newpassword));
			accountService.updatePassword(loginUser);
		} else {
			model.put("result", "Failure");
			return model;
		}
		model.put("result", "success");
		return model;
	}
	
	@RequestMapping(value = { "/verify" }, method = RequestMethod.GET)
	public String verify(ModelMap model, HttpServletRequest request) {
		VendorProfile vendorProfile = getLoginVendorDetails();
		vendorservice.updateVerify(vendorProfile.getId(), true);
		return "vendor/vendor_home";
	}
	
	private VendorProfile getLoginVendorDetails() {
		Account loginUser = utils.getLoggedInUser();
		VendorProfile loginvendor = vendorservice.getVendor(loginUser.getReg_id());
		return loginvendor;
	}

	private List<BranchProfile> getLocationListForVendor(String cityId, String vendorId) {
		List<BranchProfile> locationList = null;
		locationList = branchService.getLocationByCity(cityId, vendorId);
		return locationList;
	}

	private List<BranchProfile> getBranchListForVendor(String cityId,String vendorId, String location) {
		List<BranchProfile> locationList = null;
		locationList = branchService.getBranchList(cityId, vendorId, location);
		return locationList;
	}
}