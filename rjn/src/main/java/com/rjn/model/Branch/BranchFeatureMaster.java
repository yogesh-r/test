package com.rjn.model.Branch;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tx_branch_feature_master") 
public class BranchFeatureMaster { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "feature_id", nullable = false)
	private String featureId;
	
	@Column(name = "feature_name", nullable = false)
	private String featureName;
	
	@Column(name = "branch_id", nullable = false)
	private String branchId;
	
	@Column(name = "branch_name", nullable = false)
	private String branchName;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "chargeable", nullable = false)
	private String chargeable;
	
	@Column(name = "base_price", nullable = false)
	private double basePrice;
	
	@Column(name = "base_discount", nullable = false)
	private double baseDiscount;
	
	@Column(name = "part_share", nullable = false)
	private double partShare;
	
	@Column(name = "field_1", nullable = false)
	private String field1;
	
	@Column(name = "field_2", nullable = false)
	private String field2;
	
	@Column(name = "field_3", nullable = false)
	private String field3;
	
	@Column(name = "field_4", nullable = false)
	private String field4;
	
	@Column(name = "field_5", nullable = false)
	private String field5;
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name = "start_date", nullable = false)
	private Timestamp startDate;
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name = "end_date", nullable = false)
	private Timestamp endDate;
	 
	@Column(name = "feat_avail", nullable = false)
	private String featAvail;
	
	@Column(name = "branch_owner", nullable = false)
	private String branchOwner;
	
	@Column(name = "comment", nullable = false)
	private String comment;
	
	@Column(name = "created_date", nullable = false)
	private String createdDate;
	
	@Column(name = "created_by", nullable = false)
	private String createdBy;
	
	@Column(name = "last_updated_date", nullable = false)
	private String lastUpdatedDate;
	
	@Column(name = "last_updated_by", nullable = false)
	private String lastUpdatedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getChargeable() {
		return chargeable;
	}

	public void setChargeable(String chargeable) {
		this.chargeable = chargeable;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getBaseDiscount() {
		return baseDiscount;
	}

	public void setBaseDiscount(double baseDiscount) {
		this.baseDiscount = baseDiscount;
	}

	public double getPartShare() {
		return partShare;
	}

	public void setPartShare(double partShare) {
		this.partShare = partShare;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	public String getField5() {
		return field5;
	}

	public void setField5(String field5) {
		this.field5 = field5;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getFeatAvail() {
		return featAvail;
	}

	public void setFeatAvail(String featAvail) {
		this.featAvail = featAvail;
	}

	public String getBranchOwner() {
		return branchOwner;
	}

	public void setBranchOwner(String branchOwner) {
		this.branchOwner = branchOwner;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
