package com.rjn.controller.footer;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class FooterController { 
 
	private static final Logger logr = Logger.getLogger(FooterController.class);
 
	@RequestMapping(value = { "/carrers"}, method = RequestMethod.GET)
	public String carrers(ModelMap model) {
		return "carrers";
	}
	
	@RequestMapping(value = { "/privacy-policy"}, method = RequestMethod.GET)
	public String privacypolicy(ModelMap model) {
		return "privacy-policy";
	}
	
	@RequestMapping(value = { "/member-policy"}, method = RequestMethod.GET)
	public String memberpolicy(ModelMap model) {
		return "member-policy";
	}
	
	@RequestMapping(value = { "/terms-and-conditions"}, method = RequestMethod.GET)
	public String termsandconditions(ModelMap model) {
		return "terms-and-conditions";
	}
	
	@RequestMapping(value = { "/space-provide-policy"}, method = RequestMethod.GET)
	public String space_provide_policy(ModelMap model) {
		return "space-provide-policy"; 
	}
	
	@RequestMapping(value = { "/faq"}, method = RequestMethod.GET)
	public String faq(ModelMap model) {
		return "faq";
	}
	
	@RequestMapping(value = { "/suggestion"}, method = RequestMethod.GET)
	public String suggestion(ModelMap model) {
		return "suggestion";
	}
	
	@RequestMapping(value = { "/about-us"}, method = RequestMethod.GET)
	public String aboutus(ModelMap model) {
		return "about-us";
	}
}
