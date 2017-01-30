package com.rjn.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rjn.bean.ChangePassworddBean;
import com.rjn.dao.core.AccountDao;
import com.rjn.model.Account;
import com.rjn.model.PasswordResetToken;
import com.rjn.model.ProfileMaster;
import com.rjn.model.core.Email;
import com.rjn.service.HeaderService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.service.Core.MailService;

@Controller
public class ForgetPasswordController {
	
	@Autowired
	HeaderService headerService;
	
	@Autowired 
	MailService mailService;
	
	@Autowired
	AccountDao accountDao;
	
	
	@Autowired
	private ApplicationUtils utils;
	
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
	
	@RequestMapping(value = { "/forgetPassword" }, method = RequestMethod.GET)
	public String forgetPasswordLink(@RequestParam("id") String profileNumber, @RequestParam("token") String token, HttpServletRequest request,  ModelMap model) {
		System.out.println("===============================");
		System.out.println(token);
		System.out.println(profileNumber);
		PasswordResetToken passwordResetToken = headerService.getPasswordResetToken(profileNumber, token);
		// check time also
		System.out.println("passwordResetToken >> "+passwordResetToken);
		
		// crosscheck with user also
		if (passwordResetToken != null) {
			model.addAttribute("token", token);
			model.addAttribute("profileNumber", profileNumber);
			return "forget-password";
		}
		return null;
	}
	
	@RequestMapping(value = { "/header/change-password" }, method = RequestMethod.POST)
	public String heaerChangePassword(@Valid ChangePassworddBean ChangePassworddBean, BindingResult result, ModelMap model) {
		
		System.out.println("profile number >> "+ChangePassworddBean.getProfileNumber());
		System.out.println("token >> "+ChangePassworddBean.getToken());
		
		PasswordResetToken passwordResetToken = headerService.getPasswordResetToken(ChangePassworddBean.getProfileNumber(), ChangePassworddBean.getToken());
		
		if (passwordResetToken != null && ChangePassworddBean.getNewPassword().equals(ChangePassworddBean.getConformPassword())) {
			//load account
			Account thisAccount =  accountDao.findByRegId(ChangePassworddBean.getProfileNumber());
			thisAccount.setPassword(utils.encryptPassword(ChangePassworddBean.getNewPassword()));
			accountDao.updateAccount(thisAccount);
		}
		
		return null;
	}

}
