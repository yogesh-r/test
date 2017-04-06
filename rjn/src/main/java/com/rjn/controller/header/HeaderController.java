package com.rjn.controller.header;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.rjn.model.BusinessEnquiry;
import com.rjn.model.CustomerProfile;
import com.rjn.model.SeqId;
import com.rjn.model.core.Email;
import com.rjn.service.HeaderService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.service.Core.MailService;
import com.rjn.service.Core.SequenceGeneratorService;
import com.rjn.utils.SeqConstant;

@Controller
@RequestMapping("/")
public class HeaderController {
	
	private static final Logger logr = Logger.getLogger(HeaderController.class);

	@Autowired
	private VendorService vendorService; 

	@Autowired
	private HeaderService headerService;
	
	@Autowired
	private ApplicationUtils applicationUtils;
	
	@Autowired
	private SequenceGeneratorService seqGenerator;
	
	@Autowired 
	private MailService mailService;
	
	@RequestMapping(value = { "/contact-us"}, method = RequestMethod.GET)
	public String contact(ModelMap model) {
		return "contact-us";
	}
	
	@RequestMapping(value = { "/login"}, method = RequestMethod.GET)
	public String sighIn(ModelMap model) {
		return "login"; 
	}
	
	@RequestMapping(value = { "/member/register"}, method = RequestMethod.GET)
	public String memberRegister(ModelMap model) {
		return "member-register"; 
	}

	@RequestMapping(value = { "/member/register"}, method = RequestMethod.POST)
	public String saveMemberRegisteration(@Valid CustomerProfile profileMaster, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
		String unEncryptPass = profileMaster.getPassword();
		profileMaster.setPassword(applicationUtils.encryptPassword(unEncryptPass));
		SeqId seqId = seqGenerator.getSeqId(SeqConstant.CUSTOMER_SEQ);
		String profileNumber = seqId.getSeqName() +"-"+ seqId.getSeqNum();
		profileMaster.setProfileNumber(profileNumber);
		model.addAttribute("profileNumber", profileNumber);
		model.addAttribute("contactEmail" ,profileMaster.getContactEmailId());
		headerService.saveMemberRegistration(profileMaster);
		return "member-register-success";
	}

	@RequestMapping(value = { "/error"}, method = RequestMethod.GET)
	public String error(ModelMap model) {
		return "error";
	}
	
	@RequestMapping(value = { "/logout"}, method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
	
	@RequestMapping(value = { "/accessdenied"}, method = RequestMethod.GET)
	public String accessDenied(ModelMap model) {
		return "accessdenied";
	}
	
	@RequestMapping(value = "/success-login", method = RequestMethod.GET)
	public ModelAndView successLogin() {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("login-success.jsp", model);
	}

/*	@RequestMapping(value = { "/public/save-contact-us" }, method = RequestMethod.POST)
	public String saveContactUs(@Valid GeneralContactUs contactUs, BindingResult result, ModelMap model) {
		headerService.saveContactUs(contactUs);
		return "redirect:/"; 
	}*/
	
	@RequestMapping(value = { "/public/list_your_space" }, method = RequestMethod.POST)
	public String saveListData(@Valid BusinessEnquiry listSpace, BindingResult result, ModelMap model) {
		SeqId seqId = seqGenerator.getSeqId(SeqConstant.VENDOR_REGISTRATION_ENQUIRY_SEQ);
		String enquiryId = seqId.getSeqName() +"-"+ seqId.getSeqNum();
		listSpace.setEnquiryId(enquiryId);
		headerService.saveListYourOffice(listSpace);

		// sending mail
		Email thisEmail = new Email();
		thisEmail.setTo(listSpace.getEmail());
    	thisEmail.setSubject("Test subject");
    	thisEmail.setBody("Test Body enquiry id = "+enquiryId);
    	boolean isEmailSent = mailService.sendEmail(thisEmail);
    	if (isEmailSent) {
        	BusinessEnquiry thisListSpace = headerService.getBusinessEnquiryByEnquiryId(enquiryId);
        	thisListSpace.setEmailStatus("Sent");
        	headerService.saveListYourOffice(thisListSpace);
    	}
    	
		model.addAttribute("enquiryId", enquiryId);  
		return "list_your_space_success"; 
	}
}
