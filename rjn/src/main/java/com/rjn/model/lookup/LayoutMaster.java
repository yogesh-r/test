package com.rjn.model.lookup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tx_layout_master")
public class LayoutMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String layoutName;
	private String primaryLayout;
	private String branchId;
	private String layoutMap;
	private String floorId;
	private String floor;
	private String date;
	private String status;
	private String createdDate;
	private String lastUpdatedDate;
	private String lastUpdatedBy;

	public String getLayoutName() {
		return layoutName;
	}
	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}
	public String getPrimaryLayout() {
		return primaryLayout;
	}
	public void setPrimaryLayout(String primaryLayout) {
		this.primaryLayout = primaryLayout;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getLayoutMap() {
		return layoutMap;
	}
	public void setLayoutMap(String layoutMap) {
		this.layoutMap = layoutMap;
	}
	public String getFloorId() {
		return floorId;
	}
	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
