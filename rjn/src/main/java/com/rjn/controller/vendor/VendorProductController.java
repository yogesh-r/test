package com.rjn.controller.vendor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rjn.model.Account;
import com.rjn.model.SeqId;
import com.rjn.model.VendorProfile;
import com.rjn.model.Branch.BranchMasterDetails;
import com.rjn.model.product.VendorProduct;
import com.rjn.service.BranchService;
import com.rjn.service.VendorProductService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.service.Core.SequenceGeneratorService;
import com.rjn.utils.SeqConstant;

@Controller
@RequestMapping("/vendor/product")
public class VendorProductController {

	@Autowired
	ApplicationUtils utils;
	
	@Autowired
	VendorService partnerService;
	
	@Autowired
	VendorProductService productService;
	
	@Autowired
	private SequenceGeneratorService seqGenerator;
	
	@Autowired
	private BranchService branchService;
	
	@RequestMapping(value = { "/register-product" }, method = RequestMethod.GET)
	public String registerProduct(ModelMap model) {
		model.addAttribute("categoryList", utils.getAllCategory());
		VendorProfile loginPartner = getLoginPartnerDetails();
		
		model.addAttribute("branchList", branchService.getBranchByPartner(loginPartner.getId()));
		
		return "partner/partner_register-product"; 
	}
	
	@RequestMapping(value = { "/register-product" }, method = RequestMethod.POST)
	public String saveProduct(@Valid VendorProduct vendorProduct, BindingResult result, ModelMap model) {
		VendorProfile loginPartner = getLoginPartnerDetails();
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    String currentDate = sdf.format(cal.getTime());
	    
		SeqId seqId = seqGenerator.getSeqId(SeqConstant.PRODUCT_UNIQUE_SEQ);
		String profileNumber = seqId.getSeqName() + "-" + currentDate + "-"+ seqId.getSeqNum();
		
		vendorProduct.setUniqueId(profileNumber);
		vendorProduct.setPartId(loginPartner.getId());
 		productService.saveProduct(vendorProduct); 
		return "partner/partner_register-product";
	}
	
	@RequestMapping(value = { "/register-product/{uniqueId}" }, method = RequestMethod.GET)
	public String editProduct(ModelMap model, @PathVariable String uniqueId) {
		VendorProfile loginPartner = getLoginPartnerDetails();
		VendorProduct vendorProduct = productService.getProductByUniqueID(uniqueId);
		if (vendorProduct.getPartId().equals(loginPartner.getId())) {
			model.addAttribute("thisVendor", vendorProduct);
		} else {
			model.addAttribute("errorMessage", "sorry this product doesnt exist please crate your own product");
		}
		model.addAttribute("categoryList", utils.getAllCategory());
		model.addAttribute("branchList", branchService.getBranchByPartner(loginPartner.getId()));
		return "partner/partner_register-product"; 
	}
	
	@RequestMapping(value = { "/product-list" }, method = RequestMethod.GET)
	public String productList(ModelMap model) {
		VendorProfile loginPartner = getLoginPartnerDetails();
		model.addAttribute("productList", productService.getProductByVendor(loginPartner.getId()));
		return "partner/partner_product_list"; 
	}
	
	@RequestMapping(value = { "/leads" }, method = RequestMethod.GET)
	public String leads(ModelMap model) {
		VendorProfile loginPartner = getLoginPartnerDetails();
		model.addAttribute("productList", productService.getProductByVendor(loginPartner.getId()));
		model.addAttribute("leads", utils.getLeadForVendor(loginPartner.getId()));
		
		List<BranchMasterDetails> branchList =  branchService.getBranchByPartner(loginPartner.getId());
		model.addAttribute("branchList", branchList);
		 
		return "partner/partner_leads"; 
	}
	
	private VendorProfile getLoginPartnerDetails() {
		Account loginUser = utils.getLoggedInUser();
		VendorProfile loginPartner = partnerService.getPartner(loginUser.getReg_id());
		return loginPartner;
	}
}
