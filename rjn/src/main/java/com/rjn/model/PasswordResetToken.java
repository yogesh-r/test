package com.rjn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="password_reset_token") 
public class PasswordResetToken {
    private static final int EXPIRATION = 60 * 24;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  
	@Column(name = "token", nullable = false)
    private String token;
  
	@Column(name = "profile_number", nullable = false)
	private String profileNumber;
  
 /*   private Date expiryDate;*/

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public static int getExpiration() {
		return EXPIRATION;
	}
	public String getProfileNumber() {
		return profileNumber;
	}
	public void setProfileNumber(String profileNumber) {
		this.profileNumber = profileNumber;
	}
}
