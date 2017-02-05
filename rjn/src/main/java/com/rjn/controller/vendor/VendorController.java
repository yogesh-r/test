package com.rjn.controller.vendor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	public String vendorEditBranch(ModelMap model, @PathVariable String uniqueId) {
		VendorProfile loginVendor = getLoginVendorDetails();
		model.addAttribute("vendorDetails", loginVendor);
		
		BranchProfile thisBranch = branchService.getBranchByUniqueId(uniqueId);
		if (loginVendor.getId().equals(thisBranch.getBranchOwner()) ){
			model.addAttribute("vendorDetails", loginVendor);
			model.addAttribute("thisBranch", branchService.getBranchByUniqueId(uniqueId) );	
		} else {
			model.addAttribute("errorMessage", "Sorry this branch dosent exist please register your own branch" );
		}
		return "vendor/vendor_register-branch";
	}

	@RequestMapping(value = { "/register-branch" }, method = RequestMethod.POST)
	public String paernerSaveRegister(@Valid BranchProfile branchMasterDetails, BindingResult result, ModelMap model) {
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    String currentDate = sdf.format(cal.getTime());
		SeqId seqId = seqGenerator.getSeqId(SeqConstant.BRANCH_UNIQUE_SEQ);
		String bracnhUniqueId = seqId.getSeqName() + "-" + currentDate + "-"+ seqId.getSeqNum();
		branchMasterDetails.setUniqueId(bracnhUniqueId);
		branchService.saveBranch(branchMasterDetails);
		return "vendor/vendor_register-branch";
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
		model.addAttribute("vendorDetails", getLoginVendorDetails());
		return "vendor/vendor-edit-profile";
	}
	
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.GET)
	public String vendorChangePassword(ModelMap model) {
		model.addAttribute("vendorDetails", getLoginVendorDetails());
		return "vendor/vendor-change-password"; 
	}
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.POST)
	public String vendorUpdateProfile(@Valid VendorProfile vendorDetails,BindingResult result, ModelMap model) {
		vendorservice.saveVendorDetails(vendorDetails);
		return "vendor/vendor-edit-profile";
	}

	@RequestMapping(value = { "/change-password" }, method = RequestMethod.POST)
	public String updateVendorPassword(@Valid ChangePassworddBean forgetPasswordBean,BindingResult result,ModelMap model) {
		Account loginUser = utils.getLoggedInUser();
		String dbPassword = loginUser.getPassword();
		String uiOldpassword =forgetPasswordBean.getOldPassword();
		String newpassword=forgetPasswordBean.getNewPassword();
		
		if (utils.matchPassword(uiOldpassword, dbPassword)) {
			loginUser.setPassword(utils.encryptPassword(newpassword));
			accountService.updatePassword(loginUser);
		} else {
			return "wrong-password";
		}
		return null;
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