package com.rjn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="customer_profile") 
public class CustomerProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profile_id", nullable = false)
	private int id;
	
	@Column(name = "profile_number", nullable = false)
	private String profileNumber;
	
	@Column(name = "branch_id", nullable = false)
	private String branchId;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private  String lastName;
	
	@Column(name = "dob", nullable = false)
	private String dob;
	
	@Column(name = "contact_mobile_no", nullable = false)
	private String contactMobileNo;
	
	@Column(name = "contact_email_id", nullable = false)
	private String contactEmailId;
	
	@Column(name = "contact_alt_phone", nullable = false)
	private String contactAltPhone;
	
	@Column(name = "contact_alt_email", nullable = false)
	private String contactAltEmail;
	
	@Column(name = "vendor_id", nullable = false)
	private String vendorId;
	
	@Column(name = "Country", nullable = false)
	private String Country;
	
	@Column(name = "State", nullable = false)
	private String State;
	
	@Column(name = "City", nullable = false)
	private String city;
	
	@Column(name = "Address", nullable = false)
	private String Address;
	
	@Column(name = "Street", nullable = false)
	private String Street;
	
	@Column(name = "Zipcode", nullable = false)
	private String zipCode;
	
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@Column(name = "Id_Type", nullable = false)
	private String idType;
	
	@Column(name = "Id_number", nullable = false)
	private String idNumber;
	
	@Column(name = "Id_name", nullable = false)
	private String idName;
	
	@Column(name = "Alt_Id_Type", nullable = false)
	private String altIdType;
	
	@Column(name = "created_date", nullable = false)
	private String createdDate;
	
	@Column(name = "created_by", nullable = false)
	private String createdBy;
	
	@Column(name = "last_updated_date", nullable = false)
	private String lastUpdatedDate;
	
	@Column(name = "last_updated_by", nullable = false)
	private String lastUpdatedBy;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Transient
	private String password;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfileNumber() {
		return profileNumber;
	}

	public void setProfileNumber(String profileNumber) {
		this.profileNumber = profileNumber;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getContactMobileNo() {
		return contactMobileNo;
	}

	public void setContactMobileNo(String contactMobileNo) {
		this.contactMobileNo = contactMobileNo;
	}

	public String getContactEmailId() {
		return contactEmailId;
	}

	public void setContactEmailId(String contactEmailId) {
		this.contactEmailId = contactEmailId;
	}

	public String getContactAltPhone() {
		return contactAltPhone;
	}

	public void setContactAltPhone(String contactAltPhone) {
		this.contactAltPhone = contactAltPhone;
	}

	public String getContactAltEmail() {
		return contactAltEmail;
	}

	public void setContactAltEmail(String contactAltEmail) {
		this.contactAltEmail = contactAltEmail;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public String getAltIdType() {
		return altIdType;
	}

	public void setAltIdType(String altIdType) {
		this.altIdType = altIdType;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
