package com.rjn.controller.home;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.rjn.service.VendorProductService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.utils.Constant;

@Controller
public class HomeController {
	
	private static final Logger logr = Logger.getLogger(HomeController.class);
	
	@Autowired 
	private VendorProductService vendorProductService;
	
	@Autowired 
	private ApplicationUtils applicationUtils;
	 
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.put("keyWords", vendorProductService.getKeyWord());
		model.put("cityList", applicationUtils.getCitiesByState(Constant.STATE_CHHATTISGARH));
		return "index"; 
	}
	
	@RequestMapping(value = { "/list-your-shop"}, method = RequestMethod.GET)
	public String listYourSpace	(ModelMap model) {
		return "list-your-shop";
	}
}