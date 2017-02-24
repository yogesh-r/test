package com.rjn.controller.admin;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rjn.bean.ChangePassworddBean;
import com.rjn.model.Account;
import com.rjn.model.VendorProfile;
import com.rjn.model.Branch.BranchProfile;
import com.rjn.service.AccountService;
import com.rjn.service.BranchService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.service.Core.SequenceGeneratorService;
import com.rjn.utils.Constant;

@Controller
@RequestMapping("/admin/rest")
public class AdminDataController {
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private SequenceGeneratorService seqGenerator;
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = { "/branch-list" }, method = RequestMethod.GET)
	public @ResponseBody ModelMap branchList(ModelMap model) {
		model.addAttribute("allVendors", "Yes");
		return model;
	}
	
	@RequestMapping(value = { "/lead-list" }, method = RequestMethod.GET)
	public @ResponseBody Object leadsList(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("controller calledd >>>>");
		model.put("leads", utils.getLeadsForAdmin());
		return model;
	}
	
	@RequestMapping(value = { "/enquiry-list" }, method = RequestMethod.GET)
	public @ResponseBody Object enquiryList(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		int limit = Constant.PAGINATION_LIMIT;
		int startingPage = Integer.parseInt(request.getParameter("pageNo"));
		model.put("vendorEnquirys", vendorService.getBusinessEnquiryList(limit,startingPage));
		return model;
	}
	
	@RequestMapping(value = { "/vendor-list" }, method = RequestMethod.GET)
	public @ResponseBody Object vendorList(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		int limit = Constant.PAGINATION_LIMIT;
		int startingPage = Integer.parseInt(request.getParameter("pageNo"));
		model.put("vendorList", vendorService.getAllVendors( limit, startingPage));
		return model;
	}
	
	
	@RequestMapping(value = { "/product-category-list" }, method = RequestMethod.GET)
	public  @ResponseBody Object productCategoryList(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("categoryList", utils.getAllCategory());
		return model;
	}
	
	@RequestMapping(value = { "/register-category/{categoryId}" }, method = RequestMethod.GET)
	public @ResponseBody Object editCategory(@PathVariable int categoryId, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("thisCategory", utils.getCategory(categoryId));
		return model;
	}
	
	@RequestMapping(value = { "/branch-details" }, method = RequestMethod.GET)
	public @ResponseBody Object branchData(HttpServletRequest request) {
		Map<String,Object>model=new HashMap<String,Object>();
		model.put("thisBranch", branchService.getBranchDetails());
		return model;
		
	}
	
	@RequestMapping(value = { "/register-branch" }, method = RequestMethod.POST)
	public @ResponseBody Object paernerSaveRegister(@RequestBody  BranchProfile branchMasterDetails) {
		Map<String,Object>model=new HashMap<String,Object>();
		branchService.saveBranch(branchMasterDetails);
		model.put("thisCategory", "success");
		return model;
	}
	
	@RequestMapping(value = { "/edit-branch/{branchId}" }, method = RequestMethod.GET)
	public @ResponseBody Object editBranch(@PathVariable int branchId,HttpServletRequest request) {
		Map<String,Object>model=new HashMap<String,Object>();
		model.put("editBranch", branchService.getBranchData(branchId));
		return model;
		
	}
	
	
	@RequestMapping(value = { "/register-vendor/{vendorId}" }, method = RequestMethod.GET)
	public @ResponseBody Object vendorProfile(HttpServletRequest request, @PathVariable String vendorId) {
		Map<String, Object> model = new HashMap<String, Object>();
		VendorProfile thisVendor = vendorService.getVendor(vendorId);
		model.put("thisVendor", thisVendor);
		return model;
	}
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.POST)
	public @ResponseBody Object updateVendorPassword(@RequestBody ChangePassworddBean forgetPasswordBean) {
		Map<String, Object> model = new HashMap<String, Object>();
		Account loginUser = utils.getLoggedInUser();
		String dbPassword = loginUser.getPassword();
		String uiOldpassword =forgetPasswordBean.getOldPassword();
		String newpassword=forgetPasswordBean.getNewPassword();
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

}
