package com.rjn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="business_enquiry")
public class BusinessEnquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "enquiry_id")
	private String enquiryId;
	
	@Column(name = "Venue_Manager_Name")
	private String venueManagerName;
	
	@Column(name = "Property_Name")
	private String propertyName;
	
	@Column(name = "Mobile_No")
	private String mobileNo;
	
	@Column(name = "Alt_Mobile_No")
	private String altMobileNo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Addtional_Notes")
	private String addtionalNotes;
	
	@Column(name = "email_status")
	private String emailStatus = "Not Sent";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVenueManagerName() {
		return venueManagerName;
	}
	public void setVenueManagerName(String venueManagerName) {
		this.venueManagerName = venueManagerName;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAltMobileNo() {
		return altMobileNo;
	}
	public void setAltMobileNo(String altMobileNo) {
		this.altMobileNo = altMobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddtionalNotes() {
		return addtionalNotes;
	}
	public void setAddtionalNotes(String addtionalNotes) {
		this.addtionalNotes = addtionalNotes;
	}
	public String getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(String enquiryId) {
		this.enquiryId = enquiryId;
	}
	public String getEmailStatus() {
		return emailStatus;
	}
	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}
}