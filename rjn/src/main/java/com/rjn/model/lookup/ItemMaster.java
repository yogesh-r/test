package com.rjn.model.lookup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tx_item_master")
public class ItemMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String itemNumber;
	private String description;
	private long assetId;
	private long branchId;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getAssetId() {
		return assetId;
	}
	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}
	public long getBranchId() {
		return branchId;
	}
	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}
}
