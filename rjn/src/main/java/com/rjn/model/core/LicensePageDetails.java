package com.rjn.model.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cy_license_page_details")
public class LicensePageDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String pageNumber;
	private String pageName;
	private String pageFileName;
	private String status;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPageNumber() {
		return pageNumber;
	}
	
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public String getPageName() {
		return pageName;
	}
	
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	public String getPageFileName() {
		return pageFileName;
	}
	
	public void setPageFileName(String pageFileName) {
		this.pageFileName = pageFileName;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
