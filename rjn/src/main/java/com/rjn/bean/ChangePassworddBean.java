package com.rjn.bean;

public class ChangePassworddBean {
	private String oldPassword;
	private String newPassword;
	private String conformPassword; 
	private String token;
	private String profileNumber;
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConformPassword() {
		return conformPassword;
	}
	public void setConformPassword(String conformPassword) {
		this.conformPassword = conformPassword;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getProfileNumber() {
		return profileNumber;
	}
	public void setProfileNumber(String profileNumber) {
		this.profileNumber = profileNumber;
	}
}