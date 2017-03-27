package com.rjn.controller.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rjn.bean.SearchBean;
import com.rjn.service.SearchService;
import com.rjn.service.VendorService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.utils.Constant;

@Controller 
public class SearchController { 

	private static final Logger logr = Logger.getLogger(SearchController.class);

	@Autowired  
	private SearchService searchService;
	
	@Autowired
	private VendorService vendorService; 
	
	@Autowired 
	private ApplicationUtils applicationUtils;

	@RequestMapping(value = { "/search"}, method = RequestMethod.GET)
	public String search(ModelMap model, HttpServletRequest request) {
		Object object =  request.getSession().getAttribute("authorities");
		List loginUser  = (List)object;
		if (loginUser != null) {
			model.put("headerType", loginUser.get(0));
		}

		String productKeyword = (String) request.getParameter("thisProduct");
		int cityId = Integer.valueOf(request.getParameter("cityId"));

		model.put("productKeyword", productKeyword);
		model.put("cityId", cityId);
		model.put("cityList", applicationUtils.getCitiesByState(Constant.STATE_CHHATTISGARH));

		SearchBean sb = new SearchBean();
		sb.setSearchProductKeyword(productKeyword);
		sb.setCityId(cityId);
		model.put("results", searchService.findVendors(sb));
		model.put("pageName", "searchPage");
		return "/search/search_branch"; 
	}
}
