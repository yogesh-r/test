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
	@Column(name = "vendor_Id", nullable = false)
	private String id;
	
	@Column(name = "vendor_first_name", nullable = false)
	private String vendorFirstName;
	
	@Column(name = "vendor_surname", nullable = false)
	private String vendorSurname;
	
	@Column(name = "pan_card_no", nullable = false)
	private String panCardNo;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "city", nullable = false)
	private int city;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "p_contact", nullable = false)
	private String pContact;
	
	@Column(name = "email", nullable = false)
	private String email;
	
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

	@Column(name = "verified", nullable = false)
	private int verified;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "vendorId", cascade=CascadeType.ALL)
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

	public String getVendorFirstName() {
		return vendorFirstName;
	}

	public void setVendorFirstName(String vendorFirstName) {
		this.vendorFirstName = vendorFirstName;
	}

	public String getVendorSurname() {
		return vendorSurname;
	}

	public void setVendorSurname(String vendorSurname) {
		this.vendorSurname = vendorSurname;
	}

	public String getPanCardNo() {
		return panCardNo;
	}

	public void setPanCardNo(String pAN) {
		panCardNo = pAN;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String addr) {
		this.address = addr;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
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

	public int isVerified() {
		return verified;
	}

	public void setVerified(int verified) {
		this.verified = verified;
	}
}
