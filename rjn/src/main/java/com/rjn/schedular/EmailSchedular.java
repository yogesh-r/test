package com.rjn.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import com.rjn.service.Core.MailService;

@Controller 
public class EmailSchedular {

	@Autowired 
	MailService mailService; 
	
    @Scheduled(fixedRate=3000)
    public void doTask() {
    	
/*    	Email thisEmail = new Email();
    	thisEmail.setTo("rathoreyogesh@hotmail.com");
    	thisEmail.setSubject("Test subject");
    	thisEmail.setBody("Test Body");
    	
    	mailService.sendEmail(thisEmail);*/
    	
    	//System.out.println("Email test Schedular task ..............................................");
    }
}