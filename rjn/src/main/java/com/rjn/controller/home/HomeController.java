package com.rjn.controller.home;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rjn.service.VendorProductService;

@Controller 
public class HomeController {
	
	private static final Logger logr = Logger.getLogger(HomeController.class);
	
	@Autowired 
	VendorProductService vendorProductService;
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<String> keywords = vendorProductService.getKeyWord();
		return "index"; 
	}
	
	@RequestMapping(value = { "/list-your-shop"}, method = RequestMethod.GET)
	public String listYourSpace	(ModelMap model) {
		return "list-your-shop";
	}
}