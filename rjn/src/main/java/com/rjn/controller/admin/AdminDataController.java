package com.rjn.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rjn.service.BranchService;

@Controller
@RequestMapping("/admin/rest")
public class AdminDataController {
	
	@Autowired
	private BranchService branchService;

	@RequestMapping(value = { "/branch-list" }, method = RequestMethod.GET)
	public @ResponseBody ModelMap branchList(ModelMap model) {
		model.addAttribute("allVendors", "Yes");
		return model;
	}

}
