package com.rjn.model.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cy_license_page_access")
public class LicensePageAccess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int pageId;
	private String licenseName;
	private String createdDate;
	private String status = "Active";
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getPageId() {
		return pageId;
	}
	
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	
	public String getLicenseName() {
		return licenseName;
	}
	
	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
