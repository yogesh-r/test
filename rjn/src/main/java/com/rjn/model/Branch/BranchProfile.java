package com.rjn.model.Branch;

import java.io.File;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="branch_profile")
public class BranchProfile { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BranchCode", nullable = false)
	private String id;
	
	@Column(name = "bracnh_unique_Id", nullable = false)
	private String uniqueId;
	
	@Column(name = "BranchName", nullable = false)
	private String branchName;
	
	@Column(name = "BranchOwner", nullable = false)
	private String branchOwner;
	
	@Column(name = "Description", nullable = false)
	private String description;
	
	@Column(name = "StartDate", nullable = false)
	private String startDate;
	
	@Column(name = "contactno", nullable = false)
	private String contactNo;
	
	@Column(name = "emailid", nullable = false)
	private String emailId;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "zipcode", nullable = false)
	private String zipcode;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "managername", nullable = false)
	private String managerName;
	
	@Column(name = "manager_email", nullable = false)
	private String managerEmail;
	
	@Column(name = "manager_mobile", nullable = false)
	private String managerMobile;
	
	@Column(name = "land_line", nullable = false)
	private String landLine;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "terms_conditions", nullable = false)
	private String termsConditions;
	
	@Column(name = "latitude", nullable = false)
	private String latitude;
	
	@Column(name = "longitude", nullable = false)
	private String longitude;
	
	@Column(name = "location_id", nullable = false)
	private String locationId;
	
	@Column(name = "Work_Monday", nullable = false)
	private String workMonday;
	
	@Column(name = "Work_Tuesday", nullable = false)
	private String workTuesday;
	
	@Column(name = "Work_Wednesday", nullable = false)
	private String workWednesday;
	
	@Column(name = "Work_Thursday", nullable = false)
	private String workThursday;
	
	@Column(name = "Work_Friday", nullable = false)
	private String workFriday;
	
	@Column(name = "Work_Saturday", nullable = false)
	private String workSaturday;
	
	@Column(name = "Work_Sunday", nullable = false)
	private String workSunday;
	
	@Column(name = "verify", nullable = false)
	private String verify;
	
	@Column(name = "created_date", nullable = false)
	private String createdDate;
	
	@Column(name = "created_by", nullable = false)
	private String createdBy;
	
	@Column(name = "last_updated_date", nullable = false)
	private String lastUpdatedDate;
	
	@Column(name = "last_updated_by", nullable = false)
	private String lastUpdatedBy;
	
	@Transient
	private MultipartFile termsAndCondition;
	
	@Transient
	private File cancellationPolicy;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public String getBranchOwner() {
		return branchOwner;
	}
	
	public void setBranchOwner(String branchOwner) {
		this.branchOwner = branchOwner;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailid) {
		this.emailId = emailid;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getManagerName() {
		return managerName;
	}
	
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public String getManagerMobile() {
		return managerMobile;
	}
	public void setManagerMobile(String managerMobile) {
		this.managerMobile = managerMobile;
	}
	public String getLandLine() {
		return landLine;
	}
	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTermsConditions() {
		return termsConditions;
	}
	public void setTermsConditions(String termsConditions) {
		this.termsConditions = termsConditions;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getWorkMonday() {
		return workMonday;
	}
	public void setWorkMonday(String workMonday) {
		this.workMonday = workMonday;
	}
	public String getWorkTuesday() {
		return workTuesday;
	}
	public void setWorkTuesday(String workTuesday) {
		this.workTuesday = workTuesday;
	}
	public String getWorkWednesday() {
		return workWednesday;
	}
	public void setWorkWednesday(String workWednesday) {
		this.workWednesday = workWednesday;
	}
	public String getWorkThursday() {
		return workThursday;
	}
	public void setWorkThursday(String workThursday) {
		this.workThursday = workThursday;
	}
	public String getWorkFriday() {
		return workFriday;
	}
	public void setWorkFriday(String workFriday) {
		this.workFriday = workFriday;
	}
	public String getWorkSaturday() {
		return workSaturday;
	}
	public void setWorkSaturday(String workSaturday) {
		this.workSaturday = workSaturday;
	}
	public String getWorkSunday() {
		return workSunday;
	}
	public void setWorkSunday(String workSunday) {
		this.workSunday = workSunday;
	}
	public String getVerify() {
		return verify;
	}
	public void setVerify(String verify) {
		this.verify = verify;
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

	public MultipartFile getTermsAndCondition() {
		return termsAndCondition;
	}

	public void setTermsAndCondition(MultipartFile termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}

	public File getCancellationPolicy() {
		return cancellationPolicy;
	}

	public void setCancellationPolicy(File cancellationPolicy) {
		this.cancellationPolicy = cancellationPolicy;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	@Override
	public String toString() {
		return "BranchProfile [id=" + id + ", uniqueId=" + uniqueId + ", branchName=" + branchName
				+ ", branchOwner=" + branchOwner + ", description=" + description + ", startDate=" + startDate
				+ ", contactno=" + contactNo + ", emailid=" + emailId + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipcode=" + zipcode + ", status=" + status
				+ ", managerName=" + managerName + ", managerEmail=" + managerEmail + ", managerMobile=" + managerMobile
				+ ", landLine=" + landLine + ", location=" + location + ", termsConditions=" + termsConditions
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", locationId=" + locationId + ", workMonday="
				+ workMonday + ", workTuesday=" + workTuesday + ", workWednesday=" + workWednesday + ", workThursday="
				+ workThursday + ", workFriday=" + workFriday + ", workSaturday=" + workSaturday + ", workSunday="
				+ workSunday + ", verify=" + verify + ", createdDate=" + createdDate + ", created_By=" + createdBy
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + ", aminitiesList="
				+ ", termsAndCondition=" + termsAndCondition + ", cancellationPolicy="
				+ cancellationPolicy + "]";
	}
}
