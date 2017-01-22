package com.rjn.model;
/*
 * Baliram 
 * 20-07-2016
 */

import org.joda.time.LocalDate;

public class LoginAudit {
	
	private int id;
	
	private String userName;
	
	private LocalDate loginDteTme;
	
	private String appType;
	
	private String machineName;
	
	private String location;
	
	private String ipAddress;
	
	private String Field1;
	
	private String Field2;
	
	private String Field3;
	
	private String Field4;
	
	private String Field5;
	
	private String Field6;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getLoginDteTme() {
		return loginDteTme;
	}

	public void setLoginDteTme(LocalDate loginDteTme) {
		this.loginDteTme = loginDteTme;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getField1() {
		return Field1;
	}

	public void setField1(String field1) {
		Field1 = field1;
	}

	public String getField2() {
		return Field2;
	}

	public void setField2(String field2) {
		Field2 = field2;
	}

	public String getField3() {
		return Field3;
	}

	public void setField3(String field3) {
		Field3 = field3;
	}

	public String getField4() {
		return Field4;
	}

	public void setField4(String field4) {
		Field4 = field4;
	}

	public String getField5() {
		return Field5;
	}

	public void setField5(String field5) {
		Field5 = field5;
	}

	public String getField6() {
		return Field6;
	}

	public void setField6(String field6) {
		Field6 = field6;
	}
}
