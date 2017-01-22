package com.rjn.model;

/*
 * Author Baliram 
 * 20-july-2016
 */
public class ServiceRequest {
	
	private int id;
	
	private String branchId;
	
	private String custProfileId;
	
	private String issueName;
	
	private String issueDescription;
	
	private String  priority;
	
	private String createdDate;

	private String  lastUpdateDate;
	
	private String dueDate;
	
	private String status;
	
	private String assignedTo;
	
	private String comments;
	
	private String resolution;
	
	private String custFeedback;
	
	private String srNo;
	
	private String createdBy;
	
	private String lastUpdatedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getCustProfileId() {
		return custProfileId;
	}

	public void setCustProfileId(String custProfileId) {
		this.custProfileId = custProfileId;
	}

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getCustFeedback() {
		return custFeedback;
	}

	public void setCustFeedback(String custFeedback) {
		this.custFeedback = custFeedback;
	}

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
}
