package com.rjn.controller.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.rjn.bean.ChangePassworddBean;
import com.rjn.bean.ExcelFile;
import com.rjn.model.Account;
import com.rjn.model.SeqId;
import com.rjn.model.VendorProfile;
import com.rjn.model.Branch.BranchMasterDetails;
import com.rjn.model.core.ProductCategory;
import com.rjn.service.AccountService;
import com.rjn.service.BranchService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.service.Core.LookUpService;
import com.rjn.service.Core.SequenceGeneratorService;
import com.rjn.utils.AppFileHandlingUtils;
import com.rjn.utils.SeqConstant;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	LookUpService lookUpService;

	@Autowired
	VendorService partnerservice;
	
	@Autowired
	private SequenceGeneratorService seqGenerator;

	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	BranchService branchService;
	
	@Autowired
	private AccountService accountService;
	
	//======================testing=========================================
	@RequestMapping(value = { "/uploadTest" }, method = RequestMethod.GET)
	public String testing(ModelMap model, HttpServletRequest request) {
		return "admin/upload_test";
	}
	
	@RequestMapping(value = { "/excel-read-test" }, method = RequestMethod.GET)
	public String testing11(ModelMap model, HttpServletRequest request) {
		return "admin/excel-read-test";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String processExcel2003(ModelMap model, @RequestParam("excelfile2007") MultipartFile excelfile) {
		try {
			String fileName = excelfile.getOriginalFilename();
			List<ExcelFile> thisFile = 	AppFileHandlingUtils.readExcelFile(excelfile, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "You successfully uploaded file=";
	}
	
	//======================testing=========================================
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(@RequestParam("file") MultipartFile file) {
		try {
			AppFileHandlingUtils.uploadFileToServer(file, "yogesh");
			return "You successfully uploaded file=";
		} catch (IOException e) {
			e.printStackTrace();
			return "You failed to upload  => " + e.getMessage();
		}
	}
	
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String whyUs(ModelMap model, HttpServletRequest request) {
/*		HttpSession session = request.getSession();
		List<Menu> thisMenu = utils.getMenu(Constant.ADMIN);
		session.setAttribute("thisUserMenu", thisMenu);*/
		return "admin/admin_home";
	}

	@RequestMapping(value = { "/register-vendor/{partId}" }, method = RequestMethod.GET)
	public String editPartner(ModelMap model, @PathVariable String partId) {
		VendorProfile thisVendor = partnerservice.getPartner(partId);
		model.addAttribute("thisVendor", thisVendor);
		return "admin/register-vendor";
	}
	
	@RequestMapping(value = { "/register-vendor" }, method = RequestMethod.GET)
	public String registerPartner(ModelMap model) {
/*		List<LookupMaster> license = lookUpService.getLookUpValuesData(Constant.LOOKUP_LICENSE);
		model.addAttribute("licenceList", license);*/
		return "admin/register-vendor";
	}

	@RequestMapping(value = { "/register-vendor" }, method = RequestMethod.POST)
	public String savePartner(@Valid VendorProfile partnerDetails, BindingResult result, ModelMap model) {
		if (partnerDetails.getId() == null || "".equals(partnerDetails.getId())) {
			Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		    String currentDate = sdf.format(cal.getTime());
		    
			SeqId seqId = seqGenerator.getSeqId(SeqConstant.PARTNER_SEQ);
			String profileNumber = seqId.getSeqName() + "-" + currentDate + "-"+ seqId.getSeqNum();
			partnerDetails.setId(profileNumber);
			String unEncryptPass = partnerDetails.getPassword();
			partnerDetails.setPassword(utils.encryptPassword(unEncryptPass));
		}
		partnerservice.savePartnerDetails(partnerDetails);
		try {
			AppFileHandlingUtils.uploadFileToServer(partnerDetails.getVendorLogo(), "yogesh");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "admin/register-partner-success";
	}

	@RequestMapping(value = { "/register-branch" }, method = RequestMethod.GET)
	public String registerBranch(ModelMap model) {
		List<VendorProfile> partnerDetails = partnerservice.getAllPartners();
		model.addAttribute("PartnerDetails", partnerDetails);
		model.addAttribute("allPartners", "Yes");
		
		Account loginUser =   utils.getLoggedInUser();
		partnerservice.getPartner(loginUser.getMy_user_name());
		return "admin/register-branch";
	}
	
	@RequestMapping(value = { "/register-category" }, method = RequestMethod.GET)
	public String registerCategory(ModelMap model) {
		return "admin/admin_register_category";
	}
	
	@RequestMapping(value = { "/register-category/{categoryId}" }, method = RequestMethod.GET)
	public String editCategory(@PathVariable int categoryId, ModelMap model) {
		model.addAttribute("thisCategory", utils.getCategory(categoryId));
		return "admin/admin_register_category";
	}
	
	@RequestMapping(value = { "/register-category" }, method = RequestMethod.POST)
	public String saveCategory(@Valid ProductCategory productCategory, BindingResult result,ModelMap model) {
		utils.saveCategory(productCategory);
		return "admin/admin_register_category";
	}
	
	@RequestMapping(value = { "/bulk-register-category" }, method = RequestMethod.POST)
	public String bulkSaveCategory(ModelMap model, @RequestParam("excelfile") MultipartFile excelfile) {
		try {
			String fileName = excelfile.getOriginalFilename();
			List<ExcelFile> thisFile = 	AppFileHandlingUtils.readExcelFile(excelfile, fileName);
			List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
			for (ExcelFile e : thisFile) {
				ProductCategory pc = new ProductCategory();
				pc.setName(e.getCol1()); 
				pc.setDescription(e.getCol2());
				productCategories.add(pc);
			}
			utils.bulkCategoryInsert(productCategories);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/admin_register_category";
	}
	

	@RequestMapping(value = { "/product-category-list" }, method = RequestMethod.GET)
	public String productCategoryList(ModelMap model) {
		model.addAttribute("categoryList", utils.getAllCategory());
		return "admin/admin_category_list";
	}

	@RequestMapping(value = { "/vendor-list" }, method = RequestMethod.GET)
	public String partnerList(ModelMap model) {
		model.addAttribute("vendorList", partnerservice.getAllPartners());
		return "admin/vendor-list";
	}

	@RequestMapping(value = { "/branch-list" }, method = RequestMethod.GET)
	public String branchList(ModelMap model) {
		List<VendorProfile> partnerDetails = partnerservice.getAllPartners();
		model.addAttribute("PartnerDetails", partnerDetails);
		model.addAttribute("allPartners", "Yes");
		return "admin/branch-list";
	}

	@RequestMapping(value = { "/city-list" }, method = RequestMethod.GET)
	public String cityList(ModelMap model) {
		return "admin/city-list";
	}

	@RequestMapping(value = { "/location-list" }, method = RequestMethod.GET)
	public String locationList(ModelMap model) {
		return "admin/location-list";
	}

	@RequestMapping(value = { "/vendor-enquiry" }, method = RequestMethod.GET)
	public String enquiryList(ModelMap model) {
		model.addAttribute("vendorEnquirys", partnerservice.getBusinessEnquiryList());
		return "admin/vendor-enquiry";
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
	
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.GET)
	public String adminChangePassword(ModelMap model) {
		return "admin/admin_change_password";
	}
	
	
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.GET)
	public String adminEditProfile(ModelMap model) {
		return "admin/admin-edit-profile";
	}
	
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.POST)
	public String adminChangePassword(@Valid ChangePassworddBean forgetPasswordBean,BindingResult result,ModelMap model) {
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
	}
