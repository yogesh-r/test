package com.rjn.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tx_vendor_product")
public class VendorProduct { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id; 
	
	@Column(name = "unique_id", nullable = false)
	private String uniqueId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "product_category_id", nullable = false)
	private int productCategoryId;
	
	@Column(name = "image_id", nullable = false)
	private int imageId;
	
	@Column(name = "Part_Id", nullable = false)
	private String partId;
	
	@Column(name = "keyword")
	private String keyWord;

	@Column(name = "branch_id")
	private int branchId;

	@Column(name = "branch_name")
	private String branchName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getPartId() {
		return partId;
	}

	public void setPartId(String partId) {
		this.partId = partId;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	
	
	
}
