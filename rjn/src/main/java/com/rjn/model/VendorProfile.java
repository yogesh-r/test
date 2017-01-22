package com.rjn.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;
import com.rjn.model.product.VendorProduct;

@Entity
@Table(name="vendor_profile")
public class VendorProfile {
	
	@Id
	@Column(name = "Part_Id", nullable = false)
	private String id;
	
	@Column(name = "Part_F_name", nullable = false)
	private String partFName;
	
	@Column(name = "Part_Surname", nullable = false)
	private String partSurname;
	
	@Column(name = "PAN", nullable = false)
	private String PAN;
	
	@Column(name = "addr", nullable = false)
	private String addr;
	
	@Column(name = "add_1", nullable = false)
	private String add1;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "p_contact", nullable = false)
	private String pContact;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "unique_id", nullable = false)
	private String uniqueId;
	
	@Column(name = "user_id", nullable = false)
	private String userId;
	
	@Column(name = "partner_logo", nullable = false)
	private String partnerLogo;
	
	@Column(name = "zip_code", nullable = false)
	private String zipCode;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "latitude", nullable = false)
	private String latitude;
	
	@Column(name = "longitude", nullable = false)
	private String longitude;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "partId", cascade=CascadeType.ALL)
	private List<VendorProduct> products = new ArrayList<VendorProduct>();

	@Transient
	private String password;
	
	@Transient
	private MultipartFile vendorLogo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPartFName() {
		return partFName;
	}

	public void setPartFName(String partFName) {
		this.partFName = partFName;
	}

	public String getPartSurname() {
		return partSurname;
	}

	public void setPartSurname(String partSurname) {
		this.partSurname = partSurname;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getpContact() {
		return pContact;
	}

	public void setpContact(String pContact) {
		this.pContact = pContact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPartnerLogo() {
		return partnerLogo;
	}

	public void setPartnerLogo(String partnerLogo) {
		this.partnerLogo = partnerLogo;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public List<VendorProduct> getProducts() {
		return products;
	}

	public void setProducts(List<VendorProduct> products) {
		this.products = products;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MultipartFile getVendorLogo() {
		return vendorLogo;
	}

	public void setVendorLogo(MultipartFile vendorLogo) {
		this.vendorLogo = vendorLogo;
	}
}