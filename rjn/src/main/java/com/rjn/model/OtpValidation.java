package com.rjn.model;
/*
 * Baliram
 * 20-07-2016
 */

public class OtpValidation {
	
   private int id;
	
	private String mobileNo;
	
	private String otpId;
	
	private String validFrom;
	
	private String validTo;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOtpId() {
		return otpId;
	}

	public void setOtpId(String otpId) {
		this.otpId = otpId;
	}

	public String getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	public String getValidTo() {
		return validTo;
	}

	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
