package com.rjn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tx_popular_cities") 
public class PopularCity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "popular_id", nullable = false)
	private Long id;
	
	@Column(name = "city_id", nullable = false)
	private Long cityId;
	
	@Column(name = "city_name", nullable = false)
	private String cityName;
	
	@Column(name = "latitude", nullable = false)
	private double latitude;
	
	@Column(name = "longitude", nullable = false)
	private double longitude;
	
	@Column(name = "img", nullable = false)
	private String img;
	
	@Column(name = "branch_count", nullable = false)
	private String branchCount;
	
	@Column(name = "last_updated_date", nullable = false)
	private String lastUpdatedDate;
	
	@Column(name = "location_name", nullable = false)
	private String locationName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getBranchCount() {
		return branchCount;
	}

	public void setBranchCount(String branchCount) {
		this.branchCount = branchCount;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
}

