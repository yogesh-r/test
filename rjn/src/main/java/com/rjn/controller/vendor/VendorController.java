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
import com.rjn.model.Branch.BranchMasterDetails;
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
	ApplicationUtils utils;

	@Autowired
	VendorService partnerservice;

	@Autowired
	BranchService branchService;

	@Autowired
	private SequenceGeneratorService seqGenerator;

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = { "/{partId}" }, method = RequestMethod.GET)
	public String partnerProfile(ModelMap model, HttpServletRequest request, @PathVariable String partId) {
		VendorProfile thisVendor = partnerservice.getPartner(partId);
		model.addAttribute("thisVendor", thisVendor);
		
		VendorProfile vendorProfile = getLoginPartnerDetails();
		model.addAttribute("PartnerDetails", vendorProfile);
		
		if (thisVendor.getId().equals(vendorProfile.getId())) {
			model.addAttribute("showVerifyButton", true);
		}
		model.put("headerType", Constant.ROLE_PARTNER);
		return "vendor-profile";
	}
	
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String paernerHome(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		model.addAttribute("PartnerDetails", getLoginPartnerDetails());
		return "vendor/vendor_home";
	}

	// Master
	@RequestMapping(value = { "/register-branch" }, method = RequestMethod.GET)
	public String paernerRegisterBranch(ModelMap model) {
		model.addAttribute("PartnerDetails", getLoginPartnerDetails());
		return "vendor/partner_register-branch"; 
	}

	@RequestMapping(value = { "/register-branch/{uniqueId}" }, method = RequestMethod.GET)
	public String partnerEditBranch(ModelMap model, @PathVariable String uniqueId) {
		VendorProfile loginPartner = getLoginPartnerDetails();
		model.addAttribute("PartnerDetails", loginPartner);
		
		BranchMasterDetails thisBranch = branchService.getBranchByUniqueId(uniqueId);
		if (loginPartner.getId().equals(thisBranch.getBranchOwner()) ){
			model.addAttribute("PartnerDetails", loginPartner);
			model.addAttribute("thisBranch", branchService.getBranchByUniqueId(uniqueId) );	
		} else {
			model.addAttribute("errorMessage", "Sorry this branch dosent exist please register your own branch" );
		}
		return "vendor/partner_register-branch";
	}

	@RequestMapping(value = { "/register-branch" }, method = RequestMethod.POST)
	public String paernerSaveRegister(@Valid BranchMasterDetails branchMasterDetails, BindingResult result, ModelMap model) {
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    String currentDate = sdf.format(cal.getTime());
		SeqId seqId = seqGenerator.getSeqId(SeqConstant.BRANCH_UNIQUE_SEQ);
		String bracnhUniqueId = seqId.getSeqName() + "-" + currentDate + "-"+ seqId.getSeqNum();
		branchMasterDetails.setUniqueId(bracnhUniqueId);
		branchService.saveBranch(branchMasterDetails);
		return "vendor/partner_register-branch";
	}

	@RequestMapping(value = { "/branch-list" }, method = RequestMethod.GET)
	public String paernerBranchList(ModelMap model) {
		Account loginUser = utils.getLoggedInUser();
		model.addAttribute("PartnerDetails", getLoginPartnerDetails());
		List<BranchMasterDetails> branchList =  branchService.getBranchByPartner(loginUser.getReg_id());
		model.addAttribute("branchList", branchList);
		return "vendor/partner-branch-list";
	}

	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.GET)
	public String paernerEditProfile(ModelMap model) {
		model.addAttribute("PartnerDetails", getLoginPartnerDetails());
		return "vendor/vendor-edit-profile";
	}
	
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.GET)
	public String vendorChangePassword(ModelMap model) {
		model.addAttribute("PartnerDetails", getLoginPartnerDetails());
		return "vendor/vendor-change-password"; 
	}
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.POST)
	public String vendorUpdateProfile(@Valid VendorProfile partnerDetails,BindingResult result, ModelMap model) {
		partnerservice.savePartnerDetails(partnerDetails);
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

	private VendorProfile getLoginPartnerDetails() {
		Account loginUser = utils.getLoggedInUser();
		VendorProfile loginPartner = partnerservice.getPartner(loginUser.getReg_id());
		return loginPartner;
	}

	private List<BranchMasterDetails> getLocationListForPartner(String cityId, String partnerId) {
		List<BranchMasterDetails> locationList = null;
		locationList = branchService.getLocationByCity(cityId, partnerId);
		return locationList;
	}

	private List<BranchMasterDetails> getBranchListForPartner(String cityId,String partnerId, String location) {
		List<BranchMasterDetails> locationList = null;
		locationList = branchService.getBranchList(cityId, partnerId, location);
		return locationList;
	}
}