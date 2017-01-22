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

import com.rjn.bean.ForgetPasswordBean;
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

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String paernerHome(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("thisUserMenu", utils.getMenu(Constant.PARTNER));
		return "partner/partner_home";
	}

	// Master
	@RequestMapping(value = { "/register-branch" }, method = RequestMethod.GET)
	public String paernerRegisterBranch(ModelMap model) {
		model.addAttribute("PartnerDetails", getLoginPartnerDetails());
		return "partner/partner_register-branch"; 
	}

	@RequestMapping(value = { "/register-branch/{uniqueId}" }, method = RequestMethod.GET)
	public String partnerEditBranch(ModelMap model, @PathVariable String uniqueId) {
		VendorProfile loginPartner = getLoginPartnerDetails();
		BranchMasterDetails thisBranch = branchService.getBranchByUniqueId(uniqueId);
		if (loginPartner.getId().equals(thisBranch.getBranchOwner()) ){
			model.addAttribute("PartnerDetails", loginPartner);
			model.addAttribute("thisBranch", branchService.getBranchByUniqueId(uniqueId) );	
		} else {
			model.addAttribute("errorMessage", "Sorry this branch dosent exist please register your own branch" );
		}
		return "partner/partner_register-branch";
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
		return "partner/partner_register-branch";
	}

	@RequestMapping(value = { "/branch-list" }, method = RequestMethod.GET)
	public String paernerBranchList(ModelMap model) {
		Account loginUser = utils.getLoggedInUser();
		model.addAttribute("PartnerDetails", getLoginPartnerDetails());
		List<BranchMasterDetails> branchList =  branchService.getBranchByPartner(loginUser.getReg_id());
		model.addAttribute("branchList", branchList);
		return "partner/partner-branch-list";
	}

	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.GET)
	public String paernerEditProfile(ModelMap model) {
		model.addAttribute("PartnerDetails", getLoginPartnerDetails());
		return "partner/vendor-edit-profile";
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
	
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.GET)
	public String vendorChangePassword(ModelMap model) {
		return "partner/vendor-change-password"; 
	}
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.POST)
	public String vendorUpdateProfile(@Valid VendorProfile partnerDetails,BindingResult result, ModelMap model) {
		System.out.println("form controller1");
		partnerservice.savePartnerDetails(partnerDetails);
		System.out.println("form controller2");
		return "partner/vendor-edit-profile";
	}

	@RequestMapping(value = { "/change-password" }, method = RequestMethod.POST)
	public String updateVendorPassword(@Valid ForgetPasswordBean forgetPasswordBean,BindingResult result,ModelMap model) {
		System.out.println("controller"+forgetPasswordBean.getOldPassword());
		Account loginUser = utils.getLoggedInUser();
		
		
		
		String dbPassword = loginUser.getPassword();
		String uiOldpassword =forgetPasswordBean.getOldPassword();
		String newpassword=forgetPasswordBean.getNewPassword();
		System.out.println("new password"+forgetPasswordBean.getNewPassword());
		
		if (utils.matchPassword(uiOldpassword, dbPassword)) {
			System.out.println("inside if");
			
			loginUser.setPassword(utils.encryptPassword(newpassword));
			accountService.updatePassword(loginUser);
			
		} else {
			System.out.println("inside else");
			return "wrong-password";
		}
		
		return null;
	}
	
}