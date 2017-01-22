package com.rjn.model.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cy_meter_details") 
public class MeterDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String partnerId;
	private String entityName;
	private String limitValue;
	private String consumedValue;
	private String validFrom;
	private String validTo;
	private String status;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPartnerId() {
		return partnerId;
	}
	
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	
	public String getEntityName() {
		return entityName;
	}
	
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	public String getLimitValue() {
		return limitValue;
	}
	
	public void setLimitValue(String limitValue) {
		this.limitValue = limitValue;
	}
	
	public String getConsumedValue() {
		return consumedValue;
	}
	
	public void setConsumedValue(String consumedValue) {
		this.consumedValue = consumedValue;
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
}
