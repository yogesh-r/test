package com.rjn.model.Branch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tx_branch_images")
public class BranchImages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String branchName; 
	private String branchOwner;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String img5;
	private String field1;
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate startDate;
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate endDate;
	
	private String comment;
	private String img6;
	private String img7;
	private String img8;
	private String img9;
	private String img10;
	private String location;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchOwner() {
		return branchOwner;
	}
	public void setBranchOwner(String branchOwner) {
		this.branchOwner = branchOwner;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	public String getImg5() {
		return img5;
	}
	public void setImg5(String img5) {
		this.img5 = img5;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getImg6() {
		return img6;
	}
	public void setImg6(String img6) {
		this.img6 = img6;
	}
	public String getImg7() {
		return img7;
	}
	public void setImg7(String img7) {
		this.img7 = img7;
	}
	public String getImg8() {
		return img8;
	}
	public void setImg8(String img8) {
		this.img8 = img8;
	}
	public String getImg9() {
		return img9;
	}
	public void setImg9(String img9) {
		this.img9 = img9;
	}
	public String getImg10() {
		return img10;
	}
	public void setImg10(String img10) {
		this.img10 = img10;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
