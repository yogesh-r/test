package com.rjn.model.lookup;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tx_facility_price")
public class HolidayMaster { 
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String holidayType;
	private String status;
	private String PartnerId;
	private String BranchId;
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate holiday_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHolidayType() {
		return holidayType;
	}

	public void setHolidayType(String holidayType) {
		this.holidayType = holidayType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPartnerId() {
		return PartnerId;
	}

	public void setPartnerId(String partnerId) {
		PartnerId = partnerId;
	}

	public String getBranchId() {
		return BranchId;
	}

	public void setBranchId(String branchId) {
		BranchId = branchId;
	}

	public LocalDate getHoliday_date() {
		return holiday_date;
	}

	public void setHoliday_date(LocalDate holiday_date) {
		this.holiday_date = holiday_date;
	}
}
