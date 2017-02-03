package com.rjn.service.Core;

import com.rjn.model.core.Email;

public interface MailService { 
	public boolean sendEmail(Email email);
}
