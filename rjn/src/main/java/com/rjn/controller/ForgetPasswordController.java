package com.rjn.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rjn.model.ProfileMaster;
import com.rjn.model.core.Email;
import com.rjn.service.HeaderService;
import com.rjn.service.Core.MailService;

@Controller
public class ForgetPasswordController {
	
	@Autowired
	HeaderService headerService;
	
	@Autowired 
	MailService mailService;
	
	@RequestMapping(value = { "/forgetPassword" }, method = RequestMethod.POST)
	public String forgetPassword(ModelMap model, @RequestParam("email") String contactEmailId, HttpServletRequest request) {
		ProfileMaster profileMaster = headerService.getProfileMasterByEmail(contactEmailId);
		if (profileMaster == null) {
			throw new UsernameNotFoundException(contactEmailId);
		} else {
			// generating token
			String token = UUID.randomUUID().toString();
			// saving token in database
			headerService.saveToken(profileMaster, token);
			// generating forgotpassword link
			String forgotPasswordLink = request.getContextPath() + "/user/changePassword?id=" + 
					profileMaster.getProfileNumber() + "&token=" + token;
			// sending email
			Email thisEmail = new Email();
			thisEmail.setTo(contactEmailId);
	    	thisEmail.setSubject("Test subject");
	    	thisEmail.setBody("Forgot password link = "+forgotPasswordLink);
	    	boolean isEmailSent = mailService.sendEmail(thisEmail);
	    	System.out.println("isEmailSent >>> "+isEmailSent);
		}
		return null;
	}
	
	@RequestMapping(value = { "/forgetPassword/link" }, method = RequestMethod.GET)
	public String forgetPasswordLink(@RequestParam("id") long id, @RequestParam("token") String token) {
		System.out.println("===============================");
		System.out.println(token);
		System.out.println(id);
		return null;
	}

}
