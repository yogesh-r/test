package com.rjn.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rjn.bean.RegistrationBean;
import com.rjn.model.CustomerProfile;

@Component("registrationFormValidator")
public class RegistrationValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		return RegistrationValidator.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegistrationBean registrationBean = (RegistrationBean) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"error.firstName", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
				"error.lastName", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactMobileNo",
				"error.contactMobileNo", "Mobile No is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactEmailId",
				"error.contactEmailId", "Email id is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"error.password", "Password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpwd",
				"error.cpwd", "Confirm Password is required.");
		
		if ((registrationBean.getContactEmailId().length()>0)
				&& !registrationBean.getContactEmailId().matches(
								"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
										+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			errors.rejectValue("emailAddress", "error.emailId.invalid",
					"Invalid Email Address.");
		}
		
		if (registrationBean.getPassword().length()>0) {
			if (!registrationBean.getPassword().equals(registrationBean.getCpwd())) {
				errors.rejectValue("password", "error.passwordMismatch",
						"Password & Confirm password does not match.");
			}
			if (registrationBean.getPassword().length() < 6) {
				errors.rejectValue("password", "error.passwordLength",
						"Password should have minimum of 6 character.");
			}
		}
		
	}

}
