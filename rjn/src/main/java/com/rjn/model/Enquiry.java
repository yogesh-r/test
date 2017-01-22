package com.rjn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="enquiry_details")
public class Enquiry {
	@Id
	private int id;
	
	@Column(name="venue_manager_name")
	private String venue_manager_name;
	
	@Column(name="venue_manager_email")
	private String venue_manager_email;
	
	@Column(name="venue_manager_ph")
	private String venue_manager_ph;
	
	@Column(name="venue_manager_subject")
	private String venue_manager_subject;
	
	@Column(name="venue_manager_message")
	private String venue_manager_message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVenue_manager_name() {
		return venue_manager_name;
	}

	public void setVenue_manager_name(String venue_manager_name) {
		this.venue_manager_name = venue_manager_name;
	}

	public String getVenue_manager_email() {
		return venue_manager_email;
	}

	public void setVenue_manager_email(String venue_manager_email) {
		this.venue_manager_email = venue_manager_email;
	}

	public String getVenue_manager_ph() {
		return venue_manager_ph;
	}

	public void setVenue_manager_ph(String venue_manager_ph) {
		this.venue_manager_ph = venue_manager_ph;
	}

	public String getVenue_manager_subject() {
		return venue_manager_subject;
	}

	public void setVenue_manager_subject(String venue_manager_subject) {
		this.venue_manager_subject = venue_manager_subject;
	}

	public String getVenue_manager_message() {
		return venue_manager_message;
	}

	public void setVenue_manager_message(String venue_manager_message) {
		this.venue_manager_message = venue_manager_message;
	}
	
	public String toString(){
		return "enquiry_details[id="+id+",venue_mamager_name="+venue_manager_name+",venue_manager_email="+venue_manager_email+","
				+ "venue_manager_ph="+venue_manager_ph+",venue_manager_subject="+venue_manager_subject+",venue_manager_message="+venue_manager_name+"]";
		
		
	}
}
