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
import com.rjn.model.CustomerProfile;
import com.rjn.model.core.Email;
import com.rjn.service.HeaderService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.service.Core.MailService;

@Controller
public class ForgetPasswordController {
	
	@Autowired
	private HeaderService headerService;
	
	@Autowired 
	private MailService mailService;
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private ApplicationUtils applicationUtils;
	
	@RequestMapping(value = { "/forgetPassword" }, method = RequestMethod.POST)
	public String forgetPassword(ModelMap model, @RequestParam("email") String contactEmailId, HttpServletRequest request) {
		CustomerProfile profileMaster = headerService.getProfileMasterByEmail(contactEmailId);
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
	    	System.out.println("isEmailSent: "+isEmailSent);
		}
		return null;
	}
	
	@RequestMapping(value = { "/forgetPassword" }, method = RequestMethod.GET)
	public String forgetPasswordLink(@RequestParam("id") String profileNumber, @RequestParam("token") String token, HttpServletRequest request,  ModelMap model) {
		PasswordResetToken passwordResetToken = headerService.getPasswordResetToken(profileNumber, token);
		// check time also
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
		PasswordResetToken passwordResetToken = headerService.getPasswordResetToken(ChangePassworddBean.getProfileNumber(), ChangePassworddBean.getToken());
		if (passwordResetToken != null && ChangePassworddBean.getNewPassword().equals(ChangePassworddBean.getConformPassword())) {
			//load account
			Account thisAccount =  accountDao.findByRegId(ChangePassworddBean.getProfileNumber());
			thisAccount.setPassword(applicationUtils.encryptPassword(ChangePassworddBean.getNewPassword()));
			accountDao.updateAccount(thisAccount);
		}
		return null;
	}
}
