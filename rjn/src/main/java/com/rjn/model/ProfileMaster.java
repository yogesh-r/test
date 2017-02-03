package com.rjn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tx_profile_master") 
public class ProfileMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profile_id", nullable = false)
	private int id;
	
	@Column(name = "profile_number", nullable = false)
	private String profileNumber;
	
	@Column(name = "profile_type", nullable = false)
	private String profileType;
	
	@Column(name = "branch_id", nullable = false)
	private String branchId;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private  String lastName;
	
	@Column(name = "cust_company_name", nullable = false)
	private String custCompanyName;
	
	@Column(name = "cust_company_name_other", nullable = false)
	private String custCompanyNameOther;
	
	@Column(name = "dob", nullable = false)
	private String dob;
	
	@Column(name = "know_us_source", nullable = false)
	private String knowUsSource;
	
	@Column(name = "know_us_source_Other", nullable = false)
	private  String knowUsSourceOther;
	
	@Column(name = "company_profile_id", nullable = true)
	private Integer companyProfileId;
	
	@Column(name = "company_name", nullable = false)
	private String companyName;
	
	@Column(name = "company_contact_name", nullable = false)
	private String companyContactName;
	
	@Column(name = "contact_mobile_no", nullable = false)
	private String contactMobileNo;
	
	@Column(name = "contact_email_id", nullable = false)
	private String contactEmailId;
	
	@Column(name = "contact_alt_phone", nullable = false)
	private String contactAltPhone;
	
	@Column(name = "contact_alt_email", nullable = false)
	private String contactAltEmail;
	
	@Column(name = "relationship", nullable = false)
	private String relationship;
	
	@Column(name = "partner_id", nullable = false)
	private String partnerId;
	
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
	
	@Column(name = "price_list", nullable = false)
	private String priceList;
	
	@Column(name = "discount_type", nullable = false)
	private String discountType;
	
	@Column(name = "flat_discount_percent", nullable = false)
	private String flatDiscountPercent;
	
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@Column(name = "profile_category", nullable = true)
	private String profileCategory;
	
	@Column(name = "Id_Type", nullable = false)
	private String idType;
	
	@Column(name = "Id_number", nullable = false)
	private String idNumber;
	
	@Column(name = "Id_name", nullable = false)
	private String idName;
	
	@Column(name = "Alt_Id_Type", nullable = false)
	private String altIdType;
	
	@Column(name = "C_Id_Name", nullable = false)
	private String cIdName;
	
	@Column(name = "C_ID_Number", nullable = false)
	private String cIdNumber;
	
	@Column(name = "membership")
	private String membership = "YES";
	
	@Column(name = "email_msg_id", nullable = false)
	private String emailMsgId;
	
	@Column(name = "sms_msg_id", nullable = false)
	private String smsMsgId;
	
	@Column(name = "Booking_Enq_no", nullable = false)
	private String bookingEnqNo;
	
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
	
	@Column(name = "status", nullable = false)
	private String status;
	
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

	public String getProfileType() {
		return profileType;
	}

	public void setProfileType(String profileType) {
		this.profileType = profileType;
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

	public String getCustCompanyName() {
		return custCompanyName;
	}

	public void setCustCompanyName(String custCompanyName) {
		this.custCompanyName = custCompanyName;
	}

	public String getCustCompanyNameOther() {
		return custCompanyNameOther;
	}

	public void setCustCompanyNameOther(String custCompanyNameOther) {
		this.custCompanyNameOther = custCompanyNameOther;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getKnowUsSource() {
		return knowUsSource;
	}

	public void setKnowUsSource(String knowUsSource) {
		this.knowUsSource = knowUsSource;
	}

	public String getKnowUsSourceOther() {
		return knowUsSourceOther;
	}

	public void setKnowUsSourceOther(String knowUsSourceOther) {
		this.knowUsSourceOther = knowUsSourceOther;
	}

	public int getCompanyProfileId() {
		return companyProfileId;
	}

	public void setCompanyProfileId(Integer companyProfileId) {
		this.companyProfileId = companyProfileId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyContactName() {
		return companyContactName;
	}

	public void setCompanyContactName(String companyContactName) {
		this.companyContactName = companyContactName;
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

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
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

	public String getPriceList() {
		return priceList;
	}

	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getFlatDiscountPercent() {
		return flatDiscountPercent;
	}

	public void setFlatDiscountPercent(String flatDiscountPercent) {
		this.flatDiscountPercent = flatDiscountPercent;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfileCategory() {
		return profileCategory;
	}

	public void setProfileCategory(String profileCategory) {
		this.profileCategory = profileCategory;
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

	public String getcIdName() {
		return cIdName;
	}

	public void setcIdName(String cIdName) {
		this.cIdName = cIdName;
	}

	public String getcIdNumber() {
		return cIdNumber;
	}

	public void setcIdNumber(String cIdNumber) {
		this.cIdNumber = cIdNumber;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public String getEmailMsgId() {
		return emailMsgId;
	}

	public void setEmailMsgId(String emailMsgId) {
		this.emailMsgId = emailMsgId;
	}

	public String getSmsMsgId() {
		return smsMsgId;
	}

	public void setSmsMsgId(String smsMsgId) {
		this.smsMsgId = smsMsgId;
	}

	public String getBookingEnqNo() {
		return bookingEnqNo;
	}

	public void setBookingEnqNo(String bookingEnqNo) {
		this.bookingEnqNo = bookingEnqNo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
