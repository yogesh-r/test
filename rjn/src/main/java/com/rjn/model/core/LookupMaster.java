package com.rjn.model.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cy_lookup_master") 
public class LookupMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lookup_id", nullable = false)
	private Long id;
	
	@Column(name = "lookup_type", nullable = false)
	private String lookupType;
	
	@Column(name = "lookup_code", nullable = false)
	private String lookupCode;
	
	@Column(name = "lookup_values", nullable = false)
	private String lookupValues;
	
	@Column(name = "Attribute1", nullable = false)
	private String attribute1;
	
	@Column(name = "icon", nullable = false)
	private String icon;
	
	@Column(name = "icon_images", nullable = false)
	private String iconImages;
	
	@Column(name = "parent_id", nullable = false)
	private String parentId;
	
	@Column(name = "attribute2", nullable = false)
	private String attribute2;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLookupType() {
		return lookupType;
	}
	
	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}
	
	public String getLookupCode() {
		return lookupCode;
	}
	
	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}
	
	public String getLookupValues() {
		return lookupValues;
	}
	
	public void setLookupValues(String lookupValues) {
		this.lookupValues = lookupValues;
	}
	
	public String getAttribute1() {
		return attribute1;
	}
	
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getIconImages() {
		return iconImages;
	}
	
	public void setIconImages(String iconImages) {
		this.iconImages = iconImages;
	}
	
	public String getParentId() {
		return parentId;
	}
	
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public String getAttribute2() {
		return attribute2;
	}
	
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
}
