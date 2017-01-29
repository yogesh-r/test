package com.rjn.model.Branch;

import java.io.File;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="tx_branch_master_details")
public class BranchMasterDetails { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BranchCode", nullable = false)
	private int id;
	
	@Column(name = "bracnh_unique_Id", nullable = false)
	private String uniqueId;
	
	@Column(name = "BranchName", nullable = false)
	private String branchName;
	
	@Column(name = "BranchOwner", nullable = false)
	private String branchOwner;
	
	@Column(name = "Description", nullable = false)
	private String description;
	
/*	@Column(name = "specialization", nullable = false)
	private String specialization;*/
	
	@Column(name = "StartDate", nullable = false)
	private String startDate;
	
	@Column(name = "contactno", nullable = false)
	private String contactno;
	
	@Column(name = "emailid", nullable = false)
	private String emailid;
	
/*	@Column(name = "panno", nullable = false)
	private String panno;*/
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "city", nullable = false)
	private String city;
	
/*	@Column(name = "City_Name", nullable = false)
	private String cityName;*/
	
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
	
/*	@Column(name = "house_rule", nullable = false)
	private String houseRule;*/
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "terms_conditions", nullable = false)
	private String termsConditions;
	/*
	@Column(name = "can_policy", nullable = false)
	private String canPolicy;*/
	
	@Column(name = "latitude", nullable = false)
	private String latitude;
	
	@Column(name = "longitude", nullable = false)
	private String longitude;
	
/*	@Column(name = "term_file", nullable = false)
	private String termFile;
	
	@Column(name = "cancel_file", nullable = false)
	private String cancelFile;*/
	
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
	
/*	@Column(name = "book_thru_enquiry", nullable = false)
	private String bookThruRnquiry = "Yes";
	
	@Column(name = "rating", nullable = false)
	private String rating;*/
	
	@Column(name = "verify", nullable = false)
	private String verify;
	
	@Column(name = "created_date", nullable = false)
	private String createdDate;
	
	@Column(name = "created_by", nullable = false)
	private String created_By;
	
	@Column(name = "last_updated_date", nullable = false)
	private String lastUpdatedDate;
	
	@Column(name = "last_updated_by", nullable = false)
	private String lastUpdatedBy;
	
/*	@Column(name = "license_key", nullable = false)
	private String license_key;*/
	
	@Transient
	private List<BranchFeatureMaster> aminitiesList;
	
	@Transient
	private MultipartFile termsAndCondition;
	
	@Transient
	private File cancellationPolicy;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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
	
/*	public String getSpecialization() {
		return specialization;
	}
	
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}*/
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getContactno() {
		return contactno;
	}
	
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	
	public String getEmailid() {
		return emailid;
	}
	
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
/*	public String getPanno() {
		return panno;
	}
	
	public void setPanno(String panno) {
		this.panno = panno;
	}*/
	
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
	
/*	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}*/
	
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
/*	public String getHouseRule() {
		return houseRule;
	}
	public void setHouseRule(String houseRule) {
		this.houseRule = houseRule;
	}*/
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
/*	public String getCanPolicy() {
		return canPolicy;
	}
	public void setCanPolicy(String canPolicy) {
		this.canPolicy = canPolicy;
	}*/
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
/*	public String getTermFile() {
		return termFile;
	}
	public void setTermFile(String termFile) {
		this.termFile = termFile;
	}
	public String getCancelFile() {
		return cancelFile;
	}
	public void setCancelFile(String cancelFile) {
		this.cancelFile = cancelFile;
	}*/
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
/*	public String getBookThruRnquiry() {
		return bookThruRnquiry;
	}
	public void setBookThruRnquiry(String bookThruRnquiry) {
		this.bookThruRnquiry = bookThruRnquiry;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}*/
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
	public String getCreated_By() {
		return created_By;
	}
	public void setCreated_By(String created_By) {
		this.created_By = created_By;
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
/*	public String getLicense_key() {
		return license_key;
	}
	public void setLicense_key(String license_key) {
		this.license_key = license_key;
	}*/
	public List<BranchFeatureMaster> getAminitiesList() {
		return aminitiesList;
	}
	public void setAminitiesList(List<BranchFeatureMaster> aminitiesList) {
		this.aminitiesList = aminitiesList;
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
		return "BranchMasterDetails [id=" + id + ", uniqueId=" + uniqueId + ", branchName=" + branchName
				+ ", branchOwner=" + branchOwner + ", description=" + description + ", startDate=" + startDate
				+ ", contactno=" + contactno + ", emailid=" + emailid + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipcode=" + zipcode + ", status=" + status
				+ ", managerName=" + managerName + ", managerEmail=" + managerEmail + ", managerMobile=" + managerMobile
				+ ", landLine=" + landLine + ", location=" + location + ", termsConditions=" + termsConditions
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", locationId=" + locationId + ", workMonday="
				+ workMonday + ", workTuesday=" + workTuesday + ", workWednesday=" + workWednesday + ", workThursday="
				+ workThursday + ", workFriday=" + workFriday + ", workSaturday=" + workSaturday + ", workSunday="
				+ workSunday + ", verify=" + verify + ", createdDate=" + createdDate + ", created_By=" + created_By
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + ", aminitiesList="
				+ aminitiesList + ", termsAndCondition=" + termsAndCondition + ", cancellationPolicy="
				+ cancellationPolicy + "]";
	}
	
}
