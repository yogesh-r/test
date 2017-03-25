package com.rjn.bean;

public class SearchBean { 
	
	private String vendorName;
	private String vendorId;
	private String productNmae;
	private float productPrice;
	private String img1;
	private String verify;
	private int cityId;
	
	private String searchProductKeyword;

	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getProductNmae() {
		return productNmae;
	}
	public void setProductNmae(String productNmae) {
		this.productNmae = productNmae;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getVerify() {
		return verify;
	}
	public void setVerify(String verify) {
		this.verify = verify;
	}
	public String getSearchProductKeyword() {
		return searchProductKeyword;
	}
	public void setSearchProductKeyword(String searchProductKeyword) {
		this.searchProductKeyword = searchProductKeyword;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
}