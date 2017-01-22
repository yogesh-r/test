package com.rjn.model.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cy_license_price")
public class LicensePrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String licenseName;
	private String licenseType = "Yearly";
	private String currency = "INR";
	private String price;
	private String billingFrequency = "Monthly";
	private String validFrom;
	private String validTo;
	private String status = "Active";
	private String createdDate;
	private String createdBy;
	private String lastUpdatedDate;
	private String lastUpdatedBy;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLicenseName() {
		return licenseName;
	}
	
	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}
	
	public String getLicenseType() {
		return licenseType;
	}
	
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getBillingFrequency() {
		return billingFrequency;
	}
	
	public void setBillingFrequency(String billingFrequency) {
		this.billingFrequency = billingFrequency;
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
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
}
