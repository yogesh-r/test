package com.rjn.controller.vendor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.rjn.model.Account;
import com.rjn.model.SeqId;
import com.rjn.model.VendorProfile;
import com.rjn.model.core.VendorLead;
import com.rjn.model.product.VendorProduct;
import com.rjn.service.BranchService;
import com.rjn.service.VendorProductService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.service.Core.SequenceGeneratorService;
import com.rjn.utils.Constant;
import com.rjn.utils.SeqConstant;

@Controller
@RequestMapping("/vendor/product")
public class VendorProductController {

	@Autowired
	private ApplicationUtils applicationUtils;
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private VendorProductService productService;
	
	@Autowired
	private SequenceGeneratorService seqGenerator;
	
	@Autowired
	private BranchService branchService;
	
	@RequestMapping(value = { "/register-product" }, method = RequestMethod.GET)
	public String registerProduct(ModelMap model) {
		model.addAttribute("categoryList", applicationUtils.getAllCategory());
		VendorProfile loginVendor = getLoginVendorDetails();
		model.addAttribute("branchList", branchService.getBranchByVendor(loginVendor.getId()));
		return "vendor/vendor_register-product"; 
	}
	
	
	@RequestMapping(value = { "/delete/{uniqueId}" }, method = RequestMethod.GET)
	public @ResponseBody Object deleteProduct(@PathVariable String uniqueId) {
		Map<String, Object> model = new HashMap<String, Object>();
		VendorProfile loginVendor = getLoginVendorDetails();
		VendorProduct vendorProduct = productService.getProductByUniqueID(uniqueId);
		if (vendorProduct.getVendorId().equals(loginVendor.getId())) {
			productService.deleteProduct(vendorProduct);
			model.put("message", "Product deleted successfully");
		} else {
			model.put("message", "sorry this product doesnt exist please create your own product");
		}
		return model; 
	}
	
	
	
	@RequestMapping(value = { "/register-product" }, method = RequestMethod.POST)
	public @ResponseBody Object saveProduct(@RequestBody VendorProduct vendorProduct) {
		Map<String, Object> model = new HashMap<String, Object>();
		VendorProfile loginVendor = getLoginVendorDetails();
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    String currentDate = sdf.format(cal.getTime());
		SeqId seqId = seqGenerator.getSeqId(SeqConstant.PRODUCT_UNIQUE_SEQ);
		String profileNumber = seqId.getSeqName() + "-" + currentDate + "-"+ seqId.getSeqNum();
		vendorProduct.setUniqueId(profileNumber);
		vendorProduct.setVendorId(loginVendor.getId());
 		productService.saveProduct(vendorProduct); 
 		model.put("success", "success");
		return model;
	}
	
	@RequestMapping(value = { "/register-product/{uniqueId}" }, method = RequestMethod.GET)
	public @ResponseBody Object editProduct(@PathVariable String uniqueId) {
		Map<String, Object> model = new HashMap<String, Object>();
		VendorProfile loginVendor = getLoginVendorDetails();
		VendorProduct vendorProduct = productService.getProductByUniqueID(uniqueId);
		if (vendorProduct.getVendorId().equals(loginVendor.getId())) {
			model.put("thisVendor", vendorProduct);
		} else {
			model.put("errorMessage", "sorry this product doesnt exist please crate your own product");
		}
		return model; 
	}
	
	@RequestMapping(value = { "/product-list" }, method = RequestMethod.GET)
	public String productList(ModelMap model) {
		VendorProfile loginVendor = getLoginVendorDetails();
		model.addAttribute("categoryList", applicationUtils.getAllCategory());
		model.addAttribute("branchList", branchService.getBranchByVendor(loginVendor.getId()));
		return "vendor/vendor_product_list"; 
	} 
	
	@RequestMapping(value = { "/leads" }, method = RequestMethod.GET)
	public String leads(ModelMap model) {
		return "vendor/vendor_leads"; 
	}
	
	@RequestMapping(value = { "/rest/leads" }, method = RequestMethod.GET)
	public @ResponseBody Object leadsDataForVendor(HttpServletRequest request) {
		String status = request.getParameter("status");
		VendorProfile loginVendor = getLoginVendorDetails();
		Map<String, Object> model = new HashMap<String, Object>();
		if (Constant.VENDOR_LEAD_STATUS_READ.equals(status)) {
			model.put("leads", applicationUtils.getLeadForVendor(loginVendor.getId(), Constant.VENDOR_LEAD_STATUS_READ));
		} else if(Constant.VENDOR_LEAD_STATUS_UNREAD.equals(status)) {
			model.put("leads", applicationUtils.getLeadForVendor(loginVendor.getId(), Constant.VENDOR_LEAD_STATUS_UNREAD));
		} 
		else if(Constant.VENDOR_LEAD_STATUS_All.equals(status)) {
			model.put("leads", applicationUtils.allLead(loginVendor.getId()));
		} else {
			model.put("leads", "No data found");
		}
		return model;
	}
	
	@RequestMapping(value = { "/rest/update-lead-status/{leadId}" }, method = RequestMethod.GET)
	public @ResponseBody Object updateLeadStatus(HttpServletRequest request, @PathVariable long leadId) {
		String leadStatus =	request.getParameter("status");
		VendorLead thisLead = applicationUtils.getLeadById(leadId);
		if (Constant.VENDOR_LEAD_STATUS_READ.equals(leadStatus)) {
			thisLead.setVendorStatus(Constant.VENDOR_LEAD_STATUS_READ);
		} else if (Constant.VENDOR_LEAD_STATUS_UNREAD.equals(leadStatus)) {
			thisLead.setVendorStatus(Constant.VENDOR_LEAD_STATUS_UNREAD);
		}
		applicationUtils.updateLead(thisLead);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("isStatusUpdated", "yes");
		return model;
	}
	
	private VendorProfile getLoginVendorDetails() {
		Account loginUser = applicationUtils.getLoggedInUser();
		VendorProfile loginVendor = vendorService.getVendor(loginUser.getReg_id());
		return loginVendor;
	}
}
