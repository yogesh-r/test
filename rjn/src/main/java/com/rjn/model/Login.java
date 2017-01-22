package com.rjn.model;

import org.joda.time.LocalDate;

/*
 *  Baliram 
 *  20-07-2016
 */
public class Login {
	
	private String UserId;
	
	private String userPassword;
	
	private String userProfile;
	
	private String userName;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private int expiryDays;
	
	private String apptype;
	
	private LocalDate lastModified;
	
	private String General1;
	
	private String General2;
	
	private String General3;
	
	private String General4;
	
	private String General5;
	
	private String userType;
	
	private String dealerCode;
	
	private String regId;

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getExpiryDays() {
		return expiryDays;
	}

	public void setExpiryDays(int expiryDays) {
		this.expiryDays = expiryDays;
	}

	public String getApptype() {
		return apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public LocalDate getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDate lastModified) {
		this.lastModified = lastModified;
	}

	public String getGeneral1() {
		return General1;
	}

	public void setGeneral1(String general1) {
		General1 = general1;
	}

	public String getGeneral2() {
		return General2;
	}

	public void setGeneral2(String general2) {
		General2 = general2;
	}

	public String getGeneral3() {
		return General3;
	}

	public void setGeneral3(String general3) {
		General3 = general3;
	}

	public String getGeneral4() {
		return General4;
	}

	public void setGeneral4(String general4) {
		General4 = general4;
	}

	public String getGeneral5() {
		return General5;
	}

	public void setGeneral5(String general5) {
		General5 = general5;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}
	
}
